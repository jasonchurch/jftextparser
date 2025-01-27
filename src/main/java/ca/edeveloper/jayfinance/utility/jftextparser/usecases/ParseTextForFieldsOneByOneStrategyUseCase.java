package ca.edeveloper.jayfinance.utility.jftextparser.usecases;

import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldMatcherItem;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldMatcherItemResult;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserConfig;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserResults;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * - Loop through field matchers in FieldParserConfig
 * - For each matcher, try to find match
 *   - create a FieldMatcherItemResult*
 *     - if no match, set hadError true and errorMsg "No Match Found"
 *     - if multiple matches, set hasError true and error message "multiple matches"
 *       - unless matcher allowsMultipleMatches, then set field "" and isFound true
 *     - if match set field to match group, set isFound true
 *     - if match and multiple groups, set field to concat of each match group and set isFound true
 *   - create fieldMatcherItemResult with find match as field,
 * - Return FieldParserResults containing all matches
 */
public class ParseTextForFieldsOneByOneStrategyUseCase implements ParseTextForFieldsUseCase {
    protected String contentToParse;
    protected FieldParserConfig parserConfig;
        private static final Logger LOGGER = Logger.getLogger(ParseTextForFieldsOneByOneStrategyUseCase.class.getName());

    public ParseTextForFieldsOneByOneStrategyUseCase(String content, FieldParserConfig config) {
        this.contentToParse = content;
        this.parserConfig = config;
    }
    
    @Override
    public FieldParserResults parse() {
        validation();
        return processFieldsMatchers(parserConfig.getFieldMatcherItemMap(), contentToParse);
    }

    void validation() {
        if (contentToParse == null || contentToParse.isEmpty()) {
            throw new IllegalArgumentException("Content to parse cannot be null or empty");
        }
        if (parserConfig == null) {
            throw new IllegalStateException("Parser configuration must be loaded before parsing");
        }
        if (parserConfig.getFieldMatcherItemMap().isEmpty()) {
            throw new IllegalStateException("Parser configuration must have at least one fieldMatcher");
        }

    }


    
    public FieldParserResults processFieldsMatchers(Map<String, FieldMatcherItem> fieldMatcherItemMap, String contentToParse) {
        FieldParserResults results = new FieldParserResults();
        try {
            Map<String, FieldMatcherItemResult> resultsMap = fieldMatcherItemMap.entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            entry -> findField(entry.getValue(), contentToParse)
                    ));
            results.getFieldMatcherItemResultsMap().putAll(resultsMap);
            return results;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error parsing text", e);
            throw new RuntimeException("Failed to parse text", e);
        }
    }
    
    FieldMatcherItemResult findField(FieldMatcherItem item, String content) {
        FieldMatcherItemResult result = new FieldMatcherItemResult();
        result.setRequired(item.isRequired()); // Set the isRequired field
        try {
            Pattern pattern = Pattern.compile(item.getMatchingPattern());
            Matcher matcher = pattern.matcher(content);
            if (matcher.find()) {
                List<String> groups = new ArrayList<>();
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    groups.add(matcher.group(i));
                }
                result.setField(groups);
                result.setFound(true);
            } else {
                result.setFound(false);
                if (item.isRequired()) {
                    result.setHasError(true);
                    result.setErrorMessage("Required field not found: " + item.getMatchingPattern());
                }
            }
        } catch (Exception e) {
            result.setHasError(true);
            result.setErrorMessage(e.getMessage());
        }
        return result;
    }
}

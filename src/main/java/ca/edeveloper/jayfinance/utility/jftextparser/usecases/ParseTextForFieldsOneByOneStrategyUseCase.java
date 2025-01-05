
package ca.edeveloper.jayfinance.utility.jftextparser.usecases;

import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldMatcherItem;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldMatcherItemResult;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserConfig;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserResults;

import java.util.AbstractMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class ParseTextForFieldsUseCase {
    protected String contentToParse;
    protected FieldParserConfig parserConfig;
        private static final Logger LOGGER = Logger.getLogger(ParseTextForFieldsUseCase.class.getName());

    public ParseTextForFieldsUseCase(String content, FieldParserConfig config) {
        this.contentToParse = content;
        this.parserConfig = config;
    }
    
    public FieldParserResults parse() {
        if (contentToParse == null || contentToParse.isEmpty()) {
            throw new IllegalArgumentException("Content to parse cannot be null or empty");
        }
        if (parserConfig == null) {
            throw new IllegalStateException("Parser configuration must be loaded before parsing");
        }
        if (parserConfig.getFieldMatcherItemMap().size() == 0) {
            throw new IllegalStateException("Parser configuration must have at least one fieldMatcher");
        }
        
        try {
            FieldParserResults results = new FieldParserResults();
            parserConfig.getFieldMatcherItemMap().entrySet().stream()
                    .forEach(config ->  new AbstractMap.SimpleEntry<String, FieldMatcherItemResult>(config.getKey(), findMatches(config.getValue(), this.contentToParse))
                    );
            return results;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error parsing text", e);
            throw new RuntimeException("Failed to parse text", e);
        }
    }
    // Additional methods if necessary for parsing

    FieldMatcherItemResult findMatches(FieldMatcherItem item, String content) {
        return new FieldMatcherItemResult();
    }
}

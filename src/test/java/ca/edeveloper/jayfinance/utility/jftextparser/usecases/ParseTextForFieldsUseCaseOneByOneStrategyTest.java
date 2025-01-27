package ca.edeveloper.jayfinance.utility.jftextparser.usecases;

import ca.edeveloper.jayfinance.utility.jftextparser.SimpleClasspathFileReader;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserConfig;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserResults;
import ca.edeveloper.jayfinance.utility.jftextparser.infrastructure.LoadFieldParserConfigFromYAMLUseCase;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ParseTextForFieldsUseCaseOneByOneStrategyTest {

    @Test    
    void testHappyPathUseCase() {
        String content = SimpleClasspathFileReader.readFileFromClasspath("contentToParseFakeConfirm.txt");
        FieldParserConfig config;
        LoadFieldParserConfigFromYAMLUseCase loadFieldParserConfigFromYAMLUseCase = new LoadFieldParserConfigFromYAMLUseCase("ConfirmsFieldTextParserConfig.yaml");
        try {
            config = loadFieldParserConfigFromYAMLUseCase.execute();
        } catch (ParserConfigException e) {
            throw new RuntimeException(e);
        }
        ParseTextForFieldsUseCase useCase = new ParseTextForFieldsOneByOneStrategyUseCase(content, config);
    
        FieldParserResults results = useCase.parse();
        System.out.printf("result size: %d%n", results.getFieldMatcherItemResultsMap().size());
        results.getFieldMatcherItemResultsMap().forEach((k, v) -> {
            System.out.printf("key: %s%n", k);
            System.out.printf("value: %s%n", v);
            assertFalse(v.hasError(), "Field " + k + " has an error: " + v.getErrorMessage());
            System.out.printf("isRequired: %b%n", v.isRequired());
        });
    }

}
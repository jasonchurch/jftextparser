package ca.edeveloper.jayfinance.utility.jftextparser.usecases;

import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserConfig;
import ca.edeveloper.jayfinance.utility.jftextparser.infrastructure.LoadFieldParserConfigFromYAMLUseCase;
import org.junit.jupiter.api.Test;

class ParseTextForFieldsUseCaseTest {

    @Test
    void testHappyPathUseCase () {
        String content = "testing123\ntesting123";
        FieldParserConfig config;
        LoadFieldParserConfigFromYAMLUseCase loadFieldParserConfigFromYAMLUseCase = new LoadFieldParserConfigFromYAMLUseCase("FieldTextParserConfigText1.yaml");
        try {
            config = loadFieldParserConfigFromYAMLUseCase.execute();
        } catch (ParserConfigException e) {
            throw new RuntimeException(e);
        }
        ParseTextForFieldsOneByOneStrategyUseCase useCase = new ParseTextForFieldsOneByOneStrategyUseCase(content, config);

        useCase.parse();
    }

}
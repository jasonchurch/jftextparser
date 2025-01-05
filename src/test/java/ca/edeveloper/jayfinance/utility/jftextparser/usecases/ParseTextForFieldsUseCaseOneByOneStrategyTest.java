package ca.edeveloper.jayfinance.utility.jftextparser.usecases;

import ca.edeveloper.jayfinance.utility.jftextparser.SimpleClasspathFileReader;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserConfig;
import ca.edeveloper.jayfinance.utility.jftextparser.infrastructure.LoadFieldParserConfigFromYAMLUseCase;
import org.junit.jupiter.api.Test;

class ParseTextForFieldsUseCaseOneByOneStrategyTest {

    @Test
    void testHappyPathUseCase () {
        String content = SimpleClasspathFileReader.readFileFromClasspath("contentToParseFakeConfirm.txt");
        FieldParserConfig config;
        LoadFieldParserConfigFromYAMLUseCase loadFieldParserConfigFromYAMLUseCase = new LoadFieldParserConfigFromYAMLUseCase("FieldTextParserConfigText1.yaml");
        try {
            config = loadFieldParserConfigFromYAMLUseCase.execute();
        } catch (ParserConfigException e) {
            throw new RuntimeException(e);
        }
        ParseTextForFieldsUseCase useCase = new ParseTextForFieldsOneByOneStrategyUseCase(content, config);

        useCase.parse();
    }

}

package ca.edeveloper.jayfinance.utility.jftextparser.infrastructure;

import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserConfig;
import ca.edeveloper.jayfinance.utility.jftextparser.usecases.LoadFieldParserConfigUseCase;
import ca.edeveloper.jayfinance.utility.jftextparser.usecases.ParserConfigException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class LoadFieldParserConfigFromYAMLUseCaseTest {

    @Test
    void executeSuccess() throws ParserConfigException {
        LoadFieldParserConfigFromYAMLUseCase loadFieldParserConfigFromYAMLUseCase = new LoadFieldParserConfigFromYAMLUseCase("FieldTextParserConfigText1.yaml");
        FieldParserConfig config = loadFieldParserConfigFromYAMLUseCase.execute();
        assertNotNull(config);
        assertEquals("This is a description for field1. For example, it could be a social security number.", config.getFieldMatcherItemMap().get("field1").getDescription());
        assertEquals("^\\d{3}-\\d{2}-\\d{4}$", config.getFieldMatcherItemMap().get("field1").getMatchingPattern());
        assertEquals(3, config.getFieldMatcherItemMap().size());
    }

    @Test
    void executeFailureFileNotFound() {
        LoadFieldParserConfigUseCase loadFieldParserConfigFromYAMLUseCase = new LoadFieldParserConfigFromYAMLUseCase("NonExistentFile.yaml");
        assertThrows(ParserConfigException.class, () -> loadFieldParserConfigFromYAMLUseCase.execute());
    }

    @Test
    void executeFailureMalformedYAML() {
        LoadFieldParserConfigFromYAMLUseCase loadFieldParserConfigFromYAMLUseCase = new LoadFieldParserConfigFromYAMLUseCase("MalformedFieldTextParserConfigText.yaml");
        assertThrows(ParserConfigException.class, () -> loadFieldParserConfigFromYAMLUseCase.execute());
    }
}

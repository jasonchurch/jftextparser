package ca.edeveloper.jayfinance.utility.jftextparser.infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoadFieldParserConfigFromYAMLUseCaseTest {
    @Test
    void execute() {
        LoadFieldParserConfigFromYAMLUseCase loadFieldParserConfigFromYAMLUseCase = new LoadFieldParserConfigFromYAMLUseCase("FieldTextParserConfigText1.yaml");
        assertNotNull(loadFieldParserConfigFromYAMLUseCase.execute());
    }
}
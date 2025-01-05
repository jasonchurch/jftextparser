package ca.edeveloper.jayfinance.utility.jftextparser.usecases;

import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldMatcherItem;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldMatcherItemResult;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserConfig;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class ParseTextForFieldsOneByOneStrategyUseCaseTest {

    private ParseTextForFieldsOneByOneStrategyUseCase useCase;
    private FieldParserConfig parserConfig;
    private String contentToParse;

    @BeforeEach
    public void setUp() {
        contentToParse = "Sample text with field1 and field2";
        parserConfig = new FieldParserConfig();
        Map<String, FieldMatcherItem> fieldMatcherItemMap = new HashMap<>();
        fieldMatcherItemMap.put("field1", new FieldMatcherItem("field1", false, "field1 description"));
        fieldMatcherItemMap.put("field2", new FieldMatcherItem("field2", false, "field2 description"));
        parserConfig.setFieldMatcherItemMap(fieldMatcherItemMap);
        useCase = new ParseTextForFieldsOneByOneStrategyUseCase(contentToParse, parserConfig);
    }

    @Test
    public void testListOf() {
        List<String> list = List.of("1", "2", "3");
        assertEquals(3, list.size());
    }

    @Test
    public void testParseSuccess() {
        FieldParserResults results = useCase.parse();
        assertNotNull(results);
        assertFalse(results.getFieldMatcherItemResultsMap().isEmpty());
        assertTrue(results.getFieldMatcherItemResultsMap().get("field1").isFound());
        assertTrue(results.getFieldMatcherItemResultsMap().get("field2").isFound());
    }

    @Test
    public void testParseNoMatch() {
        contentToParse = "No matching fields here";
        useCase = new ParseTextForFieldsOneByOneStrategyUseCase(contentToParse, parserConfig);
        FieldParserResults results = useCase.parse();
        assertNotNull(results);
        assertFalse(results.getFieldMatcherItemResultsMap().isEmpty());
        assertFalse(results.getFieldMatcherItemResultsMap().get("field1").isFound());
        assertFalse(results.getFieldMatcherItemResultsMap().get("field2").isFound());
    }

    @Test
    public void testValidationThrowsExceptionForEmptyContent() {
        contentToParse = "";
        useCase = new ParseTextForFieldsOneByOneStrategyUseCase(contentToParse, parserConfig);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> useCase.parse());
        assertEquals("Content to parse cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testValidationThrowsExceptionForNullConfig() {
        parserConfig = null;
        useCase = new ParseTextForFieldsOneByOneStrategyUseCase(contentToParse, parserConfig);
        Exception exception = assertThrows(IllegalStateException.class, () -> useCase.parse());
        assertEquals("Parser configuration must be loaded before parsing", exception.getMessage());
    }

    @Test
    public void testValidationThrowsExceptionForEmptyFieldMatcherMap() {
        parserConfig.setFieldMatcherItemMap(new HashMap<>());
        useCase = new ParseTextForFieldsOneByOneStrategyUseCase(contentToParse, parserConfig);
        Exception exception = assertThrows(IllegalStateException.class, () -> useCase.parse());
        assertEquals("Parser configuration must have at least one fieldMatcher", exception.getMessage());
    }
}
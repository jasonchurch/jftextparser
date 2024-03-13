package ca.edeveloper.jayfinance.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FieldTextParserConfigTest {

    @Test
    public void testFieldTextParserConfigFromClassPath() {
        FieldTextParserConfig fieldTextParserConfig = new FieldTextParserConfig("FieldTextParserConfigText1.yaml");
        Map<String, Object> configMap = fieldTextParserConfig.getConfigMap();
        Assertions.assertNotNull(configMap);
        Map<String, String> fields = (Map<String, String>) configMap.get("fields");
        Assertions.assertEquals("[field1, field2, field3]", fields.keySet().toString());
        //Assertions.assertEquals("", fields.get("field1",));
    }

}
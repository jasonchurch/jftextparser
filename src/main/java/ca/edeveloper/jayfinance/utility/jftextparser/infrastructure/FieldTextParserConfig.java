package ca.edeveloper.jayfinance.utility.jftextparser.infrastructure;

import java.util.Map;

public class FieldTextParserConfig {
    private Map<String, FieldConfigItem> fields;

    // Getters and Setters
    public Map<String, FieldConfigItem> getFields() {
        return fields;
    }

    public void setFields(Map<String, FieldConfigItem> fields) {
        this.fields = fields;
    }
}

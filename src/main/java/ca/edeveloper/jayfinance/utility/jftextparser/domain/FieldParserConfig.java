package ca.edeveloper.jayfinance.utility.jftextparser.domain;

import java.util.HashMap;
import java.util.Map;

public class FieldParserConfig {
    Map<String,FieldMatcherItem> fieldMatcherItemMap = new HashMap<>();

    public Map<String, FieldMatcherItem> getFieldMatcherItemMap() {
        return fieldMatcherItemMap;
    }

    public void setFieldMatcherItemMap(Map<String, FieldMatcherItem> matcherItemMap) {
        this.fieldMatcherItemMap = matcherItemMap;
    }
}

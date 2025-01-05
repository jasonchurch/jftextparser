package ca.edeveloper.jayfinance.utility.jftextparser.domain;

import java.util.HashMap;
import java.util.Map;

public class FieldParserResults {
    public Map<String, FieldMatcherItemResult> getFieldMatcherItemResultsMap() {
        return fieldMatcherItemResultsMap;
    }

     Map<String,FieldMatcherItemResult> fieldMatcherItemResultsMap = new HashMap<>();
}

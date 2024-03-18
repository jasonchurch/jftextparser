package ca.edeveloper.jayfinance.utility.jftextparser.infrastructure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldConfigItem {
    @JsonProperty("matchingPatterns")
    private String matchingPattern;

    @JsonProperty("required_flag")
    private boolean requiredFlag;

    private String description;

    // Getters and Setters
    public String getMatchingPattern() {
        return matchingPattern;
    }

    public void setMatchingPattern(String matchingPattern) {
        this.matchingPattern = matchingPattern;
    }

    public boolean isRequiredFlag() {
        return requiredFlag;
    }

    public void setRequiredFlag(boolean requiredFlag) {
        this.requiredFlag = requiredFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

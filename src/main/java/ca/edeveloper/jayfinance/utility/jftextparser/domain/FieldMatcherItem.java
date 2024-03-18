package ca.edeveloper.jayfinance.utility.jftextparser.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldMatcherItem {

    @JsonProperty("matchingPattern")
    private String matchingPattern;
    private boolean required;
    private String description;

    // Getters and Setters
    public String getMatchingPattern() {
        return matchingPattern;
    }

    public void setMatchingPattern(String matchingPattern) {
        this.matchingPattern = matchingPattern;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
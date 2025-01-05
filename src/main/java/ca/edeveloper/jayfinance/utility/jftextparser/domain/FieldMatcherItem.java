package ca.edeveloper.jayfinance.utility.jftextparser.domain;

import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * Represents an item that matches a specific field pattern.
 * This class is used to define the pattern, whether it is required, 
 * and a description of the field.
 * 
 * <p>Example usage:</p>
 * <pre>
 *     FieldMatcherItem item = new FieldMatcherItem();
 *     item.setMatchingPattern("somePattern");
 *     item.setRequired(true);
 *     item.setDescription("This is a description.");
 * </pre>
 * 
 * <p>Attributes:</p>
 * <ul>
 *   <li>matchingPattern: The pattern to match against the field.</li>
 *   <li>required: Indicates if the field is required.</li>
 *   <li>description: A description of the field.</li>
 * </ul>
 * 
 * <p>Annotations:</p>
 * <ul>
 *   <li>@JsonProperty("matchingPattern"): Maps the JSON property "matchingPattern" to the matchingPattern field.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #getMatchingPattern()}: Returns the matching pattern.</li>
 *   <li>{@link #setMatchingPattern(String)}: Sets the matching pattern.</li>
 *   <li>{@link #isRequired()}: Returns whether the field is required.</li>
 *   <li>{@link #setRequired(boolean)}: Sets whether the field is required.</li>
 *   <li>{@link #getDescription()}: Returns the description of the field.</li>
 *   <li>{@link #setDescription(String)}: Sets the description of the field.</li>
 * </ul>
 */
public class FieldMatcherItem {

    @JsonProperty("matchingPattern")
    private String matchingPattern;
    private boolean required;
    private String description;

    

    public FieldMatcherItem() {
        
    }

    public FieldMatcherItem(String matchingPattern, boolean required, String description) {
        this.matchingPattern = matchingPattern;
        this.required = required;
        this.description = description;
    }

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
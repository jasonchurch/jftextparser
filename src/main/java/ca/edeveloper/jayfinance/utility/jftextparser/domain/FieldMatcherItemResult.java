package ca.edeveloper.jayfinance.utility.jftextparser.domain;

import java.util.List;

/**
 * Represents the result of matching a field in text parsing.
 */
public class FieldMatcherItemResult {
    private List<String> field; // The matched field values
    private boolean isFound; // Indicates if the field was found
    private boolean hasError; // Indicates if there was an error during matching
    private String errorMessage; // The error message if an error occurred
    private boolean isRequired; // Indicates if the field is required

    /**
     * Default constructor.
     */
    public FieldMatcherItemResult() {
    }

    /**
     * Parameterized constructor.
     *
     * @param field The matched field values
     * @param isFound Indicates if the field was found
     * @param hasError Indicates if there was an error during matching
     * @param errorMessage The error message if an error occurred
     * @param isRequired Indicates if the field is required
     */
    public FieldMatcherItemResult(List<String> field, boolean isFound, boolean hasError, String errorMessage, boolean isRequired) {
        this.field = field;
        this.isFound = isFound;
        this.hasError = hasError;
        this.errorMessage = errorMessage;
        this.isRequired = isRequired;
    }

    /**
     * Gets the matched field values.
     *
     * @return The matched field values
     */
    public List<String> getField() {
        return field;
    }

    /**
     * Sets the matched field values.
     *
     * @param field The matched field values
     */
    public void setField(List<String> field) {
        this.field = field;
    }

    /**
     * Checks if the field was found.
     *
     * @return true if the field was found, false otherwise
     */
    public boolean isFound() {
        return isFound;
    }

    /**
     * Sets whether the field was found.
     *
     * @param isFound true if the field was found, false otherwise
     */
    public void setFound(boolean isFound) {
        this.isFound = isFound;
    }

    /**
     * Checks if there was an error during matching.
     *
     * @return true if there was an error, false otherwise
     */
    public boolean hasError() {
        return hasError;
    }

    /**
     * Sets whether there was an error during matching.
     *
     * @param hasError true if there was an error, false otherwise
     */
    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    /**
     * Gets the error message if an error occurred.
     *
     * @return The error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message if an error occurred.
     *
     * @param errorMessage The error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Checks if the field is required.
     *
     * @return true if the field is required, false otherwise
     */
    public boolean isRequired() {
        return isRequired;
    }

    /**
     * Sets whether the field is required.
     *
     * @param isRequired true if the field is required, false otherwise
     */
    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }
    
    //a toString method
    @Override
    public String toString() {
        return "FieldMatcherItemResult{" +
                "field=" + field +
                ", isFound=" + isFound +
                ", hasError=" + hasError +
                ", errorMessage='" + errorMessage + '\'' +
                ", isRequired=" + isRequired +
                '}';
    }
}

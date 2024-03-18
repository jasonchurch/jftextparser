package ca.edeveloper.jayfinance.utility.jftextparser.usecases;

import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserConfig;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserResults;

public class ParseTextForFieldsUseCase {
    protected String contentToParse;
    protected FieldParserConfig parserConfig;
    protected LoadFieldParserConfigUseCase loadFieldParserConfigUseCase;

    public ParseTextForFieldsUseCase(String contentToParse, LoadFieldParserConfigUseCase loadFieldParserConfigUseCase) {
        this.contentToParse = contentToParse;
        this.loadFieldParserConfigUseCase = loadFieldParserConfigUseCase;
        this.parserConfig = loadFieldParserConfigUseCase.execute();
    }
     FieldParserResults execute() {
         return null;
     }
}

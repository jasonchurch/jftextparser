package ca.edeveloper.jayfinance.utility.jftextparser.infrastructure;

import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldMatcherItem;
import ca.edeveloper.jayfinance.utility.jftextparser.domain.FieldParserConfig;
import ca.edeveloper.jayfinance.utility.jftextparser.usecases.LoadFieldParserConfigUseCase;


import ca.edeveloper.jayfinance.utility.jftextparser.usecases.ParserConfigException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class LoadFieldParserConfigFromYAMLUseCase implements LoadFieldParserConfigUseCase {

    private final String fileName;

    LoadFieldParserConfigFromYAMLUseCase(String filename) {
        this.fileName = filename;
    }

    @Override
    public FieldParserConfig execute() throws ParserConfigException {
        try {
            FieldTextParserConfig fieldTextParserConfig = readConfig(fileName);
            return convertToFieldParserConfig(fieldTextParserConfig);
        } catch(IOException e) {
            throw new ParserConfigException("", e);
        }
    }

    private FieldTextParserConfig readConfig(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        InputStream inputStream = null;

        // First, try to load from the filesystem
        File file = new File(path);
        if (file.exists()) {
            inputStream = new FileInputStream(file);
        } else {
            // If not found, try to load from the classpath
            inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
            if (inputStream == null) {
                throw new FileNotFoundException("Config file not found: " + path);
            }
        }

        // Deserialize the YAML file into a FieldTextParserConfig object
        FieldTextParserConfig config = mapper.readValue(inputStream, FieldTextParserConfig.class);
        return config;
    }

    private FieldParserConfig convertToFieldParserConfig(FieldTextParserConfig textConfig) {
        FieldParserConfig parserConfig = new FieldParserConfig();
        Map<String, FieldMatcherItem> matcherItemMap = new HashMap<>();

        for (Map.Entry<String, FieldConfigItem> entry : textConfig.getFields().entrySet()) {
            FieldMatcherItem matcherItem = new FieldMatcherItem();
            matcherItem.setMatchingPattern(entry.getValue().getMatchingPattern());
            matcherItem.setRequired(entry.getValue().isRequiredFlag());
            matcherItem.setDescription(entry.getValue().getDescription());

            matcherItemMap.put(entry.getKey(), matcherItem);
        }
        parserConfig.setFieldMatcherItemMap(matcherItemMap);
        return parserConfig;
    }
}

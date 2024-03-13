package ca.edeveloper.jayfinance.utility;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
public class FieldTextParserConfig {
    private Map<String, Object> configMap;

    // Constructor for classpath resources
    public FieldTextParserConfig(String resourcePath) {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Resource not found: " + resourcePath);
            }
            configMap = yaml.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            configMap = new HashMap<>();
        }
    }

    // Constructor for filesystem resources
    public FieldTextParserConfig(String filePath, boolean isFileSystem) {
        if (!isFileSystem) {
            throw new IllegalArgumentException("Use the other constructor for classpath resources");
        }
        Yaml yaml = new Yaml();
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            configMap = yaml.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            configMap = new HashMap<>();
        }
    }

    public Map<String, Object> getConfigMap() {
        return configMap;
    }

}

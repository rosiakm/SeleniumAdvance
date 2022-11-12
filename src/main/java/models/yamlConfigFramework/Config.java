package models.yamlConfigFramework;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Config {
    public Browser browser;
    public Environment environment;
    public TestData testData;
}

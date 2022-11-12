package providers;

import helpers.yamlConfigFramework.YamlReader;
import models.yamlConfigFramework.Browser;
import models.yamlConfigFramework.Environment;
import models.yamlConfigFramework.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class YamlProvider {
    private Logger log = LoggerFactory.getLogger(YamlProvider.class);
    YamlReader yamlReader = new YamlReader();
    protected Environment environment;
    protected Browser browser;
    protected TestData testData;

    private YamlProvider(){
        setBrowserProperties();
        setEnvironmentProperties();
        setDataProperties();
    }

    public static YamlProvider getInstance(){
        return YamlProvider.yamlProviderSingleton.INSTANCE;
    }
    private static class yamlProviderSingleton{
        private static final YamlProvider INSTANCE = new YamlProvider();
    }

    private void setDataProperties() {
        testData = yamlReader.getConfig().getTestData();
        Map<String,Object> dataProperties = testData.getData();
        for (Map.Entry entry : dataProperties.entrySet()){
            System.setProperty(entry.getKey().toString(),entry.getValue().toString());
            log.info("Load testData properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private void setEnvironmentProperties() {
        environment = yamlReader.getConfig().getEnvironment();
        Map<String,Object> envProperties = environment.getEnvArguments();
        for (Map.Entry entry : envProperties.entrySet()){
            System.setProperty(entry.getKey().toString(),entry.getValue().toString());
            log.info("Load env properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }

    private void setBrowserProperties() {
        browser = yamlReader.getConfig().getBrowser();
        Map<String,Object> browserProperties = browser.getBrowserArguments();
        for(Map.Entry entry : browserProperties.entrySet()){
            System.setProperty(entry.getKey().toString(),entry.getValue().toString());
            log.info("Load browser properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }
}

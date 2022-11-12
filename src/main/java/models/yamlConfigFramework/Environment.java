package models.yamlConfigFramework;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;
@Data
@NoArgsConstructor
public class Environment {
    Map<String, Object> envArguments = new LinkedHashMap<>();

    @JsonAnySetter
    void setEnvArguments (String key, Object value){
        envArguments.put(key, value);
    }
    @JsonAnyGetter
    public Map<String, Object> getEnvArguments(){
        return envArguments;
    }
}

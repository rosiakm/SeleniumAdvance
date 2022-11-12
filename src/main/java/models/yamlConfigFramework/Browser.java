package models.yamlConfigFramework;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Browser {
    Map<String, Object> browserArguments = new LinkedHashMap<>();

    @JsonAnySetter
    void setBrowserArguments (String key, Object value){
        browserArguments.put(key, value);
    }
    @JsonAnyGetter
    public Map<String, Object> getBrowserArguments(){
        return browserArguments;
    }
}

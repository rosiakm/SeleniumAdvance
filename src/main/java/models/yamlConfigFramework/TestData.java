package models.yamlConfigFramework;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class TestData {
    Map<String, Object> data = new LinkedHashMap<>();

    @JsonAnySetter
    void setData (String key, Object value){
        data.put(key, value);
    }
    @JsonAnyGetter
    public Map<String, Object> getData(){
        return data;
    }
}

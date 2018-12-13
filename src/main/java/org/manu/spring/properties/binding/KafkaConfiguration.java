package org.manu.spring.properties.binding;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "kafka")
@Data
public class KafkaConfiguration {
    private List<String> server;
    private Serializer serializer = new Serializer();
    private Map<String, String> topicMap = new HashMap<>();




    @Data
    public class Serializer{
        private String key;
        private String value;
    }
}

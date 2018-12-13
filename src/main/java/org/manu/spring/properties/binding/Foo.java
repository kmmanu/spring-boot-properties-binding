package org.manu.spring.properties.binding;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "foo")
@Data
public class Foo {
    private final Map<String,Integer> items = new HashMap<>();
    private final Map<String,Map<String, Integer>> nested = new HashMap<>();
}

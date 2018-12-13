package org.manu.spring.properties.binding;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "cassandra")
@Data
@Getter
public class CassandraConfiguration {
    private List<String> server;
    private String user;
    private String password;

    @Getter(AccessLevel.NONE)
    private Keyspace keyspace;

    public Keyspace getKeyspace() {
        if(keyspace == null){
            this.keyspace = new Keyspace();
        }
        return keyspace;
    }

    @Data
    public class Keyspace{
        private String name;
        private String readConsistency;
        private String writeConsistency;
    }
}

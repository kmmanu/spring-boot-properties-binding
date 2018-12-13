package org.manu.spring.properties.binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties({CassandraConfiguration.class,
        KafkaConfiguration.class,
        Foo.class})
public class PropertiesBindingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesBindingApplication.class, args);
        System.out.println("\nCasandra binding = " + cassandraConfiguration);
        System.out.println("\nKafka binding = " + kafkaConfiguration);
        System.out.println("\nFoo binding = " + foo);
    }

    @Autowired
    private CassandraConfiguration cassandraConfigurationInstance;
    @Autowired
    private KafkaConfiguration kafkaConfigurationInstance;
    @Autowired
    private Foo fooInstance;

    private static Foo foo;
    private static CassandraConfiguration cassandraConfiguration;
    private static KafkaConfiguration kafkaConfiguration;

    @PostConstruct
    public void init() {
        cassandraConfiguration = cassandraConfigurationInstance;
        kafkaConfiguration = kafkaConfigurationInstance;
        foo = fooInstance;
    }

}


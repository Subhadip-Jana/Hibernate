package org.hit.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hit.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "org.hit")
public class SpringConfig {

    @Bean
    public SessionFactory getSessionFactory(){

        Map<String, Object> settings = new HashMap<>();
        settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hit");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "abc123");

        settings.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        settings.put("hibernate.show_sql", "false");
        settings.put("hibernate.format_sql", "false");
        settings.put("hibernate.hbm2ddl.auto", "update");
        settings.put("hibernate.current_session_context_class","thread");

        ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Employee.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }

}

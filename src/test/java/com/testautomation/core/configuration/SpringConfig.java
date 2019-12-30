package com.testautomation.core.configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
@ComponentScan("com.testautomation")
public class SpringConfig {

}

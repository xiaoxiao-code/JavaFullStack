package org.cqipu.edu.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.cqipu.edu.dao", "org.cqipu.edu.service"})
public class Spring6Configuration {
}


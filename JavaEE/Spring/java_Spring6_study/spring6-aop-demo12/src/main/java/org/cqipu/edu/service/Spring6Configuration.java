package org.cqipu.edu.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.cqipu.edu.biz")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Configuration {
}

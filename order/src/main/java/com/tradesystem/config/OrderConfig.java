package com.tradesystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AuthConfig.class)
public class OrderConfig {
}

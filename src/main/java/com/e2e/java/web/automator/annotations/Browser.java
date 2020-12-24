package com.e2e.java.web.automator.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Lazy
@Bean
@Scope("browser")
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Browser {
}
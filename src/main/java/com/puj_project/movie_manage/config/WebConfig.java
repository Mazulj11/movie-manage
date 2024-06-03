package com.puj_project.movie_manage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(String.class, Date.class, new DateFormatter("yyyy-MM-dd"));
    }

    private static class DateFormatter implements org.springframework.core.convert.converter.Converter<String, Date> {

        private final SimpleDateFormat dateFormat;

        public DateFormatter(String pattern) {
            this.dateFormat = new SimpleDateFormat(pattern);
        }

        @Override
        public Date convert(String source) {
            try {
                return dateFormat.parse(source);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd", e);
            }
        }
    }
}


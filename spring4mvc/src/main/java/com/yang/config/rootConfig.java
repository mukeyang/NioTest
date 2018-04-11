package com.yang.config;

import com.yang.data.spittle;
import com.yang.web.SpittleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CS on 2018/4/4.
 */
@Configuration
@ComponentScan(basePackages = {"com.yang"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class rootConfig {
    @Bean(name = "repository")
    public SpittleRepository ff() {
        return new SpittleRepository() {
            public List<spittle> findSpittles(long max, int count) {
                ArrayList<spittle> spittles = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    spittles.add(new spittle(i, i + ""));
                }
                return spittles;
            }
        };
    }

}

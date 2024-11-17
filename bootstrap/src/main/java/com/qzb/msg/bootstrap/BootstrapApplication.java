package com.qzb.msg.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * BootstrapApplication.
 *
 * @CHECKSTYLE:OFF
 * @author <a href="mailto:qianzb@yxt.com">qianzb</a>
 * @date 2024-09-21 21:07
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.qzb.msg.bootstrap", "com.qzb.msg.service"})
@MapperScan(basePackages = "com.qzb.msg.dal")
public class BootstrapApplication {

    /**
     * start main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(BootstrapApplication.class);
    }

}

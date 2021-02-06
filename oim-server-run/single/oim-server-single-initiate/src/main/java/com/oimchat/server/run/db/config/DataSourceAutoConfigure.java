package com.oimchat.server.run.db.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

/**
 * sharding jdbc 和 Druid 只能2选1 <br>
 * Date 2021-01-12 14:29:57<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Configuration
@Import({ DruidDataSourceAutoConfigure.class })
@ConditionalOnProperty(prefix = "spring.shardingsphere", name = "enabled", havingValue = "false", matchIfMissing = false)
public class DataSourceAutoConfigure {

}

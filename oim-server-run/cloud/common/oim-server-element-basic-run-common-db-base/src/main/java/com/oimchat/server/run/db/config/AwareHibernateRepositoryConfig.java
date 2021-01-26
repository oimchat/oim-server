package com.oimchat.server.run.db.config;

import org.springframework.context.annotation.Bean;

import com.onlyxiahui.aware.basic.dao.CommonDAO;

/**
 * 
 * DAO 相关配置 <br>
 * Date 2020-11-06 23:32:23<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
public class AwareHibernateRepositoryConfig {

	@Bean
	public CommonDAO commonDAO() {
		CommonDAO bean = new CommonDAO();
		return bean;
	}
}

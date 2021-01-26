package com.oimchat.server.general.kernel.core.gateway.auth.cache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * 白名单IP缓存 <br>
 * Date 2019-07-19 18:57:19<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class WhiteListCache {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * 缓存管理器
	 */
	private final CacheManager cacheManager;
	/**
	 * 缓存白名单
	 */
	private final Cache<String, Boolean> cache;

	/**
	 * 初始化缓存管理器及自定义缓存对象
	 */
	public WhiteListCache() {
		log.info("Initialize the Cache Manager and custom cache objects.");
		cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);

		cache = cacheManager.createCache(
				"whiteListCache",
				CacheConfigurationBuilder.newCacheConfigurationBuilder(
						String.class,
						Boolean.class,
						ResourcePoolsBuilder.heap(1000)));
	}

	/**
	 * @return 返回缓存对象
	 */
	public Cache<String, Boolean> getCache() {
		return cache;
	}

	public void put(String ip) {
		cache.put(ip, true);
	}

	public void clear() {
		cache.clear();
	}

	public boolean has(String ip) {
		return cache.containsKey(ip);
	}
}

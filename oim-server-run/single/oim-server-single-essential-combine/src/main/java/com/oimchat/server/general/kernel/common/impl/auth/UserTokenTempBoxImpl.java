
package com.oimchat.server.general.kernel.common.impl.auth;

import java.time.Duration;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.springframework.stereotype.Component;

import com.oimchat.server.basic.definition.auth.business.UserTokenTempBox;

/**
 * Description <br>
 * Date 2020-04-14 09:35:06<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class UserTokenTempBoxImpl implements UserTokenTempBox {

	CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);
	// cacheManager.init();
	// cacheConfiguration -100个换成最大，缓存过期时间*秒

//	CacheConfiguration<String, String> cacheConfiguration = CacheConfigurationBuilder
//			.newCacheConfigurationBuilder(String.class, String.class,
//					ResourcePoolsBuilder.newResourcePoolsBuilder()
//							.heap(10, EntryUnit.ENTRIES)
//							.offheap(1, MemoryUnit.MB)
//							.disk(20, MemoryUnit.MB, true))
//			.withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(60))).build();
//	

	CacheConfiguration<String, String> cacheConfiguration = CacheConfigurationBuilder
			.newCacheConfigurationBuilder(String.class, String.class,
					ResourcePoolsBuilder.newResourcePoolsBuilder().heap(100000000, EntryUnit.ENTRIES))
			.withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(60))).build();

	Cache<String, String> tokenTemporaryCache = cacheManager.createCache("tokenTemporaryCache", cacheConfiguration);// cacheManager.getCache("tokenTemporaryCache", String.class, String.class);

	// private Map<String, String> map = new ConcurrentSkipListMap<String,
	// String>();

	public UserTokenTempBoxImpl() {
		// cacheManager.init();
	}

	@Override
	public void put(String token, String userId) {
		// map.put(token, userId);
		tokenTemporaryCache.put(token, userId);
	}

	@Override
	public String getUserId(String token) {
		// return map.get(token);
		return tokenTemporaryCache.get(token);
	}
}

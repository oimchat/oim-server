package com.oimchat.server.cloud.run.common.work.cache;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommonCache {

	@Resource
	protected RedisTemplate<Serializable, Serializable> redisTemplate;

	public void putDefault(String key, String value) {
		// 设置5分钟有效
		put(key, value, 300);
	}

	public void put(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 指定有效时长
	 * 
	 * @param key
	 * @param text
	 * @param seconds
	 */
	public void put(String key, String value, long seconds) {
		redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
	}

	public String get(String key) {
		String text = (String) redisTemplate.opsForValue().get(key);
		return text;
	}

	public void delete(String key) {
		redisTemplate.delete(key);
	}

	/***************************************************/

	public void putInHash(String id, String key, String value) {
		redisTemplate.opsForHash().put(id, key, value);
	}

	public Object getFromHash(String id, String key) {
		Object o = redisTemplate.opsForHash().get(id, key);
		return o;
	}

	/***************************************************/

	public void addInSet(String key, String value) {
		redisTemplate.opsForSet().add(key, value);
	}

	public void deleteSet(String key, String value) {
		redisTemplate.opsForSet().remove(key, value);
	}

	public void deleteSet(String key, Object... values) {
		redisTemplate.opsForSet().remove(key, values);
	}

	@SuppressWarnings("unchecked")
	public <T extends Serializable> Set<T> getSet(String key) {
		Set<T> resultSet = (Set<T>) redisTemplate.opsForSet().members(key);
		if (resultSet == null) {
			resultSet = new HashSet<T>();
		}
		return resultSet;
	}
}

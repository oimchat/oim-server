package com.oimchat.server.run.auth;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.PathContainer;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * Description <br>
 * Date 2020-11-20 10:56:13<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class PathBox {

	PathPatternParser parser = new PathPatternParser();
	Set<PathPattern> set = new HashSet<>();

	public void add(String path) {
		if (StringUtils.isNotBlank(path)) {
			set.add(parser.parse(path));
		}
	}

	public Set<PathPattern> getSet() {
		return set;
	}

	public boolean has(String lookupPath) {
		return (null != lookupPath) && has(PathContainer.parsePath(lookupPath));
	}

	public boolean has(PathContainer lookupPath) {
		Set<PathPattern> matches = set.stream()
				.filter(key -> key.matches(lookupPath))
				.collect(Collectors.toSet());
		return !matches.isEmpty();
	}
}

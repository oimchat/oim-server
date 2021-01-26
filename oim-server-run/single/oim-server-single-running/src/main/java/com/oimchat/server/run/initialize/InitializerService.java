package com.oimchat.server.run.initialize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oimchat.server.run.auth.SkipPathBox;

@Service
public class InitializerService {

	@Autowired
	SkipPathBox skipPathBox;

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public void initialize() {
		skipPathBox.add("/main");
		skipPathBox.add("/main/**");
	}
}

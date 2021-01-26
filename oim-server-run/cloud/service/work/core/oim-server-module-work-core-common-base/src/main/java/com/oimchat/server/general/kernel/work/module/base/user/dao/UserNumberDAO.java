package com.oimchat.server.general.kernel.work.module.base.user.dao;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.user.entity.UserNumber;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;

/**
 * 描述：
 * 
 * 2016年1月4日 下午9:48:59 <br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Repository
public class UserNumberDAO extends BaseEntityDAO<UserNumber> {

	long start = 9999L;

	/**
	 * 获取数字账号 <br>
	 * Date 2020-04-11 12:44:13<br>
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public long getNumber() {
		UserNumber data = new UserNumber();
		this.save(data);
		long id = data.getId();
		return (id + start);
	}
}

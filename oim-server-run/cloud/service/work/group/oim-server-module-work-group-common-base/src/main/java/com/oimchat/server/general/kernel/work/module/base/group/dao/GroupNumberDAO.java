
package com.oimchat.server.general.kernel.work.module.base.group.dao;

import org.springframework.stereotype.Repository;

import com.oimchat.server.general.kernel.work.module.base.group.entity.GroupNumber;
import com.onlyxiahui.aware.basic.dao.BaseEntityDAO;

/**
 * Description <br>
 * Date 2020-04-11 11:39:56<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Repository
public class GroupNumberDAO extends BaseEntityDAO<GroupNumber> {

	long start = 9999L;

	/**
	 * 获取数字账号 <br>
	 * Date 2020-04-11 12:44:13<br>
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public Long getNumber() {
		GroupNumber data = new GroupNumber();
		this.save(data);
		long id = data.getId();
		return (id + start);
	}
}

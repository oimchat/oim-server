package com.oimchat.server.general.kernel.work.module.base.chat.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.ChatItem;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Content;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Item;
import com.oimchat.server.general.kernel.work.module.base.chat.data.dto.content.Section;
import com.oimchat.server.general.kernel.work.module.base.chat.function.ChatFunction;

/**
 * 
 * Date 2019-02-17 12:09:28<br>
 * Description 聊天相关的一些方法
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */
@Service
public class ChatManager {

	@Resource
	ChatFunction chatFunction;

	public List<ChatItem> wordsFilter(Content content) {
		content.setTimestamp(System.currentTimeMillis());
		List<ChatItem> chatItemList = new ArrayList<ChatItem>();

		List<Section> sections = content.getSections();

		if (null != sections) {
			int sectionsSize = sections.size();
			for (int i = 0; i < sectionsSize; i++) {
				Section section = sections.get(i);
				List<Item> items = section.getItems();
				if (null != items) {
					int itemsSize = items.size();
					for (int j = 0; j < itemsSize; j++) {
						ChatItem chatItem = new ChatItem();

						Item item = items.get(j);
						String type = item.getType();
						String value = item.getValue();

						chatItem.setType(type);
						chatItem.setValue(value);
						chatItem.setSection(i);
						chatItem.setSort(j);

						if (Item.type_text.equals(type)) {
							value = chatFunction.wordsFilter(value);
							item.setValue(value);
							chatItem.setFilterValue(value);
						} else {
							chatItem.setFilterValue(value);
						}
						chatItemList.add(chatItem);
					}
				}
			}
		}
		return chatItemList;
	}
}

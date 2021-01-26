
package com.oimchat.doc.config;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.onlyxiahui.general.doc.spring.boot.bean.TreeNode;
import com.onlyxiahui.general.doc.spring.boot.extend.DocTreeNodeSort;

/**
 * Description <br>
 * Date 2020-04-12 11:41:01<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */
@Component
public class TreeNodeSortImpl implements DocTreeNodeSort {

	@Override
	public void sort(List<TreeNode> list, List<TreeNode> hasSortList) {
		if (null != list) {
			list.sort(new Comparator<TreeNode>() {

				@Override
				public int compare(TreeNode o1, TreeNode o2) {

					String t1 = o1.getTitle() == null ? "" : o1.getTitle();
					String t2 = o2.getTitle() == null ? "" : o2.getTitle();

					String s1 = o1.getPath() == null ? t1 : o1.getPath();
					String s2 = o2.getPath() == null ? t2 : o2.getPath();

					return s1.compareTo(s2);
				}
			});

			for (TreeNode node : list) {
				if (!hasSortList.contains(node)) {
					hasSortList.add(node);
					List<TreeNode> children = node.getChildren();
					if (null != children) {
						sort(children, hasSortList);
					}
				}
			}
		}
	}
}

package com.oimchat.server.general.kernel.system.module.setting.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oimchat.server.general.kernel.system.module.setting.dao.MultipleOnlineStrategyDAO;
import com.oimchat.server.general.kernel.system.module.setting.entity.MultipleOnlineStrategy;

@Service
public class MultipleOnlineStrategyManager {

    @Resource
    private MultipleOnlineStrategyDAO multipleOnlineStrategyDAO;

    public boolean isMultiple(String type) {
        boolean isMultiple = false;
        List<MultipleOnlineStrategy> list = multipleOnlineStrategyDAO.getByType(type);
        List<MultipleOnlineStrategy> hasSingleList = new ArrayList<>();
        for (MultipleOnlineStrategy m : list) {
            if (0 == m.getIsMultiple()) {
                list.add(m);
            }
        }
        isMultiple = hasSingleList.isEmpty();
        return isMultiple;
    }
}
package com.itheima.health.service;


import com.itheima.health.pojo.CheckItem;
import com.itheima.health.pojo.PageResult;
import com.itheima.health.pojo.QueryPageBean;

import java.util.List;

public interface CheckItemService {

    List<CheckItem> find();

    void add(CheckItem checkItem);

    PageResult findPages(QueryPageBean queryPageBean);
}

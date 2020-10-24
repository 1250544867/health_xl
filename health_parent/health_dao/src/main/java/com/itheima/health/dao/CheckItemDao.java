package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {

    List<CheckItem> find();

    void add(CheckItem checkItem);

    Page<CheckItem> findPage(Integer currentPage);
}

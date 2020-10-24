package com.itheima.health.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.dao.CheckItemDao;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.pojo.PageResult;
import com.itheima.health.pojo.QueryPageBean;
import com.itheima.health.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public List<CheckItem> find() {
        List<CheckItem> list= checkItemDao.find();
        return list;
    }

    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    public PageResult findPages(QueryPageBean queryPageBean) {
        //运用pagehelper工具进行分页操作
        PageHelper.startPage(queryPageBean.getPageSize(),queryPageBean.getCurrentPage());
        PageResult pageResult=null;
        //判断前端请求的查询数据是否为空
        if (!StringUtils.isEmpty(queryPageBean.getQueryString())){
            //为查询语句拼接%  %,为dao层查询
            queryPageBean.setQueryString("%"+queryPageBean.getQueryString()+"%");
        }
        //掉分页工具类中的page对象存储对象
        Page<CheckItem> page=checkItemDao.findPage(queryPageBean.getCurrentPage());

        PageResult result = new PageResult(page.getTotal(), page.getResult());

        return result;
    }
}

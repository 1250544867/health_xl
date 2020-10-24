package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.pojo.PageResult;
import com.itheima.health.pojo.QueryPageBean;
import com.itheima.health.pojo.Result;
import com.itheima.health.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/checkitem")
@RestController
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;

    @GetMapping("/findAll")
    public Result find() {
        List<CheckItem> list = checkItemService.find();
        return new Result(true ,"查询成功",list);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem) {
       checkItemService.add(checkItem);
       return new Result(true,"添加成功");
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult=checkItemService.findPages(queryPageBean);
        return new Result(true,"添加成功",pageResult);
    }
}

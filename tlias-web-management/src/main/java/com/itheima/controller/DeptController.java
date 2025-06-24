package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.zip.CheckedOutputStream;

@RestController// 作用等同于@Controller和@ResponseBody的结合
public class DeptController {

//    声明一个service接口
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts") // 请求方式必须为GET，等同于下面的
    //@RequestMapping(value = "/depts",method = RequestMethod.GET) // method属性指定请求方式
    public Result list() {

        System.out.println("查询所有部门数据");
        List<Dept> deptList =  deptService.findAll();

       // 把deptList封装到Result对象中
        Result result = Result.success(deptList);

        // 返回Result对象
        return result;
    }


}

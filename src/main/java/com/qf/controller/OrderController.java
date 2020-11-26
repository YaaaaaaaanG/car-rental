package com.qf.controller;

import com.github.pagehelper.PageInfo;
import com.qf.common.OrderBaseResp;
import com.qf.common.OrderMessageResp;
import com.qf.common.OrderResp;
import com.qf.pojo.Car;
import com.qf.pojo.City;
import com.qf.pojo.Order;
import com.qf.pojo.User;
import com.qf.service.CarService;
import com.qf.service.CityService;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
@SessionAttributes("user")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CarService carService;

    @Autowired
    CityService cityService;

    @RequestMapping(value = "/insertOrder",method = RequestMethod.GET)
    public OrderResp insertOrder(Order order, ModelMap modelMap){
        User user =(User) modelMap.get("user");
        order.setUid(user.getId());
        order.setStatus("已预定");
        Integer integer = orderService.insertOrder(order);
        OrderResp orderResp = new OrderResp();
        ArrayList arrayList = new ArrayList();
        if (integer == 1) {
            orderResp.setCode(1);
            arrayList.add("提交成功");
            orderResp.setInfo(arrayList);
            return orderResp;
        }
        orderResp.setCode(0);
        arrayList.add("提交失败");
        orderResp.setInfo(arrayList);
        return orderResp;
    }

    @RequestMapping(value = "/selectByLimit",method = RequestMethod.GET)
    public OrderResp selectByLimit(ModelMap modelMap,Integer page){
        User user =(User) modelMap.get("user");
        List<Order> orders = orderService.selectByLimit(user.getId(),page,5);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
        List<Order> list = orderPageInfo.getList();
        ArrayList arrayList = new ArrayList();
        OrderBaseResp orderBaseResp = new OrderBaseResp();
        orderBaseResp.setTotal((int) orderPageInfo.getTotal());
        for (int i = 0; i < list.size();i++){
            OrderMessageResp orderMessageResp = new OrderMessageResp();
            Order order = list.get(i);
            Car car = carService.selectById(order.getCid());
            City city = cityService.selectById(order.getGetid());
            City city1 = cityService.selectById(order.getBackid());
            orderMessageResp.setOid(order.getId());
            orderMessageResp.setCname(car.getName());
            orderMessageResp.setOprice(car.getPrice());
            orderMessageResp.setGetcity(city.getName());
            orderMessageResp.setBackcity(city1.getName());
            orderMessageResp.setOstatus(order.getStatus());
            arrayList.add(orderMessageResp);
        }
        orderBaseResp.setRows(arrayList);
        OrderResp orderResp = new OrderResp();
        orderResp.setCode(1);
        orderResp.setInfo(orderBaseResp);
        return orderResp;
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public OrderResp deleteById(Integer oid){
        Integer integer = orderService.deleteById(oid);
        OrderResp orderResp = new OrderResp();
        if (integer == 1){
            orderResp.setCode(1);
            orderResp.setInfo("删除成功");
            return orderResp;
        }
        orderResp.setCode(0);
        orderResp.setInfo("删除失败");
        return orderResp;
    }
}

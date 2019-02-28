package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.OrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page,int size) {

        PageHelper.startPage(page,size);
        List<Orders> OrderList = ordersDao.findAll();
        return OrderList;
    }

    @Override
    public Orders findById(String ordersId) {

        return ordersDao.findById(ordersId);
    }
}

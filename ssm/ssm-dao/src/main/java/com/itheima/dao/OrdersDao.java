package com.itheima.dao;

import com.itheima.domain.Member;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {


    @Select("select * from Orders")
    @Results({
            @Result(property = "product",column = "productId",javaType = Product.class,
                    one=@One(select = "com.itheima.dao.ProductDao.findById")),
    })
    List<Orders> findAll();

    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(property = "product",column = "productId",javaType = Product.class,
            one = @One(select = "com.itheima.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,
            one = @One(select = "com.itheima.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,
            many = @Many(select = "com.itheima.dao.TravellerDao.findByOrdersId")),
    })
    Orders findById(String ordersId);
}

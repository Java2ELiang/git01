package com.itheima.dao;

import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerDao {

    @Select("select t.* from traveller t,order_traveller ot where ot.orderId = #{orderId} and t.id = ot.travellerId")
    Traveller findByOrdersId(String ordersId);
}

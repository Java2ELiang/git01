package com.itheima.dao;

import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
            many = @Many(select = "com.itheima.dao.RoleDao.findByUserId"))
    })
    UserInfo findUserByUsername(String username) throws Exception;
}

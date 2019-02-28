package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    @Select("select * from role where id in (select roleid from users_role where userid = #{id})")
    List<Role> findByUserId(String id);
}

package com.company.dao;

import com.company.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/20.
 */
@Repository
public interface UserDao {

    int deleteByPrimaryKey(Integer userId);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User user);

}

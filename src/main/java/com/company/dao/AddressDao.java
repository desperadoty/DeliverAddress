package com.company.dao;

import com.company.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Repository
public interface AddressDao {

    int deleteByPrimaryKey(Integer addrId);

    int insert(Address address);

    int insertSelective(Address address);

    Address selectByPrimaryKey(Integer addrId);

    int updateByPrimaryKeySelective(Address address);

    int updateByPrimaryKey(Address address);

    List<Address> selectByUserId(Integer userId);

    Address selectByUserAndAddrId(@Param("userId") Integer userId, @Param("addrId") Integer addrId);

    int deleteByUserAndAddrId(@Param("userId") Integer userId, @Param("addrId") Integer addrId);

    Address selectDefaultByUserId(Integer userId);
}

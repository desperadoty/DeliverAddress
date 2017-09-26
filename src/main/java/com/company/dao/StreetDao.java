package com.company.dao;

import com.company.entity.Street;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Repository
public interface StreetDao {

    int deleteByPrimaryKey(Integer streetId);

    int insert(Street street);

    int insertSelective(Street street);

    Street selectByPrimaryKey(Integer streetId);

    int updateByPrimaryKeySelective(Street street);

    int updateByPrimaryKey(Street street);

    List<Street> selectByRegionId(Integer regionId);

    Street selectByStreet(String street);

    Street selectByStreetAndRegionId(@Param("street") String street, @Param("regionId") Integer regionId);
}

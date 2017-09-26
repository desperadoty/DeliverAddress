package com.company.dao;

import com.company.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Repository
public interface CityDao {

    int deleteByPrimaryKey(Integer cityId);

    int insert(City city);

    int insertSelective(City city);

    City selectByPrimaryKey(Integer cityId);

    int updateByPrimaryKeySelective(City city);

    int updateByPrimaryKey(City city);

    List<City> selectByProvinceId(Integer provinceId);

    City selectByCity(String city);
}

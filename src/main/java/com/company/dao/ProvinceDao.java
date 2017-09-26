package com.company.dao;

import com.company.entity.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Repository
public interface ProvinceDao {

    int deleteByPriamryKey(Integer provinceId);

    int insert(Province province);

    int insertSelective(Province province);

    Province selectByPrimaryKey(Integer provinceId);

    int updateByPrimaryKeySelective(Province province);

    int updateByPrimaryKey(Province province);

    List<Province> selectAll();

    Province selectByProvince(String province);
}

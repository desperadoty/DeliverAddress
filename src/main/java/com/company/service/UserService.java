package com.company.service;

import com.company.entity.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */

public interface UserService {

    PageInfo<Address> getAddrList(Integer userId, Integer pageNum, Integer pageSize);

    Address getAddrInfo(Integer userId, Integer addrId);

    List<Province> getAllProvince();

    List<City> getCities(Integer provinceId);

    List<Region> getRegions(Integer cityId);

    List<Street> getStreets(Integer regionId);

    String editAddrHandler(Address address);

    String delAddrHandler(Address address);

    String setDefaultAddr(Address address);

    User getUserById(Integer userId);

    int updateUser(User user);

    int insertUser(User user);

}

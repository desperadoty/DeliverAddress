package com.company.service.impl;

import com.alibaba.fastjson.JSON;
import com.company.dao.*;
import com.company.entity.*;
import com.company.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private CityDao cityDao;
    @Autowired
    private RegionDao regionDao;
    @Autowired
    private StreetDao streetDao;

    @Override
    public PageInfo<Address> getAddrList(Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Address> addrList = addressDao.selectByUserId(userId);
        PageInfo<Address> pageInfo = new PageInfo<>(addrList);

        return pageInfo;
    }

    @Override
    public Address getAddrInfo(Integer userId, Integer addrId) {
        Address address = addressDao.selectByUserAndAddrId(userId, addrId);

        logger.info(JSON.toJSONString(address));

        Province province = provinceDao.selectByProvince(address.getProvince());
        City city = cityDao.selectByCity(address.getCity());
        Region region = regionDao.selectByRegion(address.getRegion());
        Street street = streetDao.selectByStreetAndRegionId(address.getStreet(),region.getRegionId());

        if(province!=null&&city!=null&&region!=null&&street!=null) {
            address.setProvinceId(province.getProvinceId());
            address.setCityId(city.getCityId());
            address.setRegionId(region.getRegionId());
            address.setStreetId(street.getStreetId());
        }

        return address;
    }

    @Override
    public List<Province> getAllProvince() {
        return provinceDao.selectAll();
    }

    @Override
    public List<City> getCities(Integer provinceId) {
        return cityDao.selectByProvinceId(provinceId);
    }

    @Override
    public List<Region> getRegions(Integer cityId) {
        return regionDao.selectByCityId(cityId);
    }

    @Override
    public List<Street> getStreets(Integer regionId) {
        return streetDao.selectByRegionId(regionId);
    }

    @Override
    public String editAddrHandler(Address address) {
        if(address.getProvinceId()!=null&&address.getCityId()!=null&&address.getRegionId()!=null&&address.getStreetId()!=null
                &&address.getAddrDetail()!=null&&address.getName()!=null&&address.getPhone()!=null) {
            Province province = provinceDao.selectByPrimaryKey(address.getProvinceId());
            City city = cityDao.selectByPrimaryKey(address.getCityId());
            Region region = regionDao.selectByPrimaryKey(address.getRegionId());
            Street street = streetDao.selectByPrimaryKey(address.getStreetId());

            if(province==null || city==null) {
                return "dataError";
            }

            address.setProvince(province.getProvince());
            address.setCity(city.getCity());
            address.setRegion(region.getRegion());
            address.setStreet(street.getStreet());

            if(address.getAddrId()!=null) {
                //对原有收货地址进行修改
                if(addressDao.updateByPrimaryKeySelective(address) > 0) {
                    return "success";
                } else {
                    return "failed";
                }
            }else {
                //新增收货地址
                if(addressDao.insertSelective(address) > 0) {
                    return "success";
                } else {
                    return "fail";
                }
            }
        } else {
            return "dataEmpty";
        }
    }

    @Override
    public String delAddrHandler(Address address) {
        Address addr = addressDao.selectByUserAndAddrId(address.getUserId(),address.getAddrId());

        if(addr!=null && addr.getDefault()) {
            return "isDefault";
        }
        if(address.getUserId()==null || address.getAddrId()==null) {
            return "dataEmpty";
        }
        if(addressDao.deleteByUserAndAddrId(address.getUserId(),address.getAddrId()) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @Override
    public String setDefaultAddr(Address address) {
        //将原有默认地址设为非默认
        Address defaultAddr = addressDao.selectDefaultByUserId(address.getUserId());
        defaultAddr.setDefault(false);

        //更新默认地址
        Address newDefaultAddr = addressDao.selectByUserAndAddrId(address.getUserId(),address.getAddrId());
        newDefaultAddr.setDefault(true);

        if(addressDao.updateByPrimaryKeySelective(defaultAddr) > 0 && addressDao.updateByPrimaryKeySelective(newDefaultAddr) > 0) {
            return "success";
        } else {
            return "failed";
        }
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertSelective(user);
    }
}

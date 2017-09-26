package com.company.web;

import com.alibaba.fastjson.JSON;
import com.company.entity.*;
import com.company.service.impl.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/4/21.
 */
@Controller
@RequestMapping("user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/addrList", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addrList(Integer userId, Integer pageNum, Integer pageSize) {
        if(pageNum == null) {
            pageNum = 1;
        }

        if(pageSize == null) {
            pageSize = 10;
        }

        PageInfo<Address> addrList = userService.getAddrList(userId, pageNum, pageSize);
        Map<String, Object> map = new TreeMap<>();
        map.put("pageNum",addrList.getPageNum());
        map.put("hasNextPage",addrList.isHasNextPage());

        map.put("addrList",addrList.getList());

        return map;
    }

    @RequestMapping(value = "/editAddr",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> editAddr(Integer userId, Integer addrId) {
        Map<String, Object> map = new TreeMap<>();

       if(addrId != null) {
           Address address = userService.getAddrInfo(userId, addrId);
           map.put("address", address);

           List<City> city = userService.getCities(address.getProvinceId());
           map.put("city",city);

           List<Region> region = userService.getRegions(address.getCityId());
           map.put("region",region);

           List<Street> street = userService.getStreets(address.getRegionId());
           map.put("street",street);
       }

       List<Province> province = userService.getAllProvince();
       map.put("province", province);

       return map;
    }


    @RequestMapping("/getAllProvince")
    public @ResponseBody Map<String, Object> getAllProvince() {
        Map<String, Object> map = new TreeMap<>();

        List<Province> province = userService.getAllProvince();
        map.put("province",province);

        return map;
    }

    @RequestMapping(value = "/getCities",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getCities(Integer provinceId) {
        Map<String,Object> map = new TreeMap<>();

        if(provinceId != null) {
            List<City> city = userService.getCities(provinceId);
            logger.info(JSON.toJSONString(city));
            map.put("city",city);
        }

        return map;
    }

    @RequestMapping(value = "/getRegions",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getRegions(Integer cityId) {
        Map<String, Object> map = new TreeMap<>();

        if(cityId != null) {
            List<Region> region =  userService.getRegions(cityId);
            logger.info(JSON.toJSONString(region));
            map.put("region", region);
        }

        return map;
    }

    @RequestMapping(value = "/getStreets",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getStreets(Integer regionId) {
        Map<String,Object> map = new TreeMap<>();

        if(regionId != null) {
            List<Street> street = userService.getStreets(regionId);
            logger.info(JSON.toJSONString(street));
            map.put("street",street);
        }

        return map;
    }


    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getUserInfo(Integer userId) {
        Map<String,Object> map = new TreeMap<>();

        if(userId != null) {
            User user = userService.getUserById(userId);
            logger.info(user.toString());
            map.put("username",user.getUsername());
            map.put("nickname",user.getNickname());
            map.put("user", user);
        }

        return map;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addUser (@RequestBody User user) {
        Map<String, Object> map = new TreeMap<>();

        if(user != null) {
            userService.insertUser(user);
            map.put("user",user);
        }

        return map;
    }

    @RequestMapping(value = "/setDefaultAddr", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> setDefaultAddr(@RequestBody Address address) {
        Map<String, Object> map = new TreeMap<>();

        if(address != null) {
//            userService.editAddrHandler(address);
            String info = userService.setDefaultAddr(address);
            map.put("setInfo",info);
            map.put("address",address);
        }

        return map;
    }
}

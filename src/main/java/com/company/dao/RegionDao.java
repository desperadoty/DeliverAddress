package com.company.dao;

import com.company.entity.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */
@Repository
public interface RegionDao {

    int deleteByPrimaryKey(Integer regionId);

    int insert(Region region);

    int insertSelective(Region region);

    Region selectByPrimaryKey(Integer redionId);

    int updateByPrimaryKeySelective(Region region);

    int updateByPrimaryKey(Region region);

    List<Region> selectByCityId(Integer cityId);

    Region selectByRegion(String region);
}

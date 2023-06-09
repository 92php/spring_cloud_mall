package com.imooc.cloud.mall.practice.advertisement.model.dao;

import com.imooc.cloud.mall.practice.advertisement.model.pojo.Advertisement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 广告mapper
 */
@Repository
public interface AdvertisementMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Advertisement advertisement);

  int insertSelective(Advertisement advertisement);

  Advertisement selectByPrimaryKey(Integer id);

  Advertisement selectByName(String name);

  int updateByPrimaryKeySelective(Advertisement advertisement);

  int updateByPrimaryKey(Advertisement advertisement);

  List<Advertisement> selectList(@Param("keyword") String keyword);
}

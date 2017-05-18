package com.babyElephant.dao;

import com.babyElephant.vo.Activice;

import java.util.List;
import java.util.Map;


public interface BannerDao {
     List<Map<String,String>> getActivice();

     List<Map<String,String>> getAllActivice();

     int saveActivice(Activice activice);
}

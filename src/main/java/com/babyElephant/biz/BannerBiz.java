package com.babyElephant.biz;

import com.babyElephant.util.ReturnMessage;
import com.babyElephant.vo.Activice;

import java.util.List;
import java.util.Map;

public interface BannerBiz {
     List<Map<String,String>>  getActivice(boolean status);

     ReturnMessage saveActivice(Activice activice);

     Map<String,String> getUrl() throws Exception;

}

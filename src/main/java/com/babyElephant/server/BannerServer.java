package com.babyElephant.server;

import com.babyElephant.vo.Activice;

import java.util.List;
import java.util.Map;


public interface BannerServer {
    List<Map<String,String>> getActivice();

    List<Map<String,String>> getAllActivice();

    int saveActivice(Activice activice);
}

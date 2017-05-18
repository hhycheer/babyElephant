package com.babyElephant.server.impl;

import com.babyElephant.dao.BannerDao;
import com.babyElephant.server.BannerServer;
import com.babyElephant.vo.Activice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BannerServerImpl implements BannerServer{

    @Autowired
    private BannerDao bannerDao;


    @Override
    public List<Map<String,String>> getActivice() {
        return bannerDao.getActivice();
    }

    @Override
    public List<Map<String,String>> getAllActivice() {
        return bannerDao.getAllActivice();
    }

    @Override
    public int saveActivice(Activice activice) {
        return bannerDao.saveActivice(activice);
    }
}

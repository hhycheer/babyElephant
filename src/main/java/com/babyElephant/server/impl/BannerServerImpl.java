package com.babyElephant.server.impl;

import com.babyElephant.dao.BannerDao;
import com.babyElephant.po.Banner;
import com.babyElephant.server.BannerServer;
import com.babyElephant.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BannerServerImpl implements BannerServer{

    @Autowired
    private BannerDao bannerDao;
    
    public Page<Banner> getBanner(Page<Banner> page) {
        page.setResults( bannerDao.getBanner(page));
        return page;
    }


}

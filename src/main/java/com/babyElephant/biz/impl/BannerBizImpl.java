package com.babyElephant.biz.impl;

import com.babyElephant.biz.BannerBiz;
import com.babyElephant.po.Banner;
import com.babyElephant.server.BannerServer;
import com.babyElephant.util.enmoUtil.MainEnum;
import com.babyElephant.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Matthew on 17/4/25.
 */
@Service
public class BannerBizImpl implements BannerBiz {

    @Autowired
    private BannerServer bannerServer;

    public List<Banner> getBanner() {
        Page<Banner> page=new Page<Banner>();
        page.setPageSize(1);
        page.setPageNo(1);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("status",MainEnum.BANNER_STATUS_TRUE.getCode());
        page.setParams(map);
        return bannerServer.getBanner(page).getResults();
    }
}

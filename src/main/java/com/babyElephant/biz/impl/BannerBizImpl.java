package com.babyElephant.biz.impl;

import com.babyElephant.biz.BannerBiz;
import com.babyElephant.server.BannerServer;
import com.babyElephant.util.ReturnMessage;
import com.babyElephant.util.UUIDUtil;
import com.babyElephant.vo.Activice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BannerBizImpl implements BannerBiz {

    @Autowired
    private BannerServer bannerServer;



    @Override
    public List<Map<String,String>> getActivice(boolean status) {
        if(status){
            return bannerServer.getActivice();
        }else{
            return bannerServer.getAllActivice();
        }

    }

    @Override
    public ReturnMessage saveActivice(Activice activice) {
        activice.setUuid(UUIDUtil.getUUID());
        activice.setCreate_time(String.valueOf(System.currentTimeMillis()));
        int i=bannerServer.saveActivice(activice);
        if (i>0){
            return ReturnMessage.SUCCESS;
        }
        return ReturnMessage.ERROR;
    }
}

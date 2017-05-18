package com.babyElephant.biz.impl;

import com.alibaba.fastjson.JSON;
import com.babyElephant.biz.BannerBiz;
import com.babyElephant.server.BannerServer;
import com.babyElephant.util.HttpClientNewUtil;
import com.babyElephant.util.ReturnMessage;
import com.babyElephant.util.Signature;
import com.babyElephant.util.UUIDUtil;
import com.babyElephant.vo.Activice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class BannerBizImpl implements BannerBiz {

    @Autowired
    private BannerServer bannerServer;

    private static final String PAY_GATEWAY = "http://pay.chinaxzf.com:8080/payment/ScanPayApply.do";

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

    @Override
    public Map<String, String> getUrl() throws Exception {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        SortedMap<String, String> map = new TreeMap<String, String>();
        map.put("versionId","1.0");
        map.put("orderAmount","100");
        map.put("orderDate",simpleDateFormat.format(new Date()));
        map.put("currency","RMB");
        map.put("transType","0008");
        map.put("asynNotifyUrl","www.baidu.com");
        map.put("synNotifyUrl","www.baidu.com");
        map.put("signType","MD5");
        map.put("merId","00000000518691");
        map.put("prdOrdNo",String.valueOf(System.currentTimeMillis()));
        map.put("payMode","00022");
        map.put("receivableType","D00");
        map.put("prdAmt","100");
        map.put("prdName","小象旅游");
        String sign = Signature.createSign(map, "Pyb1Vi6P7xlZ");
        map.put("signData",sign);
        String resData = HttpClientNewUtil.post(PAY_GATEWAY, map);//提交到支付系统
        Map<String, String> retmap = (Map<String, String>) JSON.parse(resData);
        return retmap;
    }
}

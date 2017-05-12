package com.babyElephant.controller;

import com.babyElephant.biz.BannerBiz;
import com.babyElephant.po.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/main")
public class BannerController {


    @Autowired
    private BannerBiz bannerBiz;

    @RequestMapping("/getBanner")
    public @ResponseBody
    List<Banner> contactUs(){

        List<Banner> banners=bannerBiz.getBanner();
        return banners;
    }
}

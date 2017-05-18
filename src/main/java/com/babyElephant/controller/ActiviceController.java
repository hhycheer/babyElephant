package com.babyElephant.controller;

import com.babyElephant.biz.BannerBiz;
import com.babyElephant.po.Banner;
import com.babyElephant.util.ReturnMessage;
import com.babyElephant.vo.Activice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/activice")
public class ActiviceController {

    @Autowired
    BannerBiz bannerBiz;

    @RequestMapping("/getActivice")
    public @ResponseBody
    List<Map<String,String>> getActivice(HttpSession httpSession){
        return bannerBiz.getActivice(true);
    }

    @RequestMapping("/getAllActivice")
    public @ResponseBody
    List<Map<String,String>> getAllActivice(HttpSession httpSession){
        return bannerBiz.getActivice(false);
    }

    @RequestMapping("/save")
    public @ResponseBody
    ReturnMessage getAllActivice(@RequestBody Activice activice){
        return bannerBiz.saveActivice(activice);
    }



}

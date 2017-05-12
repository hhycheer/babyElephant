package com.babyElephant.dao;

import com.babyElephant.po.Banner;
import com.babyElephant.util.page.Page;

import java.util.List;


public interface BannerDao {
     List<Banner> getBanner(Page<Banner> page);
}

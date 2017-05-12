package com.babyElephant.server;

import com.babyElephant.po.Banner;
import com.babyElephant.util.page.Page;


public interface BannerServer {
    Page<Banner> getBanner(Page<Banner> page);
}

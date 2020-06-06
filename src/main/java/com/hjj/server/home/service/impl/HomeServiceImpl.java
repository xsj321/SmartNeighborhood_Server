package com.hjj.server.home.service.impl;

import com.hjj.server.cover.mapper.CoverMapper;
import com.hjj.server.cover.model.Cover;
import com.hjj.server.home.mapper.HomeMapper;
import com.hjj.server.home.model.Home;
import com.hjj.server.home.service.HomeService;
import com.hjj.server.important.mapper.ImportantMapper;
import com.hjj.server.important.model.Important;
import com.hjj.server.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeMapper homeMapper;

    @Autowired
    CoverMapper coverMapper;

    @Autowired
    ImportantMapper importantMapper;

    /**
     * 获取主页数据
     * @return 主页数据
     */
    @Override
    public ResponseVo getHome() {
        Home home = new Home();
        home.setRespond_type("home_page");
        home.setRequest_user("未知");
        home.setTemperature(30);
        home.setHumidity("54");
        home.setPM(300);
        List<Cover> coverWaringList = coverMapper.getCoverWaringList();
        List<Important> importantWaringList = importantMapper.getImportantWaringList();
        if (coverWaringList.size() == 0) {
            home.setCover(false);
        } else {
            home.setCover(true);
        }

        if (importantWaringList.size() == 0) {
            home.setImportant(false);
        } else {
            home.setImportant(true);
        }

        home.setPlace("四川省成都市锦江区东光街道");
        home.setLocationID(1);
        Map<String,Object> stringMapMap = home.makeRes(home);
        ResponseVo responseVo = ResponseVo.buildSuccessInstance();
        responseVo.setRespond(stringMapMap);
        return responseVo;
    }
}

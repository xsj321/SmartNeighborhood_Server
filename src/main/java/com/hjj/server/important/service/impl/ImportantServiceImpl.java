package com.hjj.server.important.service.impl;

import com.hjj.server.cover.model.Cover;
import com.hjj.server.important.mapper.ImportantMapper;
import com.hjj.server.important.model.Important;
import com.hjj.server.important.service.ImportantService;
import com.hjj.server.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportantServiceImpl implements ImportantService {

    @Autowired
    ImportantMapper importantMapper;

    @Override
    public ResponseVo getImportant(Important important) {
        ResponseVo responseVo = ResponseVo.buildSuccessInstance();
        List<Important> importantDetailList = importantMapper.getImportantDetailList(important);
        important.setDetail(importantDetailList);
        important.setWaring(true);
        List<Important> importantWaringList = importantMapper.getImportantWaringList();
        if (importantWaringList != null){
            important.setWaring_list(importantWaringList);
        }
        responseVo.setRespond(important.makeRes(important));
        return responseVo;
    }

    @Override
    public ResponseVo fixImportant(Important important) {
        ResponseVo responseVo = ResponseVo.buildFailInstance();
        int res = importantMapper.upFixImportantStatus(important);
        if (res == 1){
            return responseVo.buildSuccessInstance();
        }else {
            return responseVo;
        }
    }
}

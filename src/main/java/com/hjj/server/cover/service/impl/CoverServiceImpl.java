package com.hjj.server.cover.service.impl;

import com.hjj.server.cover.mapper.CoverMapper;
import com.hjj.server.cover.model.Cover;
import com.hjj.server.cover.service.CoverService;
import com.hjj.server.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverServiceImpl implements CoverService {

    @Autowired
    CoverMapper coverMapper;

    @Override
    public ResponseVo getCover(Cover cover) {
        ResponseVo responseVo = ResponseVo.buildSuccessInstance();
        List<Cover>  coverDetailList = coverMapper.getCoverDetailList(cover);
        cover.setDetail(coverDetailList);
        cover.setWaring(true);
        List<Cover> coverWaringList = coverMapper.getCoverWaringList();
        if (coverWaringList != null){
            cover.setWaring_list(coverWaringList);
        }
        responseVo.setRespond(cover.makeRes(cover));
        return responseVo;
    }
}

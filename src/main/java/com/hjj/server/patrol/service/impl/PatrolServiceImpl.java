package com.hjj.server.patrol.service.impl;

import com.hjj.server.patrol.mapper.PatrolMapper;
import com.hjj.server.patrol.model.Patrol;
import com.hjj.server.patrol.service.PatrolService;
import com.hjj.server.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PatrolServiceImpl implements PatrolService {

    @Autowired
    PatrolMapper  patrolMapper;

    @Override
    public ResponseVo getPatrol(Patrol patrol) {
        ResponseVo responseVo  = new ResponseVo();
        List<Patrol> patrolList = patrolMapper.getPatrolList(patrol);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        for (Patrol item :
                patrolList) {
            Date date = item.getDate();
            item.setDateString(simpleDateFormat.format(date));
        }
        patrol.setDetailList(patrolList);
        responseVo.setRespond(patrol.makeRes(patrol));
        return responseVo;
    }
}

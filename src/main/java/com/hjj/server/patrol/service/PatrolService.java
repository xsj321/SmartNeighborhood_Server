package com.hjj.server.patrol.service;

import com.hjj.server.patrol.model.Patrol;
import com.hjj.server.util.ResponseVo;

public interface PatrolService {
    ResponseVo getPatrol(Patrol patrol);
}

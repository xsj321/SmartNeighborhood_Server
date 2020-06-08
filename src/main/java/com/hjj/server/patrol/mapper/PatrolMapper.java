package com.hjj.server.patrol.mapper;

import com.hjj.server.patrol.model.Patrol;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatrolMapper {
    List<Patrol> getPatrolList(Patrol patrol);
}

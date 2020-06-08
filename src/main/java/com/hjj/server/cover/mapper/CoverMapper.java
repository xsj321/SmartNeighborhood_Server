package com.hjj.server.cover.mapper;

import com.hjj.server.cover.model.Cover;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoverMapper {
    List<Cover> getCoverDetailList(Cover cover);

    List<Cover> getCoverWaringList();

    int upFixCoverStatus(Cover cover);
}

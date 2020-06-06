package com.hjj.server.cover.mapper;

import com.hjj.server.cover.model.Cover;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoverMapper {
    List<Cover> getCoverDetailListw(Cover cover);

    List<Cover> getCoverWaringListw();

}

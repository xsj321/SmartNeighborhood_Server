package com.hjj.server.important.mapper;

import com.hjj.server.important.model.Important;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImportantMapper {
    List<Important> getImportantDetailList(Important important);

    List<Important> getImportantWaringList();


    int upFixImportantStatus(Important important);

}

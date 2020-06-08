package com.hjj.server.cover.service;

import com.hjj.server.cover.model.Cover;
import com.hjj.server.util.ResponseVo;

public interface CoverService {
    ResponseVo getCover(Cover cover);

    ResponseVo fixCover(Cover cover);
}

package com.hjj.server.login.service;

import com.hjj.server.login.model.Account;
import com.hjj.server.util.ResponseVo;

public interface LoginService {
    ResponseVo login(Account account);

    ResponseVo register(Account account);
}

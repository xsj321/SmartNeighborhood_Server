package com.hjj.server.login.service.impl;


import com.hjj.server.login.mapper.LoginMapper;
import com.hjj.server.login.model.Account;
import com.hjj.server.login.service.LoginService;
import com.hjj.server.util.ErrorCode;
import com.hjj.server.util.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper  loginMapper;
    /**
     * 登录接口
     * @param account 账号对象
     * @return 登录信息
     */
    @Override
    public ResponseVo login(Account account) {
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL,ResponseVo.LOGIN_ERROR);
        Account accountByDb = loginMapper.login(account);
        if (accountByDb == null){
            return responseVo;
        }
        else {
            responseVo = responseVo.buildSuccessInstance();
            responseVo.setMsg(ResponseVo.LOGIN_SUCCEED);
            return responseVo;
        }
    }

    /**
     * 注册接口
     * @param account 账号对象
     * @return 登录信息
     */
    @Override
    public ResponseVo register(@RequestBody Account account) {
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL,ResponseVo.REG_ERROR);
        Account accountByDb = loginMapper.login(account);
        if(accountByDb == null){
            int res = loginMapper.register(account);
            if (res == 1){
                responseVo = ResponseVo.buildSuccessInstance();
                responseVo.setMsg(ResponseVo.REG_SUCCEED);
            }else{
                return responseVo;
            }
        }
        else {
            responseVo.setMsg("用户已存在");
            return responseVo;
        }
    return responseVo;
    }
}

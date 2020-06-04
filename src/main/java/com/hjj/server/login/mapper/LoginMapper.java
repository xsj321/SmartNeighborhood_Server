package com.hjj.server.login.mapper;
import com.hjj.server.login.model.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    Account login(Account account);

    int register(Account account);
}

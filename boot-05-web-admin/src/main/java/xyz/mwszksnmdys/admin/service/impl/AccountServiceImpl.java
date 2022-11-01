package xyz.mwszksnmdys.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.mwszksnmdys.admin.bean.Account;
import xyz.mwszksnmdys.admin.mapper.AccountMapper;
import xyz.mwszksnmdys.admin.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAccountById(Long id){
        return accountMapper.getAccount(id);
    }
}

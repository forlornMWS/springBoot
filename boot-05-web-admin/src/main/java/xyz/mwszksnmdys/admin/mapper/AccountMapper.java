package xyz.mwszksnmdys.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.mwszksnmdys.admin.bean.Account;

@Mapper
public interface AccountMapper {

    public Account getAccount(Long id);
}

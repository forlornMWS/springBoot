package xyz.mwszksnmdys.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.mwszksnmdys.admin.bean.User;
import xyz.mwszksnmdys.admin.mapper.UserMapper;
import xyz.mwszksnmdys.admin.service.UserService;

@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {

}

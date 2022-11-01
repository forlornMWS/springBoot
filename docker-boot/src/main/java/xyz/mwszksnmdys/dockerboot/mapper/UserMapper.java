package xyz.mwszksnmdys.dockerboot.mapper;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import xyz.mwszksnmdys.dockerboot.entity.User;


@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

}

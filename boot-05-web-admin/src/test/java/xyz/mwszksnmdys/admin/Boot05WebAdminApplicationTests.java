package xyz.mwszksnmdys.admin;

import com.alibaba.druid.support.http.StatViewServlet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import xyz.mwszksnmdys.admin.bean.User;
import xyz.mwszksnmdys.admin.mapper.UserMapper;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;


    @Test
    void contextLoads() {
        Integer integer = jdbcTemplate.queryForObject("select count(*) from t_user", Integer.class);
        log.info("t_user表中共有{}条记录", integer);

        log.info("数据源类型:{}", dataSource.getClass());
    }

    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1L);
        List<User> userList = userMapper.selectList(null);
        log.info("用户信息：{}", user);
        userList.forEach(System.out::println);
    }

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("hello", "world");
        String hello = operations.get("hello");
        System.out.println(hello);
        System.out.println(redisConnectionFactory.getClass());
    }

}

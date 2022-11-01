package xyz.mwszksnmdys.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import xyz.mwszksnmdys.admin.bean.Account;
import xyz.mwszksnmdys.admin.bean.City;
import xyz.mwszksnmdys.admin.bean.User;
import xyz.mwszksnmdys.admin.interceptor.RedisUrlCountInterceptor;
import xyz.mwszksnmdys.admin.service.AccountService;
import xyz.mwszksnmdys.admin.service.CityService;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CityService cityService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/acct/city/{id}")
    @ResponseBody
    public City getCityById(@PathVariable("id") Long id){
        return cityService.getById(id);
    }

    @PostMapping("/acct/city")
    @ResponseBody
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @GetMapping("/acct/{id}")
    @ResponseBody
    public Account getById(@PathVariable("id") Long id){
        return accountService.getAccountById(id);
    }

    @ResponseBody
    @RequestMapping("/sql")
    public String query(){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from t_user", Integer.class);
        return integer.toString();
    }

    @GetMapping({"/", "/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("loginUser", user);
            // 登录成功，重定向到main页面， 重定向防止表单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null) {
//            return "main";
//        }else {
//            // 回到登录页面
//            model.addAttribute("msg", "请重新登录");
//            return "login";
//        }

        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String s = ops.get("/main.html");
        String s1 = ops.get("/sql");

        model.addAttribute("mainCount", s);
        model.addAttribute("sqlCount", s1);

        log.info("当前方法是{}", "mainPage");
        return "main";
    }
}

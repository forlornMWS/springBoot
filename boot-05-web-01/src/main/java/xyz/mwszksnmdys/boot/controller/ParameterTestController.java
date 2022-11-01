package xyz.mwszksnmdys.boot.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import xyz.mwszksnmdys.boot.bean.Person;

import javax.servlet.http.Cookie;
import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{name}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("name") String name,
                                      @PathVariable Map<String, String> pathMap,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("interests") List<String> interests,
                                      @RequestParam MultiValueMap<String, String> paramsMap,
                                      @CookieValue("_xsrf") String _xsrf) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pathMap", pathMap);
        map.put("user-agent", userAgent);
        map.put("header", header);
        map.put("age", age);
        map.put("interests", interests);
        map.put("paramsMap", paramsMap);
        map.put("_xsrf", _xsrf);
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String content) throws UnsupportedEncodingException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("content", URLDecoder.decode(content, "utf-8"));
        return map;
    }

//  矩阵变量语法： /cars/sell;low=34;brand=byd,audi,yd
//    SpringBoot默认禁用了矩阵变量功能，需要手动开启
//    对于路径处理，UrlPathHelper进行解析
//    removeSemicolonContent: 移除分号内容
    @RequestMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brands,
                        @Nullable @MatrixVariable("hello") List<String> hello,
                        @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("low", low);
        map.put("brands", brands);
        map.put("path", path);
        map.put("hello", hello);
        return map;
    }

    // boss/1;age=23/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(
            @MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
            @MatrixVariable(value = "age", pathVar = "empId") Integer empAge
    ){
        Map<String, Object> map = new HashMap<>();
            map.put("bossAge", bossAge);
            map.put("empAge", empAge);
            return map;
    }

    @PostMapping("/saveUser")
    public Person saveUser(Person person){
        return person;
    }
}

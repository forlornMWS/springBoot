package xyz.mwszksnmdys.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @RequestMapping("/goto")
    public String goPage(HttpServletRequest request){
        request.setAttribute("msg", "成功了");
        request.setAttribute("code", 200);
        return "forward:/success"; // 转发到/success请求
    }

    @GetMapping("/params")
    public String testParams(Model model,
                             Map<String, Object> map,
                             HttpServletRequest request,
                             HttpServletResponse response){
        map.put("hello", "world666");
        model.addAttribute("world", "hello666");
        request.setAttribute("message", "HelloWorld!!!");
        Cookie cookie = new Cookie("k", "v");
        response.addCookie(cookie);
        return "forward:/success";
    }

    @GetMapping("/success")
    @ResponseBody
    public Map SimulateSuccessHtmlPage(@RequestAttribute(value = "msg", required = false) String msg,
                                       @RequestAttribute(value = "code", required = false) Integer code,
                                       HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");
        Map<String, Object> map = new HashMap<>();
        map.put("Annotation_msg", msg);
        map.put("Request_msg", msg1);
        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);
        map.put("code", code);
        return map;
    }
}

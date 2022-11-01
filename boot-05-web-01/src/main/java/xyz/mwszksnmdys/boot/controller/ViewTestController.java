package xyz.mwszksnmdys.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
    @GetMapping("/mws")
    public String mws(Model model){
        model.addAttribute("msg", "你好，mws");
        model.addAttribute("link", "https://www.baidu.com");
        return "success";
    }

}

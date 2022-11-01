package xyz.mwszksnmdys.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.mwszksnmdys.admin.bean.User;
import xyz.mwszksnmdys.admin.exception.MaxUserNumberExceededException;
import xyz.mwszksnmdys.admin.service.UserService;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    private UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(@RequestParam(value = "a", required = true) Integer a){
//        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){

//        List<User> users = Arrays.asList(
//                new User("zhagnsan", "123435"),
//                new User("lisi", "asdg"),
//                new User("wangwu", "fsaf"),
//                new User("liuxiu", "fsdaf")
//        );
//        model.addAttribute("users", users);

//        if(users.size() > 3){
//            throw new MaxUserNumberExceededException();
//        }

        List<User> list = userService.list();
        model.addAttribute("users", list);
//        Page<User> userPage = new Page<>(pn, 2);
//        Page<User> page = userService.page(userPage, null);
//        model.addAttribute("page", page);
        return "table/dynamic_table";
    }

    @GetMapping("delete/user/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.removeById(id);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

//    pricing_table.html
    @GetMapping("pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

//    responsive_table.html
    @GetMapping("responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}

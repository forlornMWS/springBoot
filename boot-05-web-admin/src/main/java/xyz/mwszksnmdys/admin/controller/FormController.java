package xyz.mwszksnmdys.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormController {

//    form_layouts
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos,
                         Model model) throws IOException {
        log.info("上传信息：username={}, email={}, headerImg={}, photos={}",
                username, email, headerImg.getSize(), photos.length);
        if(!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\Pictures\\Saved Pictures\\" + originalFilename));
        }

        if (photos.length > 0){
            for(MultipartFile photo : photos){
               if(!photo.isEmpty()){
                   String filename = photo.getOriginalFilename();
                   photo.transferTo(new File("D:\\Pictures\\Saved Pictures\\" + filename));
               }
            }
        }

        model.addAttribute("msg", "上传成功");
        return "form/form_layouts";
    }
}

package com.example.springproject.mvc.controller;

import com.example.springproject.mvc.vo.UserVO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class ModelController {
//    @GetMapping("/model_data")
//    public String get_model(Model model) {
//        // model.getAttribute("data1", "test");
//        return "dsf";
//    }

    @InitBinder("today")
    public void initBinder(WebDataBinder binder) {
        System.out.println("==== binder execute ====");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        binder.addCustomFormatter(new DateFormatter("yyyyMMdd"));
        dateFormat.setLenient(false);
        binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/model_data")
    @ModelAttribute()
    public ModelAndView get_model(ModelAndView modelAndView) {
        modelAndView.addObject("data1", new String("Passed data1"));
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @GetMapping("/board/{category}/{no}")
    public String get_board(
            @PathVariable(name = "category") String c,
            @PathVariable int no
    ) {
        System.out.println("Passed Path Value : " + no);
        return "main/board";
    }

    @PostMapping("/board")
    public void post_board(Date today, String[] lang) {
        System.out.println("today : " + today);
        for(String l : lang) {
            System.out.println("lang : " + l);
        }
    }

    @GetMapping(value = "/user/get")
    public String get_user(UserVO vo, @RequestParam String msg, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", msg);
        System.out.println(vo);
        return "user";
        // return "redirect:user"; get_user()로 GET
    }
    @PostMapping("/user/create")
    public String get_user_create(UserVO vo, RedirectAttributes redirectAttributes) {
        System.out.println("Passed data : " + vo);
        redirectAttributes.addAttribute("vo", vo);
        String msg = "";
        if(vo.getAge() < 20) {
            msg = "미성년";
        } else {
            msg = "성인";
        }
        return "redirect:/user/get?msg=" + URLEncoder.encode(msg, StandardCharsets.UTF_8);
    }

    @GetMapping("/red")
    public String get_red_redirect(RedirectAttributes redirectAttributes) {
        // Model과 같이 쿼리 스트링으로 값을 전달 (URL에 보임)
        // "redirect:/blue?data1=data1" 과 같이 redirect:/blue 처럼 url 인코딩을 자동으로
        redirectAttributes.addAttribute("data10", "Halo");

        // 1회용, 한번만 값을 전달하는 용도 (URL에 안보임)
        redirectAttributes.addFlashAttribute("data2", "data2");
        return "redirect:/blue";
    }

    @GetMapping("/blue")
    public String get_blue_redirect(RedirectAttributes redirectAttributes) {
        return "user";
    }
}
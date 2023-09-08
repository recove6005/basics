package com.example.springproject.mvc.controller;

import com.example.springproject.mvc.vo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class TestController {
    // localhost/order/it : it 종류의 1000원 이하의 물건 출력
    //              name님, 원하는 물건은 ??? 입니다.


    // 물건 종류 : it => 컴퓨터800, 마우스200, 키보드400, 오디오500, food => 사과100, 배200, 오렌지300
    // 카테고리 종류 : it, food

    // mapping url : /order/category명 => 해당 카테고리의 번호에 맞게 출력됨

    //    파라미터 값 :
    //        name : 주문한 유저명
    //        price : 원하는 가격대

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView error_arith_handler(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", "Arith 에러가 발생했습니다!!!");
        modelAndView.setViewName("/test/order");
        return modelAndView;
    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView error_execpt_handler(Exception e){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("error", "Except 에러가 발생했습니다!!!");
//        modelAndView.setViewName("/test/order");
//        return modelAndView;
//    }

    @GetMapping("/error")
    public void get_error() {
        int[] a = new int[] {1};
        System.out.println(a[1000]);
    }

    @GetMapping("/order/{category}")
    public String get_order(
            @PathVariable String category,
            @RequestParam String name,
            @RequestParam int price,
            Model model
    ){

        List<Item> result = get_items(category, price); // VIEW에 전달될 결과
        model.addAttribute("result", result);
        model.addAttribute("name", name);

        return "/test/result";
    }

    private List<Item> get_items(String category, int price){
        List<Item> result = new ArrayList<>(); // VIEW에 전달될 결과
        List<Item> items = null;

        if(category.equals("it")){
            //해당되는 item들의 객체를 LIST로 묶어서 VIEW로 전송
            items = Arrays.asList(
                    new Item("컴퓨터", 100),
                    new Item("마우스", 200),
                    new Item("키보드", 300),
                    new Item("오디오", 400)
            );
            for(Item item : items){
                if(item.getPrice() <= price){
                    result.add(item);
                }
            }
        }
        else if (category.equals("food")) {
            items = Arrays.asList(
                    new Item("사과", 100),
                    new Item("배", 200),
                    new Item("오렌지", 300),
                    new Item("수박", 400)
            );
        }

        for(Item item : items){
            if(item.getPrice() <= price){
                result.add(item);
            }
        }

        return result;
    }
}
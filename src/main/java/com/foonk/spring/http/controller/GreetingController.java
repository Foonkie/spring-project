package com.foonk.spring.http.controller;

import com.foonk.spring.database.repository.CompanyRepository;
import com.foonk.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/v1")
public class GreetingController {
    @GetMapping("/hello/")
    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest request)
  {     modelAndView.addObject("user", new UserReadDto(1L,"Ivan"));
        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }
    @GetMapping("/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView, HttpServletRequest request, CompanyRepository companyRepository,
                              @RequestParam Integer age,
                              @RequestHeader String accept,
                              @CookieValue("JSESSIONID") String jsessionId,
                              @PathVariable("id") Integer id) {
        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }
    @GetMapping("/bye")
    public ModelAndView bye() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting/bye");

        return modelAndView;
    }
}

package com.foonk.spring.http.controller;

import com.foonk.spring.database.entity.Role;
import com.foonk.spring.database.repository.CompanyRepository;
import com.foonk.spring.dto.UserReadDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes({"user"})
@RequestMapping("/api/v1")
public class GreetingController {
    @ModelAttribute("roles")
    public List<Role> roles() {
        return Arrays.asList(Role.values());
    }
    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest request, @ModelAttribute("userReadDto") UserReadDto userReadDto)
  {
      model.addAttribute("user", new UserReadDto(1L, "Ivan"));
        return "greeting/hello";
    }
    @GetMapping("/hello/{id}")
    public String hello2(Model model, HttpServletRequest request, CompanyRepository companyRepository,
                               @RequestParam Integer age,
                               @RequestHeader String accept,
                               @CookieValue("JSESSIONID") String jsessionId,
                               @PathVariable("id") Integer id) {
        return "greeting/hello";
    }
    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user) {
        return "greeting/bye";
    }
}

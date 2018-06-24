package com.qwc.sample.web.controller;

import com.qwc.sample.web.model.Hello;
import com.qwc.sample.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    @RequestMapping("/timestamp")
    @ResponseBody
    public Object date(Date date) {
        Map<String, Object> result = new HashMap<>();
        result.put("timestamp", date.getTime());
        return result;
    }

    @RequestMapping("/hello")
    public String hello(ModelMap model) {
        Hello hello = helloService.query();
        model.addAttribute("hello", hello);
        return "hello";
    }

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView("welcome");
        Hello hello = helloService.query();
        mv.addObject("hello", hello);
        return mv;
    }

    @RequestMapping(value = "/client/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Object client(@PathVariable String name, String title) {
        Map map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "成功");
        map.put("data", title + ": " + name);
        return map;
    }
}
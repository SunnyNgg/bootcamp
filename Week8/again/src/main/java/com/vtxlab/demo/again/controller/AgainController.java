package com.vtxlab.demo.again.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController // = @Controller + @ResponseBody
@RequestMapping(value = "/api/v2")



public class AgainController {

  

  // Restful API
  @GetMapping(value = {"/helloworld/{str}/age/{age}", "/helloworld/age"})
  // /api/v1/helloworld
  public String helloworld(
    @PathVariable (value = "str", required = false)String str,
   @PathVariable (value = "age", required = false) Integer age) 
   throws Exception{
    if (str == null || age == null){
      return "xyz";
    }

    if ("abc".equals(str) && age > 30){
      return "hello world! Sunny " + str;
    }
    return "123";
   }

   @GetMapping(value = "/greeting")
   public String greeting (@RequestParam String gender,
   @RequestParam String age){
    if ("M".equals(gender) && "2".equals(age)){
      return "Gender" + gender;
    }
    return "default";
   }
   @GetMapping(value = "/hungry")
   public String hungry (@RequestParam String hungry){
    if("abc".equals(hungry)){
      return "hungry" + hungry;
    }
    return " I am good ";
    
   }

   


  }
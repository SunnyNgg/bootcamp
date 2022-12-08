package com.vtxlab.demo.helloworld.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.helloworld.service.HelloworldService;


//@Controller
//@ResponseBody
@RestController // = @Controller + @ResponseBody
@RequestMapping(value = "/api/v1")



public class HelloworldController {
  @Autowired
  public HelloworldService helloworldService;

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
   @RequestParam String age ){
    if ("M".equals(gender) && "2".equals(age)){
     return "Gender" + gender;  
     }
     return "default";
    }

    @GetMapping(value = "/hungry")
    public String hungry (@RequestParam String hungry){
      if ("abc".equals(hungry)){
      return "hungry" + hungry;
    }
    return " I am ok ";
  }

  @GetMapping(value = {"/optional/string/{str}",
  "/optional/string"})
  public String getAge (@PathVariable Optional<String> str){
     // String var = "123";
     // str.ifPresent(e-> {
      //  var = e + "abc";
      //});
      if (str.isPresent()){
        return str.get();
      }
      return "default";

  }

  @GetMapping (value = {"/name/{name}/age/{age}"})
  public String getname (
    @PathVariable Map<String,String > name){
    return name.get("name") + name.get("age");
  }

  @GetMapping( value = "/helloworld/{name}")
  public String getHelloworld(@PathVariable String name){
   // HelloworldService helloworldService = new HelloworldService();
    return helloworldService.sayHelloService(name);
  }

  @GetMapping( value = "/helloworld/list/{name}/{name2}")
  public List<String> getHelloworldbyList(
    @PathVariable Map<String, String> map){
   // HelloworldService helloworldService = new HelloworldService();
   List<String> strings = new ArrayList<>();
   map.forEach((a,b) ->{
   strings.add(helloworldService.sayHelloService(b));
   });
    return strings;
  }

  @PostMapping(value = {"/giftlist/{name}"})
  public Boolean createString (@PathVariable String name){
    return helloworldService.createString(name);
  }

  @GetMapping(value = {"/giftlist"})
  public ResponseEntity <List<String>> getAllString(){
    try{
      List<String> string = helloworldService.getAllString();
      return ResponseEntity.ok().body(string);
    }catch(Exception e ){
      return ResponseEntity.badRequest().body(new ArrayList<>());
    }  
    
  }


    @DeleteMapping(value = {"/giftlist"})
    public List<String> deleteAll(){
      if (helloworldService.deleteAll()){
        return helloworldService.getAllString();
      }
      return new ArrayList<>();
    }

    @DeleteMapping(value = {"/giftlist/deleteLast"})
    public String deleteLast(){
      return helloworldService.deleteLast();
    }

    @GetMapping (value = {"/giftlist/Tfilter"})
     public List<String> Tstrings(){
      return helloworldService.getAllString().stream()
            .filter(e -> e.toUpperCase().startsWith("T"))
            .collect(Collectors.toList());

     };

     @PutMapping(value = {"/giftlist"})
     public List<String> updateeStrings(@RequestBody List<String> strings){
      return helloworldService.updateStrings(strings);
     }

  // Update the first element of the string list
     @PatchMapping(value = "/giftlist/firstElement/{element}")
     public String updateFirst(@PathVariable String element ){
      return helloworldService.updateFirst(element);
     }
     
    
    }

  






  
  

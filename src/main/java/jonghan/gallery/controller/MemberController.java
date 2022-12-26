package jonghan.gallery.controller;


import org.springframework.web.bind.annotation.*;



@RestController
public class MemberController {

    @PostMapping("/name")
    public void signUp(@RequestBody String name){

    }

    @GetMapping("/mygallery")
    public String findByPicture(){

    }
    @PostMapping("/mygallery")
    public void save(@RequestBody String picture){

    }



}

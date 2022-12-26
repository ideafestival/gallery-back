package jonghan.gallery.board.controller;


import jonghan.gallery.board.dto.MemberDto;
import jonghan.gallery.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login/name")
    public void signUp(@RequestBody MemberDto name){
        memberService.signUp(name);
    }

    @GetMapping("/mygallery")
    public void findPicture(){
    }
    @PostMapping("/mygallery")
    public void save(@RequestBody String picture){
        memberService.save(picture);
    }



}

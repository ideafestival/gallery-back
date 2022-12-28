package jonghan.gallery.board.controller;


import jonghan.gallery.board.dto.requestdto.MemberDto;
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

    @PostMapping("/login")
    public MemberDto login(MemberDto memberDto){
        memberService.memberDtoSave(memberDto);
        return memberDto;
    }


    @PostMapping("/gallery/{name}")
    public void save(@PathVariable("name") String name,@RequestBody String picture){
        memberService.PictureSave(name,picture);
    }
    @GetMapping("/gallery/{name}")
    public List<String> findPicture(@PathVariable("name")String name){
        return memberService.findPicture(name);
    }



}

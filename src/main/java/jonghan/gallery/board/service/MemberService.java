package jonghan.gallery.board.service;


import jonghan.gallery.board.dto.requestdto.MemberDto;
import jonghan.gallery.board.dto.requestdto.PictureEntityDto;
import jonghan.gallery.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;


@Service
public class MemberService {
    private final MemberRepository memberRepository;




    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void memberDtoSave(MemberDto memberDto){
        memberRepository.save(memberDto.toEntity());

    }

    public void PictureSave(String name, String picture){
        PictureEntityDto pictureEntityDto = new PictureEntityDto(name,picture);
        memberRepository.save(pictureEntityDto.toEntity());
    }

    public List<String> findPicture(String name){
        return memberRepository.findAllByName(name);
    }

}

























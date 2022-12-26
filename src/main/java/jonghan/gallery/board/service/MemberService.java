package jonghan.gallery.board.service;

import jonghan.gallery.board.dto.MemberDto;
import jonghan.gallery.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public void signUp(MemberDto name){
        memberRepository.save(name.toEntity());
    }
    public void save(String picture){

    }

    public List<String> findPicture(){
        return memberRepository.findAll(Entity.);
    }




}

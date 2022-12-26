package jonghan.gallery.board.dto;

import jonghan.gallery.board.entity.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private String name;

    public Member toEntity(){
        return Member.builder()
                .name(this.name)
                .build();
    }
}

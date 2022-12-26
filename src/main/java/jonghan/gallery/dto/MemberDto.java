package jonghan.gallery.dto;

import jonghan.gallery.entity.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String name;

    private String email;
    public Member toEntity(){
        return Member.builder()
                .name(this.name)
                .email(this.email)
                .build();
    }
}

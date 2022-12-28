package jonghan.gallery.board.dto.requestdto;

import jonghan.gallery.board.entity.Members;
import lombok.AllArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@Setter
public class MemberDto {

    private String email;
    private String name;
    private String userProfile;

    public Members toEntity(){
        return Members.builder()
                .name(name)
                .useProfiles(userProfile)
                .email(email)
                .build();
    }


}

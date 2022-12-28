package jonghan.gallery.board.dto.requestdto;


import jonghan.gallery.board.entity.Members;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class PictureEntityDto {
    private String name;
    private String picture;

    public Members toEntity(){
        return Members.builder()
                .name(name)
                .pictures(picture)
                .build();
    }
}

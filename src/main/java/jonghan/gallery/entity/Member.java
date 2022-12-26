package jonghan.gallery.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String name;
    @Id
    private String email;


}

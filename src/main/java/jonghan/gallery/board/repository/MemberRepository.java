package jonghan.gallery.board.repository;

import jonghan.gallery.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {

}

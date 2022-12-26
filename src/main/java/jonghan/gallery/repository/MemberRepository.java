package jonghan.gallery.repository;

import jonghan.gallery.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,String> {

}

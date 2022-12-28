package jonghan.gallery.board.repository;

import jonghan.gallery.board.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Members,String> {
    List<String> findAllByName(String name);
}

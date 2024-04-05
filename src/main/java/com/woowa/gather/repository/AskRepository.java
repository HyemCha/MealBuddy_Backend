package com.woowa.gather.repository;

import com.woowa.gather.domain.Ask;
import com.woowa.gather.domain.dto.AskListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AskRepository extends JpaRepository<Ask, Integer> {

//    @Query("select new com.woowa.gather.domain.dto.AskListResponse(" +
//            "a.id, p.id, u.id, p.foodTypeTag, p.genderTag, p.ageTag, l.address, l.place, p.participantTotal, " +
//            "p.participantCount, p.postStatus, a.askStatus, p.meetAt, p.closeAt, p.createdAt) " +
//            "from Ask a " +
//            "join Post p on a.post = p " +
//            "join User u on a.user = u " +
//            "join Location l on a.post.location = l " +
//            "where u.id = :userId")
//    Optional<AskListResponse> findAskListByWriterId(@Param("userId") int userId);


}

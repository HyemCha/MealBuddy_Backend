package com.woowa.gather.repository;

import com.woowa.gather.domain.Post;
import com.woowa.gather.domain.dto.AskListResponse;
import com.woowa.gather.domain.dto.UserPostListResponse;
import com.woowa.gather.domain.enums.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select new com.woowa.gather.domain.dto.UserPostListResponse(" +
            "p.id, u.id, p.foodTypeTag, p.genderTag, p.ageTag, l.address, l.place, p.participantTotal, " +
            "p.participantCount, p.postStatus, p.meetAt, p.closeAt, p.createdAt) " +
            "from Post p " +
            "join Location l on p.location = l " +
            "left join User u on p.user = u " +
            "where u.id = :userId and p.postStatus = :postStatus")
    Optional<List<UserPostListResponse>> findPostListByWriterId(@Param("userId") int userId, @Param("postStatus") PostStatus postStatus);
}
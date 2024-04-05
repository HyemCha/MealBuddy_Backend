package com.woowa.gather.service;

import com.woowa.gather.domain.Location;
import com.woowa.gather.domain.Post;
import com.woowa.gather.domain.dto.UserPostListResponse;
import com.woowa.gather.domain.enums.Age;
import com.woowa.gather.domain.enums.FoodType;
import com.woowa.gather.domain.enums.Gender;
import com.woowa.gather.domain.enums.PostStatus;
import com.woowa.gather.repository.AskRepository;
import com.woowa.gather.repository.PostRepository;
import com.woowa.user.UserRepository;
import com.woowa.user.domain.User;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
public class AskServiceTest {

    @Autowired
    private AskRepository askRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

//    @BeforeEach
    void beforeEach() {
        User writer = userRepository.save(User.builder()
                .age(20)
                .phone("010-0000-1111")
                .gender(com.woowa.user.domain.Gender.FEMALE)
                .introduce("hello")
                .nickname("nickname")
                .build());

        Point point = new Point(1.1234, 1.1234);
        Location location = Location.builder()
                .address("경기도 화성시 ~")
                .place("ㅇㅇ떡볶이")
                .point(point)
                .build();
        Post post1 = postRepository.save(Post.builder()
                .user(writer)
                .location(location)
                .contents("같이 밥먹을 파티원 구함")
                .ageTag(Age.AGE20S)
                .foodTypeTag(FoodType.ALCOHOL)
                .genderTag(Gender.FEMALE)
                .participantCount(1)
                .participantTotal(4)
                .postStatus(PostStatus.ONGOING)
                .meetAt(LocalDateTime.of(2024, 4, 20, 12,30))
                .closeAt(LocalDateTime.of(2024, 4, 20, 11,0))
                .build());
        Post post2 = postRepository.save(Post.builder()
                .user(writer)
                .location(location)
                .contents("같이 밥먹을 파티원 구함")
                .ageTag(Age.AGE20S)
                .foodTypeTag(FoodType.ALCOHOL)
                .genderTag(Gender.FEMALE)
                .participantCount(1)
                .participantTotal(4)
                .postStatus(PostStatus.ONGOING)
                .meetAt(LocalDateTime.of(2024, 4, 21, 12,30))
                .closeAt(LocalDateTime.of(2024, 4, 21, 11,0))
                .build());


    }

    @Test
    @DisplayName(value = "사용자_id로_모집_리스트를_가져올수있다")
    void getUserPostListByUserId() {
        User writer = userRepository.save(User.builder()
                .age(20)
                .phone("010-0000-1111")
                .gender(com.woowa.user.domain.Gender.FEMALE)
                .introduce("hello")
                .nickname("nickname")
                .build());

        log.info("user={}", writer.getId());

        Point point = new Point(1.1234, 1.1234);
        Location location1 = Location.builder()
                .address("경기도 화성시 ~")
                .place("ㅇㅇ떡볶이")
                .point(point)
                .build();
        Post post1 = postRepository.save(Post.builder()
                .user(writer)
                .location(location1)
                .contents("같이 밥먹을 파티원 구함")
                .ageTag(Age.AGE20S)
                .foodTypeTag(FoodType.ALCOHOL)
                .genderTag(Gender.FEMALE)
                .participantCount(1)
                .participantTotal(4)
                .postStatus(PostStatus.ONGOING)
                .meetAt(LocalDateTime.of(2024, 4, 20, 12,30))
                .closeAt(LocalDateTime.of(2024, 4, 20, 11,0))
                .build());
        Location location2 = Location.builder()
                .address("경기도 화성시 ~")
                .place("ㅇㅇ떡볶이")
                .point(point)
                .build();
        Post post2 = postRepository.save(Post.builder()
                .user(writer)
                .location(location2)
                .contents("같이 밥먹을 파티원 구함")
                .ageTag(Age.AGE20S)
                .foodTypeTag(FoodType.ALCOHOL)
                .genderTag(Gender.FEMALE)
                .participantCount(1)
                .participantTotal(4)
                .postStatus(PostStatus.ONGOING)
                .meetAt(LocalDateTime.of(2024, 4, 21, 12,30))
                .closeAt(LocalDateTime.of(2024, 4, 21, 11,0))
                .build());

        List<UserPostListResponse> postListByWriterId = postRepository.findPostListByWriterId(writer.getId(), PostStatus.ONGOING).get();

        log.info("결과={}", postListByWriterId.get(0).getAgeTag());

    }
}

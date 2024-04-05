package com.woowa;

import com.woowa.gather.domain.Location;
import com.woowa.gather.domain.Post;
import com.woowa.gather.domain.enums.Age;
import com.woowa.gather.domain.enums.FoodType;
import com.woowa.gather.domain.enums.PostStatus;
import com.woowa.gather.repository.PostRepository;
import com.woowa.user.UserRepository;
import com.woowa.user.domain.Gender;
import com.woowa.user.domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitDummyData {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() {
        User writer = createUser(30, "010-1234-1234", Gender.FEMALE);

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
                .genderTag(com.woowa.gather.domain.enums.Gender.FEMALE)
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
                .genderTag(com.woowa.gather.domain.enums.Gender.FEMALE)
                .participantCount(1)
                .participantTotal(4)
                .postStatus(PostStatus.ONGOING)
                .meetAt(LocalDateTime.of(2024, 4, 21, 12,30))
                .closeAt(LocalDateTime.of(2024, 4, 21, 11,0))
                .build());

        log.info("userId={}", writer.getId());
    }

    User createUser(int age, String phone, Gender gender) {
        return userRepository.save(User.builder()
                .age(age)
                .phone(phone)
                .gender(gender)
                .introduce("hello")
                .nickname("nickname")
                .build());
    }

    Post createPost(User writer, Location location) {
        return postRepository.save(Post.builder()
                .user(writer)
                .location(location)
                .contents("같이 밥먹을 파티원 구함")
                .ageTag(Age.AGE20S)
                .foodTypeTag(FoodType.ALCOHOL)
                .genderTag(com.woowa.gather.domain.enums.Gender.FEMALE)
                .participantCount(1)
                .participantTotal(4)
                .postStatus(PostStatus.ONGOING)
                .meetAt(LocalDateTime.of(2024, 4, 21, 12,30))
                .closeAt(LocalDateTime.of(2024, 4, 21, 11,0))
                .build());
    }
}

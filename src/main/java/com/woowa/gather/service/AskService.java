package com.woowa.gather.service;

import com.woowa.gather.domain.dto.AskListResponse;
import com.woowa.gather.domain.dto.AskRequest;
import com.woowa.gather.domain.dto.UserPostListResponse;
import com.woowa.gather.domain.enums.FoodType;
import com.woowa.gather.domain.enums.PostStatus;
import com.woowa.gather.repository.AskRepository;
import com.woowa.gather.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AskService {
    private final AskRepository askRepository;
    private final PostRepository postRepository;

    public int ask(AskRequest askRequest) {
        return 1;
    }

    public List<AskListResponse> getAskList(int type, int userId) {
        AskListResponse askListResponse1 = AskListResponse.builder()
                .askId(1)
                .postId(1)
                .foodType(FoodType.ALCOHOL)
                .userId(1)
                .build();
        AskListResponse askListResponse2 = AskListResponse.builder()
                .askId(1)
                .postId(1)
                .foodType(FoodType.ALCOHOL)
                .userId(1)
                .build();

        return List.of(askListResponse1, askListResponse2);
    }

    public List<UserPostListResponse> getUserPostList(int userId, int type) {
        PostStatus postStatus = type == 0 ? PostStatus.ONGOING : type == 1 ? PostStatus.COMPLETION : PostStatus.CLOSED;
        log.info("userid={}, type={}", userId, type);

        return postRepository.findPostListByWriterId(userId, postStatus)
                .orElseThrow(() -> new NoSuchElementException("결과가 존재하지 않습니다."));
    }
}

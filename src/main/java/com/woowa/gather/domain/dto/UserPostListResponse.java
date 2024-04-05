package com.woowa.gather.domain.dto;

import com.woowa.gather.domain.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UserPostListResponse {

    private int postId;
    private int userId;
    private FoodType foodTypeTag;
    private Gender genderTag;
    private Age ageTag;
    private String address;
    private String place;
    private int participantTotal;
    private int participantCount;
    private PostStatus postStatus;
    private LocalDateTime meetAt;
    private LocalDateTime closeAt;
    private LocalDateTime createdAt;

}

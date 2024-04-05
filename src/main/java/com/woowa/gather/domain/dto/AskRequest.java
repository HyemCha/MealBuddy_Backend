package com.woowa.gather.domain.dto;

import com.woowa.gather.domain.Ask;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AskRequest {
    private int userId;
    private int postId;

}

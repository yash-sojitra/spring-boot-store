package com.codewithmosh.store.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
//    @JsonFormat(pattern = "dd-MM-yyyy  HH:mm:ss")
//    private LocalDateTime createdAt;
}

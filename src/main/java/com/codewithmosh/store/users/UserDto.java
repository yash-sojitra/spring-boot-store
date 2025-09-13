package com.codewithmosh.store.users;

import lombok.*;

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

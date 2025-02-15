package org.example.oauth2.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDTO {
    private String userName;
    private String password;
    private String nickName;
    private String phone;
}

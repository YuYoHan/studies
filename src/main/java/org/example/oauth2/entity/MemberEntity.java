package org.example.oauth2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity {
    @Id @GeneratedValue
    private Long id;

    private String userName;
    private String email;
    private String role;


    public void setEmail(String email) {
        this.email = email;
    }
}

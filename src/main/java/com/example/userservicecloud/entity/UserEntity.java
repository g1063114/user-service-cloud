package com.example.userservicecloud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false, unique = true)
    private String encryptedPwd;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public UserEntity(String name, String email, String userId, String encryptedPwd, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.userId = userId;
        this.encryptedPwd = encryptedPwd;
        this.createdAt = createdAt;
    }
}

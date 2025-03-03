package com.sweethome.checklist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "userId", unique = true)
})
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Setter
    @Column(unique = true, nullable = false, length = 20)
    private String userId;

    @Setter
    @Column(nullable = false)
    private String password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime created_at;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column
    private LocalDateTime modified_at;

    @Setter
    @Column(nullable = false)
    private UserState userState;

    @Setter
    @Column
    private LocalDateTime last_login_at;

    @Setter
    @Column(nullable = false)
    private Integer loginFailCount;

    @Setter
    @Column
    private LocalDateTime last_login_try_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(userSeq, user.userSeq) && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userSeq, userId);
    }
}

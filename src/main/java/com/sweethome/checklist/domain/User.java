package com.sweethome.checklist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "userId", unique = true)
})
@Entity
public class User extends TimeAuditingFields {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Setter
    @Column(unique = true, nullable = false, length = 20)
    private String userId;

    @Setter
    @Column(nullable = false)
    private String password;

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

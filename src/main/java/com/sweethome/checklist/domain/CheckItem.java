package com.sweethome.checklist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Objects;

@Getter
@Table
@Entity
public class CheckItem extends AuditingFields {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkItemId;

    @Setter
    @Column(nullable = false, length = 50)
    private String checkItemName;

    @Setter
    @Column(nullable = false)
    private IntervalType intervalType;

    @Setter
    @Column(nullable = false)
    private LocalTime checkItemDate;

    @Setter
    @Column
    private CheckItemState checkItemState;

    @Setter
    @JoinColumn(name = "userSeq")
    @ManyToOne(optional = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckItem checkItem)) return false;
        return Objects.equals(checkItemId, checkItem.checkItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(checkItemId);
    }
}

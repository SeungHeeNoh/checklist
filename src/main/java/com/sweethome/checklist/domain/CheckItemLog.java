package com.sweethome.checklist.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Table
@Entity
public class CheckItemLog extends AuditingFields{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkItemLogId;

    @Setter
    @JoinColumn(name = "checkItemId")
    @ManyToOne(optional = false)
    private CheckItem checkItem;

    @Setter
    @Column
    private CheckStatus checkStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckItemLog that)) return false;
        return Objects.equals(checkItemLogId, that.checkItemLogId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(checkItemLogId);
    }
}

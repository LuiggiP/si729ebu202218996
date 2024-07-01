package org.hign.platform.u202218996.shared.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * AuditableAbstractAggregateRoot.
 * <p>
 * Base class for all aggregate roots that require auditing.
 * </p>
 *
 * @param <T> the type of the aggregate root
 *
 * @author Luiggi Paredes U202218996
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditableAbstractAggregateRoot<T extends AbstractAggregateRoot<T>> extends AbstractAggregateRoot<T> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Getter
    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    /**
     * Default constructor for JPA.
     */
    protected AuditableAbstractAggregateRoot() {
    }
}




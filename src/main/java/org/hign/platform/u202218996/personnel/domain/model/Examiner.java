package org.hign.platform.u202218996.personnel.domain.model;

import org.hign.platform.u202218996.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.hign.platform.u202218996.shared.domain.model.valueobjects.NationalProviderIdentifier;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Embedded
    private NationalProviderIdentifier nationalProviderIdentifier;

    public Examiner(String firstName, String lastName, NationalProviderIdentifier nationalProviderIdentifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }

    protected Examiner() {
    }
}


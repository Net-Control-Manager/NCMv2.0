package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "group_preamble")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupPreamble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @Column(nullable = false)
    private Group owner;

    @ManyToOne
    @Column(nullable = false)
    private User addedBy;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime dateAdded;

    private boolean isDeleted = false;
}

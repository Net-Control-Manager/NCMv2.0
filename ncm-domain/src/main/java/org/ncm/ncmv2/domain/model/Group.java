package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private GroupType type;

    @Column(unique = true, nullable = false)
    private String callsign;

    private String defaultFrequency;

    @ManyToMany
    private List<User> groupManagers;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime dateCreated;

    private boolean isDeleted = false;
}

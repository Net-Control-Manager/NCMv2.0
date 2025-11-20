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

    @Column(name="name", unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private GroupType type;

    @Column(unique = true, nullable = false)
    private String callsign;

    @Column(name="default_frequency")
    private String defaultFrequency;

    @ManyToMany()
    @JoinTable(
            name = "group_managers",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") }
    )
    private List<User> groupManagers;

    @CreationTimestamp
    @Column(name="date_created", nullable = false, updatable = false, columnDefinition = "timestamptz")
    private OffsetDateTime dateCreated;

    @Column(name="is_deleted")
    private boolean isDeleted = false;
}

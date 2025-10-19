package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "net")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@ToString(exclude = {"netType","netOwner","subNetParent","netEntries"})
public class Net {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "net_type_id")
    @ToString.Exclude
    private NetType netType;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "net_owner_id")
    @ToString.Exclude
    private User netOwner;

    @Column(name = "start_time", columnDefinition = "timestamptz")
    private OffsetDateTime startTime;

    @Column(name = "close_time", columnDefinition = "timestamptz")
    private OffsetDateTime closeTime;

    private boolean isPreBuilt;

    @Column(name = "pre_built_time", columnDefinition = "timestamptz")
    private OffsetDateTime preBuiltTime;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "sub_net_parent_id")
    @ToString.Exclude
    private Net subNetParent;

    @Builder.Default
    @OneToMany(mappedBy = "net")
    @ToString.Exclude
    private List<NetEntry> netEntries = new ArrayList<>();
}
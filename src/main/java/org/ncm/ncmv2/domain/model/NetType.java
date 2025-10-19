package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "net_type")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@ToString(exclude = "customOwner")
public class NetType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean isCustom;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "custom_owner_id")
    @ToString.Exclude
    private User customOwner;

    @Column(nullable = false)
    private boolean isDeleted;
}
package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "net_acl_entry")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NetAclEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Net net;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Station station;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NetAclLevel level;

}

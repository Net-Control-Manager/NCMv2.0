package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "net_role_permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NetRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Net net;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntryRole role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NetAclLevel level;

}

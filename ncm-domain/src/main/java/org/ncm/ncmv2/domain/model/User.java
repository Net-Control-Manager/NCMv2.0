package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "email_address", unique = true, nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private String password;

    @OneToOne
    private Station station;

    @Column(name="dark_mode")
    private boolean darkMode = false;

    @ElementCollection
    @CollectionTable(name = "column_prefs", joinColumns=@JoinColumn(name="user_id"))
    @Column(name="column_pref")
    private List<String> columnPref;

    @Column(name="has_2fa_enabled")
    private boolean has2faEnabled = false;

    @Column(name="is_suspended")
    private boolean isSuspended = false;
    @Column(name="is_deleted")
    private boolean isDeleted = false;


}

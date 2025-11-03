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

    private boolean darkMode = false;

    @ElementCollection
    @CollectionTable(name = "column_prefs", joinColumns=@JoinColumn(name="user_id"))
    @Column(name="column_pref")
    private List<String> columnPref;

    private boolean has2faEnabled = false;

    private boolean isSuspended = false;
    private boolean isDeleted = false;


}

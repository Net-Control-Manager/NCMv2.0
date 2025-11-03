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
    private String password;

    @OneToOne
    private Station station;

    private boolean isDarkMode;
    private List<String> columnPref;

    private boolean is2faEnabled;

    private boolean isSuspended;
    private boolean isDeleted;


}

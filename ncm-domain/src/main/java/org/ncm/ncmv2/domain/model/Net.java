package org.ncm.ncmv2.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="net")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Net {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany
    private List<NetEntry> entries;
    @OneToMany(fetch =  FetchType.LAZY)
    private List<NetTimelineEntry> timelineEntries;
}

package com.pocketpal.models;

import com.pocketpal.models.enums.StatusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private StatusType statusType;


}

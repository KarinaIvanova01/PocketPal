package com.pocketpal.models;

import com.pocketpal.models.enums.CardType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cards_id")
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "card_holder")
    private String holder;

    @Column(name = "check_number")
    private String checkNumber;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @ManyToOne
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "type_id")
    private Type cardType;

    @ManyToOne
    @Column(name = "user_id")
    private User user;

}

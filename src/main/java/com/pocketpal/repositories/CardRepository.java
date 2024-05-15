package com.pocketpal.repositories;

import com.pocketpal.models.Card;
import com.pocketpal.models.Type;
import com.pocketpal.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Card c WHERE c.id = :id")
    Long updateCard(@Param("id") Long id);

}


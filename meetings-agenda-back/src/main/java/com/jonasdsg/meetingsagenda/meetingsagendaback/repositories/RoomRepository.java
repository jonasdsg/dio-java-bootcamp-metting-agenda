package com.jonasdsg.meetingsagenda.meetingsagendaback.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.jonasdsg.meetingsagenda.meetingsagendaback.models.Room;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {
    
    @Query("SELECT r FROM Room r WHERE 1=1 AND"
        +" (:name is null or r.name = :name) AND "
        +" (:startAt is null or r.startAt = :startAt) AND"
        +" (:endAt is null or r.endAt = :endAt)")
    List<Room> find(@Param("name") String name,@Param("startAt") LocalDateTime startAt,@Param("endAt") LocalDateTime endAt);
}


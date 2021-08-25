package com.jonasdsg.meetingsagenda.meetingsagendaback.repositories;

import com.jonasdsg.meetingsagenda.meetingsagendaback.models.Room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {}

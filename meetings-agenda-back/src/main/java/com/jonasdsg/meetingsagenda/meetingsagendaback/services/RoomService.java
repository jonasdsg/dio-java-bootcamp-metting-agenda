package com.jonasdsg.meetingsagenda.meetingsagendaback.services;

import java.util.ArrayList;
import java.util.List;
 
import com.jonasdsg.meetingsagenda.meetingsagendaback.dtos.RoomDTO;
import com.jonasdsg.meetingsagenda.meetingsagendaback.mappers.RoomMapper;
import com.jonasdsg.meetingsagenda.meetingsagendaback.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    RoomRepository roomRepository;
    RoomMapper roomMapper;
    
    @Autowired
    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public RoomDTO findById(Long id) {
        return roomMapper.toDTO(roomRepository.findById(id).get());
    }

    public RoomDTO save(RoomDTO dto) {
        return roomMapper.toDTO(roomMapper.toModel(dto));
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

    public List<RoomDTO> findAll() {
        List<RoomDTO> rooms = new ArrayList<RoomDTO>();
        roomRepository.findAll().forEach(r->rooms.add(roomMapper.toDTO(r)));
        return rooms;
    }

}

package com.jonasdsg.meetingsagenda.meetingsagendaback.mappers;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

import java.time.LocalDateTime;

import com.jonasdsg.meetingsagenda.meetingsagendaback.dtos.RoomDTO;
import com.jonasdsg.meetingsagenda.meetingsagendaback.exceptions.FailureConvertingDtoObjectToModel;
import com.jonasdsg.meetingsagenda.meetingsagendaback.models.Room;

import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements Mapper<Room, RoomDTO> {

    @Override
    public RoomDTO toDTO(Room model) {
        try{
            RoomDTO dto = new RoomDTO();
            dto.id = model.getId();
            dto.name = model.getName();
    
            dto.startAt =  nonNull(model.getStartAt()) 
                ? model.getStartAt().toString() 
                : null;
            
            dto.endAt = nonNull(model.getEndAt()) 
                ? model.getEndAt().toString()
                : null;
            
            return dto;
            
        } catch(Exception e){
            throw new FailureConvertingDtoObjectToModel(e);
        }
    }

    @Override
    public Room toModel(RoomDTO dto) {
        try{
            Room model = new Room(dto.id,dto.name,LocalDateTime.parse(dto.startAt),LocalDateTime.parse(dto.endAt));
            return model;
        } catch(Exception e){
            throw new FailureConvertingDtoObjectToModel(e);
        }
    }

    @Override
    public List<RoomDTO> toListDTO(List<Room> models) {
        return models.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<Room> toListModel(List<RoomDTO> dtos) {
        return dtos.stream().map(this::toModel).collect(Collectors.toList());
    }

}

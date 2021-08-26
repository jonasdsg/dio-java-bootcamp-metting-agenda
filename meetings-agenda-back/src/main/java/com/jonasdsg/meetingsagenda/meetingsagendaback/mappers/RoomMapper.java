package com.jonasdsg.meetingsagenda.meetingsagendaback.mappers;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static java.util.Objects.nonNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.jonasdsg.meetingsagenda.meetingsagendaback.dtos.RoomDTO;
import com.jonasdsg.meetingsagenda.meetingsagendaback.exceptions.FailureConvertingDtoObjectToModel;
import com.jonasdsg.meetingsagenda.meetingsagendaback.models.Room;

import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements Mapper<Room, RoomDTO> {

    @Override
    public RoomDTO toDTO(Room model) {
        try {
            RoomDTO dto = new RoomDTO();
            dto.id = model.getId();
            dto.name = model.getName();

            dto.startAt = nonNull(model.getStartAt()) ? model.getStartAt().toString() : null;

            dto.endAt = nonNull(model.getEndAt()) ? model.getEndAt().toString() : null;

            return dto;

        } catch (Exception e) {
            throw new FailureConvertingDtoObjectToModel(e);
        }
    }

    @Override
    public Room toModel(RoomDTO dto) {
        try {
            LocalDateTime start = LocalDateTime.parse(dto.startAt, ISO_LOCAL_DATE_TIME);
            LocalDateTime end = LocalDateTime.parse(dto.endAt, ISO_LOCAL_DATE_TIME);
            return new Room(nonNull(dto.id) ? dto.id : null, dto.name, start, end);

        } catch (Exception e) {
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

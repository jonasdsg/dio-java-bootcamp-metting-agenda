package com.jonasdsg.meetingsagenda.meetingsagendaback.controllers;

import static java.util.Objects.nonNull;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import javax.websocket.server.PathParam;

import com.jonasdsg.meetingsagenda.meetingsagendaback.dtos.RoomDTO;
import com.jonasdsg.meetingsagenda.meetingsagendaback.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;


@RestController
@RequestMapping("room")
public class RoomController {
    @Autowired
    RoomService roomService;
    @GetMapping
    public ResponseEntity<List<RoomDTO>> findAll(
        @PathParam("name") String name,
        @PathParam("startAt") String startAt,
        @PathParam("endAt") String endAt){
        return ResponseEntity.ok().body(
            roomService.find(name,
            nonNull(startAt) ? LocalDateTime.parse(startAt) : null,
            nonNull(endAt) ? LocalDateTime.parse(endAt) : null));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> findById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(roomService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoomDTO> save(@RequestBody RoomDTO dto, UriBuilder uriBuilder){
        RoomDTO response = roomService.save(dto);
        URI uri = uriBuilder.path("/room/{id}").build(response.id);
        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        roomService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

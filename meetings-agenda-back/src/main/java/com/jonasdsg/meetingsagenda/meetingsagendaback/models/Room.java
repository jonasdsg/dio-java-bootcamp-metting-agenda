package com.jonasdsg.meetingsagenda.meetingsagendaback.models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @Deprecated
    public Room() {} //Construtor JPA

    public Room(Long id, String name, LocalDateTime startAt, LocalDateTime endAt) {
        this.id = id;
        this.name = name;
        this.startAt = startAt;
        this.endAt = endAt;
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(id, room.id) 
               && Objects.equals(name, room.name) 
               && Objects.equals(startAt, room.startAt) 
               && Objects.equals(endAt, room.endAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startAt, endAt);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", startAt='" + getStartAt() + "'" +
            ", endAt='" + getEndAt() + "'" +
            "}";
    }

}

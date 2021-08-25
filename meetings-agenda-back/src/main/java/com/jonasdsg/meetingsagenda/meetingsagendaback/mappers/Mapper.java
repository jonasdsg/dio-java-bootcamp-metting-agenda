package com.jonasdsg.meetingsagenda.meetingsagendaback.mappers;

import java.util.List;

public interface Mapper <M,D> {
    public D toDTO(M model);
    public M toModel(D dto);
    public List<D> toListDTO(List<M> models);
    public List<M> toListModel(List<D> dtos);
}

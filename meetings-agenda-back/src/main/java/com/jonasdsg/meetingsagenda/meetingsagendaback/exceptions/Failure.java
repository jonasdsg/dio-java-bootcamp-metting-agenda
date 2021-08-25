package com.jonasdsg.meetingsagenda.meetingsagendaback.exceptions;

public class Failure extends RuntimeException {
    
    public Failure(Exception e){
        super(e);
    }
}

package com.gladiators.pi_spring.Services.Interfaces;

import com.gladiators.pi_spring.Entities.TD;

import java.util.List;

public interface IServiceTd {
    public TD AddTd(TD td);
    List<TD> retrieveAllTD();


}

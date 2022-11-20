package com.example.gymapp.Services;

import com.example.gymapp.Entities.DUMMIE;

public interface UserInterfaceService {

    DUMMIE getDummieById(final String id);
    DUMMIE insertDummie(DUMMIE dummie);
    void deleteDummie(String dummieId);
}

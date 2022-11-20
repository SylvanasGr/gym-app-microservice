package com.example.gymapp.Services.Implementations;

import com.example.gymapp.Entities.DUMMIE;
import com.example.gymapp.Exceptions.GenericException;
import com.example.gymapp.Exceptions.NotFoundException;
import com.example.gymapp.Repositories.DummieRepository;
import com.example.gymapp.Services.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInterfaceServiceImpl implements UserInterfaceService {

    @Autowired
    private DummieRepository dummieRepository;

    @Override
    public DUMMIE getDummieById(String dummieId) {

        return dummieRepository.findById(dummieId).orElseThrow(NotFoundException::new);
    }

    @Override
    public DUMMIE insertDummie(DUMMIE dummie) {
        if (dummie == null) {
            return null;
        }

        if (dummieRepository.existsById(dummie.getDummyId()))
            throw new GenericException(String.format("Dummie with id: %s already exists.", dummie.getDummyId()));

        return dummieRepository.save(dummie);

    }

    @Override
    public void deleteDummie(String dummieId) {
        dummieRepository.findById(dummieId).orElseThrow(NotFoundException::new);
        dummieRepository.deleteById(dummieId);
    }
}

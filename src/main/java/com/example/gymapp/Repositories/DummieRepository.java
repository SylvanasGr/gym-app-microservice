package com.example.gymapp.Repositories;

import com.example.gymapp.Entities.DUMMIE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DummieRepository  extends JpaRepository<DUMMIE,String> {

    Optional<DUMMIE> findByDummyIdAndDescription(String dummyId,String description);

//    @Query(value = "Select * from DUMMIES where DUMMY_ID = :dummyId and DESCRIPTION = :description",nativeQuery = true)
//    Optional<DUMMIE> findByDummyIdAndDescriptionCustomWay(String dummyId,String description);
}

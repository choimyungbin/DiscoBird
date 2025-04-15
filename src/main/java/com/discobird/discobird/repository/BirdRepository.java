package com.discobird.discobird.repository;

import com.discobird.discobird.domain.Bird;

import java.util.List;
import java.util.Optional;

public interface BirdRepository {
    List<Bird> findAll();
    Optional<Bird> findBySpeciesCode(String speciesCode);

}


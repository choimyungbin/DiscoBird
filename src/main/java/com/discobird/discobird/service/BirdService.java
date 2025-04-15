package com.discobird.discobird.service;

import com.discobird.discobird.domain.Bird;
import com.discobird.discobird.repository.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirdService {

    private final BirdRepository repository;

    public BirdService(BirdRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all birds
     * @return a list of all birds
     */
    public List<Bird> getAllBirds() {
        return repository.findAll();
    }

    /**
     * Get one bird using species code
     * @param speciesCode the Species Code of the bird to retrieve
     * @return an Optional containing the bird if found, or empty if not
     */
    public Optional<Bird> getBirdBySpeciesCode(String speciesCode) {
        return repository.findBySpeciesCode(speciesCode);
    }

    /**
     * Get one bird using scientific name
     * @param sciName the Scientific name of the bird to retrieve
     * @return an Optional containing the bird if found, or empty if not
     */
    public Optional<Bird> getBirdBySciName(String sciName) {
        return repository.findAll().stream()
                .filter(b -> b.getSciName().equalsIgnoreCase(sciName))
                .findAny();
    }

    /**
     * Get one bird using common name
     * @param comName the common name of the bird to retrieve
     * @return an Optional containing the bird if found, or empty if not
     */
    public Optional<Bird> getBirdByComName(String comName) {
        return repository.findAll().stream()
                .filter(b -> b.getComName().equalsIgnoreCase(comName))
                .findAny();
    }


}

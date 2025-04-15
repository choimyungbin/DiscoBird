package com.discobird.discobird.controller;

import com.discobird.discobird.domain.Bird;
import com.discobird.discobird.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/birds")
public class BirdController {
    private final BirdService birdService;

    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }

    /**
     * Get all birds
     */
    @GetMapping
    public List<Bird> getAllBirds() {
        return birdService.getAllBirds();
    }

    /**
     * Get birds by speciesCode
     * e.g. /api/birds/species/snoowl1
     */
    @GetMapping("/species/{code}")
    public ResponseEntity<Bird> getBySpeciesCode(@PathVariable("code") String code) {
        return birdService.getBirdBySpeciesCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get birds by scientific name
     * e.g. /api/birds/scientific?sciName=Bubo%20scandiacus
     */
    @GetMapping("/scientific")
    public ResponseEntity<Bird> getBySciName(@RequestParam("sciName") String sciName) {
        return birdService.getBirdBySciName(sciName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get birds by common name (Kor/Eng)
     * e.g. /api/birds/common?comName=흰올빼미
     */
    @GetMapping("/common")
    public ResponseEntity<Bird> getByComName(@RequestParam("comName") String comName) {
        return birdService.getBirdByComName(comName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}


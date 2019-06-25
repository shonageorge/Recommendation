package com.stackroute.recommendation.controller;

import com.stackroute.recommendation.domain.Category;
import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.service.ContainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "v1/api/contains")

public class ContainsController {

    ContainsService containsService;

    @Autowired
    public ContainsController(ContainsService containsService) {
        this.containsService = containsService;
    }

    //To get relationship
    @GetMapping("/relationship")
    public Collection<Space> getRelationship() {
        return containsService.getRelationship();
    }

    @PostMapping("/newRelationship/{spaceName}")
    public Space relationship(@PathVariable String spaceName) {
        Space space1 = containsService.createRelationship(spaceName);
        return space1;
    }

    @PostMapping("/allRelationship")
    public Space relationshipAll() {
        Space space1 = containsService.createRelationshipAll();
        return space1;
    }

    //To delete relationship
    @DeleteMapping("/deleteRelationship")
    public Space relationshipdelete() {
        Space space1 = containsService.deleteRelationship();
        return space1;
    }

}

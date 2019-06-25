package com.stackroute.recommendation.service;


import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.repository.ContainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ContainsServiceImpl implements ContainsService {

    ContainsRepository containsRepository;

    @Autowired
    public ContainsServiceImpl(ContainsRepository containsRepository) {
        this.containsRepository = containsRepository;
    }

    @Override
    public Collection<Space> getRelationship() {
        return containsRepository.getRelationship();
    }

    @Override
    public Space createRelationship(String spaceName) {
        return containsRepository.createRelationship(spaceName);
    }

    @Override
    public Space createRelationshipAll() {
        return containsRepository.createRelationshipAll();
    }

    @Override
    public Space deleteRelationship() {
        return containsRepository.deleteRelationship();
    }
}

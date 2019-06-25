package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Address;
import com.stackroute.recommendation.domain.Space;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface SpaceService {

    public Space findByName(String spaceName);
    public Collection<Space> getAll();
    public Space create(long spaceId, String spaceName, Address address);
    public Space delete(Long spaceId);
    public Space deleteAll();
    public Space update(long spaceId, String spaceName);

}

package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface BookedRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (u:User)-[r:Booked]->(m:Category) RETURN u,r,m")
    public Collection<User> getRelationship();

    //MATCH (User {name:"abc"})-[:Booked]->(c:Category) RETURN c;

    @Query("MATCH (a:User),(b:Category) WHERE a.name = {name} AND b.categoryName = {categoryName} CREATE (a)-[r:Booked]->(b) RETURN r")
    public User createRelationship(String name,String categoryName);

    //MATCH (User {name:"abc"})-[b:Booked]->(c:Category)-[:Located]-(Location)<-[:Located]-(s:Space) RETURN s

    @Query( "MATCH (User)-[r:Booked]->(Category) DELETE r;")
    public User deleteRelationship();

}

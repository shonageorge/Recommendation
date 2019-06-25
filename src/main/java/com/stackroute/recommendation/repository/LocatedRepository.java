package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.Category;
import com.stackroute.recommendation.domain.Space;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface LocatedRepository extends Neo4jRepository<Space,Long> {
    @Query("MATCH (u:Space)-[r:Located]->(m:Location) RETURN u,r,m")
    public Collection<Space> getRelationship();

   // MATCH (Contains)-[:Located]->(l:Location) RETURN l;

    @Query("MATCH (a:Space),(b:Location) WHERE a.spaceName = {spaceName} AND b.locationName = {locationName} CREATE (a)-[r:Located]->(b) RETURN r")
    public Space createRelationship(String spaceName,String locationName);

    @Query("MATCH (a:Category),(b:Location) WHERE a.categoryName = {categoryName} AND b.locationName = {locationName} CREATE (a)-[r:Located]->(b) RETURN r")
    public Category createRelationshipLoc(String categoryName, String locationName);

    //MATCH (Booked)-[:Located]->(l:Location) RETURN l;

    //MATCH (Located)<-[:Located]-(s:Space) RETURN s;

    @Query( "MATCH (Category)-[r:Located]->(Location) DELETE r;")
    public Category deleteRelationshipcat();

    @Query( "MATCH (Space)-[r:Located]->(Location) DELETE r;")
    public Space deleteRelationship();


}

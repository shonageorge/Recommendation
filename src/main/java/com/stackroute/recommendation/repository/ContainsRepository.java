package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.Space;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface ContainsRepository extends Neo4jRepository<Space,Long> {

    @Query("MATCH (u:Space)-[r:Contains]->(m:Category) RETURN u,r,m")
    public Collection<Space> getRelationship();

   // MATCH (Booked)<-[:Contains]-(s:Space) RETURN s;

    @Query("MATCH (a:Space),(b:Category) WHERE a.spaceName = {spaceName} CREATE (a)-[r:Contains]->(b) RETURN r")
    public Space createRelationship(String spaceName);

    @Query( "MATCH (u:Space),(m:Category)  CREATE (u)-[:Contains]->(m);")
    public Space createRelationshipAll();


    //MATCH (p:User),(t:Game) WHERE p.name={userName} and t.id={gameName} CREATE (p)-[q:LikesGame]->(t) RETURN p,q,t

    @Query( "MATCH (Space)-[r:Contains]->(Category) DELETE r;")
    public Space deleteRelationship();


}

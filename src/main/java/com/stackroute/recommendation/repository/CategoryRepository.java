package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.Category;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Collection;

public interface CategoryRepository extends Neo4jRepository<Category,Long> {

    @Query("MATCH (n:Category) WHERE n.categoryName={categoryName} RETURN n")
    public Category getNode(@Param("categoryName") String categoryName);

    @Query("MATCH (n:Category) RETURN n")
    public Collection<Category> getAll();

    @Query("CREATE (u:Category) SET u.categoryId={categoryId},u.categoryName={categoryName},u.price={price}")
    public Category createNode(long categoryId, String categoryName, double price);

    @Query("MATCH (n:Category) WHERE n.categoryId={categoryId} DETACH DELETE n RETURN 'node deleted' ")
    public Category deleteNode(long categoryId);

    @Query("MATCH (n:Category) DETACH DELETE n")
    public Category deleteAllNodes();

    @Query("MATCH (c:Category) WHERE c.categoryId={categoryId} SET c.categoryName={categoryName} c.price={price}")
    public Category updateNode(long categoryId,String categoryName,double price);

}

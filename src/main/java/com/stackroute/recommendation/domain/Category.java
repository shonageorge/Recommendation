package com.stackroute.recommendation.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.math.BigDecimal;
import java.util.List;

@NodeEntity
public class Category {

    @GraphId
    private long categoryId;

    @Property
    private String categoryName;
    private double price;
    private Space space;
    String spaceName;
   // private Address address;

    public Category() {
    }

    @Relationship(type = "Located",direction = Relationship.INCOMING)
    private List<Location> locations;

    public List<Location> getLocations() {
        return locations;
    }

    public Category(long categoryId, String categoryName, double price) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.price = price;
       // this.space = space;
        this.spaceName=space.getSpaceName();
        //this.address = address;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getPrice() {
        return price;
    }

    public Space getSpace() {
        return space;
    }

//    public Address getAddress() {
//        return address;
//    }


    public String getSpaceName() {
        return spaceName;
    }
}

package com.stackroute.recommendation.controller;

import com.stackroute.recommendation.domain.User;
import com.stackroute.recommendation.service.BookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "v1/api/booked")
public class BookedController {

BookedService bookedService;

    @Autowired
    public BookedController(BookedService bookedService) {
        this.bookedService = bookedService;
    }

    //To get relationship
    @GetMapping("/relationship")
    public Collection<User> getRelationship() {
        return bookedService.getRelationship();
    }

    @PostMapping("/newRelationship/{name}/{categoryName}")
    public User relationship(@PathVariable String name, @PathVariable String categoryName) {
        User user1 = bookedService.createRelationship(name, categoryName);
        return user1;
    }

    //To delete relationship
    @DeleteMapping("/deleteRelationship")
    public User relationshipdelete() {
        User user1 = bookedService.deleteRelationship();
        return user1;
    }

}

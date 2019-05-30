package com.stackroute.springJdbc.controller;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringJdbcController {
    @Autowired
    private SpringJdbcRepository springJdbcRepository;

    public ResponseEntity<String> executeShow() {
        Movie entity = springJdbcRepository.get("1");
        return new ResponseEntity("Movie: " + entity.getMovieId()
                + ", " + entity.getMovieName()+","+entity.getReleaseYear()+","+entity.getRating(), HttpStatus.OK);
    }

    public ResponseEntity<String> insert() {
        Movie entity = new Movie("DDLJ", 3,1993,5);
        springJdbcRepository.add(entity);
        return new ResponseEntity("Student Add: " + entity.getMovieName()
                + ", " + entity.getMovieId()+","+entity.getReleaseYear()+","+entity.getRating(), HttpStatus.OK);
    }

    public ResponseEntity<String> read() {
        Movie entity = springJdbcRepository.get("1");
        return new ResponseEntity("Student Get: " + entity.getMovieName()
                + ", " + entity.getMovieId()+","+entity.getReleaseYear()+","+entity.getRating(), HttpStatus.OK);
    }

    public ResponseEntity<String> update() {
        Movie entity = new Movie("darr", 2,1991,4);
        springJdbcRepository.update(entity);
        return new ResponseEntity("Movie Update: " + entity.getMovieName()
                + ", " +entity.getMovieId() +","+entity.getReleaseYear()+","+entity.getRating(), HttpStatus.OK);
    }

    public ResponseEntity<String> delete() {
        Movie entity = new Movie("kasoor", 1,2000,4);
        springJdbcRepository.delete(entity);
        return new ResponseEntity("Movie Delete: " +entity.getMovieName()
                + ", " +  entity.getMovieId()+","+entity.getReleaseYear()+","+entity.getRating(), HttpStatus.OK);
    }
    public ResponseEntity<?> getAll() {
        List<Movie> studentList =springJdbcRepository.getAll();
        return new ResponseEntity<List<Movie>>(studentList,HttpStatus.OK);
    }
}

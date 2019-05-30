package com.stackroute.springJdbc.repository;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.mapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SpringJdbcRepository {
    private JdbcTemplate jdbcTemplate;

    public SpringJdbcRepository() {
    }

    //    @Autowired
//    public void SpringJdbcRepository(final DataSource dataSource) {
//        this.jdbcTemplate.setDataSource(dataSource);
//    }
    @Autowired
    public void  setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAll() {
        return jdbcTemplate.query("SELECT * FROM movie", new MovieRowMapper());
    }

//    public int add(final String  id, final String firstName) {
//        return jdbcTemplate.update("INSERT INTO STUDENT VALUES (?, ?)", id, firstName);
//    }

    public int add(Movie movie) {
        return jdbcTemplate.update("INSERT INTO movie VALUES (?,?,?,?)", movie.getMovieName(), movie.getMovieId(),movie.getReleaseYear(),movie.getRating());
    }

    public Movie get(final String id) {
        final String query = "SELECT * FROM movie WHERE movieId = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { id }, new MovieRowMapper());
    }

    public int update(Movie entity) {
        return jdbcTemplate.update("UPDATE movie SET movieName=? WHERE movieId=?", entity.getMovieName(), entity.getMovieId());
    }


    public int delete(Movie entity) {
        return jdbcTemplate.update("DELETE FROM movie WHERE movieId=?", entity.getMovieId());
    }


}

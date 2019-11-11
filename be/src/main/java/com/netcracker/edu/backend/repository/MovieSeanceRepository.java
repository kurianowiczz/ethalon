package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.MovieSeance;
import com.netcracker.edu.backend.entity.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSeanceRepository extends CrudRepository<MovieSeance, Long> {
    MovieSeance findByDateTime(String dateTime);
//    MovieSeance findByMovieId(Long movieId);
    @Query(value = "select * from movieseances where movie_id = :movieId", nativeQuery = true)
    List<MovieSeance> getSeanceByMovieId(@Param("movieId") long movieId);
}

package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);
    User findByUsername(String userName);

    //TODO
//    @Query("select u.tickets from User u where u.idUser = :idUser")
//    List<Ticket> getTicketByUserId(@Param("id") Long id);

//    @Query("select u.tickets from User u where u.login = :login")
//    List<Ticket> getTicketByUsername(@Param("userName") String userName);

}

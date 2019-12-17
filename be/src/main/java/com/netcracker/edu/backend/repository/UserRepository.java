package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);
    User findByUsername(String userName);
    //User getUserByUserNameAndPassword(String userName, String password);

    //TODO
//    @Query("select u.tickets from User u where u.idUser = :idUser")
//    List<Ticket> getTicketByUserId(@Param("id") Long id);

//    @Query("select u.tickets from User u where u.login = :login")
//    List<Ticket> getTicketByUsername(@Param("userName") String userName);

    //@Query("select users.id, users.role, users.userName, users.cash from users where id = :id")
    //User getUserById(@Param("id") Long id);


}

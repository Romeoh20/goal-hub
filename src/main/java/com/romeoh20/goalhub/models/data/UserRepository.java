package com.romeoh20.goalhub.models.data;

import com.romeoh20.goalhub.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}

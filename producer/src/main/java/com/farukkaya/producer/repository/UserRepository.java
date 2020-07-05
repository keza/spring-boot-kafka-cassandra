package com.farukkaya.producer.repository;

import com.farukkaya.producer.model.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {
}

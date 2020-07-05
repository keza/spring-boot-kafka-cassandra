package com.farukkaya.producer.repository;

import com.farukkaya.producer.model.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID> {
}

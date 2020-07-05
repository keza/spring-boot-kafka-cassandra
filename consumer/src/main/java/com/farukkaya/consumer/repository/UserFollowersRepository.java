package com.farukkaya.consumer.repository;

import com.farukkaya.consumer.model.UserFollowers;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserFollowersRepository extends CassandraRepository<UserFollowers, UUID> {
}

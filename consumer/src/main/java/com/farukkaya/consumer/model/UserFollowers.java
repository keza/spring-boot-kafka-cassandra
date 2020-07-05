package com.farukkaya.consumer.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table
public class UserFollowers {

    @PrimaryKey
    private UUID id;

    private UUID userId;

    private List<UUID> followerList;
}

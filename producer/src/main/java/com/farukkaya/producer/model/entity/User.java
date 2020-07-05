package com.farukkaya.producer.model.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Data
@Table
public class User {

    @PrimaryKey
    private UUID id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private List<UUID> followerList;

    private Long cratedAt;
}

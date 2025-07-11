package com.squad21.pitang.User;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class User implements Serializable{
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @Column(unique = true, length = 11)
    private String cpf;
    private String address;
    private String email;
    private String password;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}
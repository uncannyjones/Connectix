package com.connectix.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Table(name = "users")

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    @Id
    private String userId;
    
    @Column(name = "user_name", nullable = false)
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    private String password;
    @Column(length = 1000)
    private String about;
    
    @Column(length = 1000)
    private String profPic;
    private String phoneNumber;
    
    @Column(columnDefinition = "TEXT")
    private String gender;
    @Builder.Default
    private boolean enabled = false;
    @Builder.Default
    private boolean emailVerified = false;
    @Builder.Default
    private boolean phoneVerified = false;
    @Builder.Default
    private Providers provider = Providers.SELF;
    private String providerUserId;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();

    

    
}

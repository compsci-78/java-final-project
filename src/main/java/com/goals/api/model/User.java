package com.goals.api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dob;
    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}

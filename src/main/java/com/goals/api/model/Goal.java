package com.goals.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne ()
    @JoinColumn(name="user_id",referencedColumnName = "id")
    @JsonIgnoreProperties({"address","goals"})
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "starts_at")
    private Date startsAt;
    @Column(name = "ends_at")
    private Date endsAt;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "goal")
    //@JsonIgnoreProperties({"goal"})
    private Set<GoalWorkout> goalWorkouts;
}

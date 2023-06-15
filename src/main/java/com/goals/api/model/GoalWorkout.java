package com.goals.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="goals_workouts")
public class GoalWorkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne()
    @JoinColumn(name="goal_id", referencedColumnName = "id")
    //@JsonIgnoreProperties("goalWorkouts")
    private Goal goal;

    @ManyToOne()
    @JoinColumn(name="workout_id", referencedColumnName = "id")
    //@JsonIgnoreProperties("goalWorkouts")
    private Workout workout;
}

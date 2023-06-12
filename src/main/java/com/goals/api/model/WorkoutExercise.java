package com.goals.api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="workouts_exercises")
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sets;
    private int reps;
    @Column(name = "rest_mins")
    private int restMins;
    private int duration;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ManyToOne ()
    @JoinColumn(name="workout_id", referencedColumnName = "id")
    private Workout workout;
    @ManyToOne ()
    @JoinColumn(name="exercise_id", referencedColumnName = "id")
    private Exercise exercise;
}

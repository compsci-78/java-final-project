package com.goals.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name="exercises")
public class Exercise {
    private int id;
    private String name;
    private String description;
    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToMany (mappedBy = "exercise")
    private Set<WorkoutExercise> workoutExercise;
}

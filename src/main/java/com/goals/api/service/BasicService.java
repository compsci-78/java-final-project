package com.goals.api.service;

import com.goals.api.model.Goal;

import java.util.List;

public interface BasicService<T,K> {
    List<T> getAll();
    T get(K id);
    T create(T entity);
    T update(K id, T entity);
    T delete(K id);
}

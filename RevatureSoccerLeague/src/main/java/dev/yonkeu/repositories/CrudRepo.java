package dev.yonkeu.repositories;

import dev.yonkeu.models.Player;

import java.util.List;

public interface CrudRepo<T> {

    // Create
    T add(T t);

    // Read
    T getById(Integer id);
    T getByPhoneNumber(Integer phoneNumber);

    List<T> getAll();

    // Update
    Player update(T t);

    // Delete
    void delete(Integer id);
}

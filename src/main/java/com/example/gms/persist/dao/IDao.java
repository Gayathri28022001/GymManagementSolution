package com.example.gms.persist.dao;

import java.util.List;

public interface IDao<T> {
	T get(long id);

	List<T> getAll();

	void save(T object);

	void update(T object);

	void delete(long id);
}
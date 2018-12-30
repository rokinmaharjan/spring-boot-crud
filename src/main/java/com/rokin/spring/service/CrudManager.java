package com.rokin.spring.service;

import java.util.List;

public interface CrudManager<T, Pk> {
	public T addNew(T t);

	public List<T> getAll();

	public T getById(Pk id);

	public T update(T t);

	public void delete(T t);

	public void deleteById(Pk id);
}

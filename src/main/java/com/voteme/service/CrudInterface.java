package com.voteme.service;

import java.util.List;

public interface CrudInterface<E> {

	void create(E entity);
	
	void update(E entity);
	
	void delete(long id);
	
	E get(long id);
	
	void delete(E entity);
	
	List<E> getAll();
}

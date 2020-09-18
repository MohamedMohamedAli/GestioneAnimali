package it.gestioneCavalli.dao;

import java.util.List;

public interface IBaseDAO<T> {

	public List<T> list();
	
	public T get(Long id);
	
	public void update(T input);
	
	public void insert(T input);
	
	public void delete(Long id);

}

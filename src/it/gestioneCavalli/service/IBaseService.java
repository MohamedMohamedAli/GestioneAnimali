package it.gestioneCavalli.service;

import java.util.List;

public interface IBaseService<T> {

	public List<T> listAll();

	public T caricaConId(Long id);

	public void aggiorna(T input);

	public void inserisci(T input);

	public void elimina(Long id);

}

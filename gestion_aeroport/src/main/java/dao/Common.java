package dao;

import java.util.List;

public interface Common<T> {
	List<T> selectAll();
	void add(T obj);
	void delete(int id);
	void update(T obj);
	T getById(int id);
	int getIDMax();

}

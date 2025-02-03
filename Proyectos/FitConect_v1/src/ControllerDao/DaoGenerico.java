package ControllerDao;

import java.util.ArrayList;

import Model.Usuario;

public interface DaoGenerico <T>{
	
	
	public int  add(T a);
	public void  update(T u);
	public void  delete(int id);
	public T read(int id);
	public ArrayList<T> readAll();
	
	
}

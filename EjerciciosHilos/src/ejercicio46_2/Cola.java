package ejercicio46_2;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cola {
	
	private String nombre;
	private ArrayList<Cliente> clientes;
	private int totalClientes;
	private boolean disponible=false;
	
	public Cola() {}
	
	public Cola(String nombre) {
		this.nombre=nombre;
	}
	
	public Cola(String nombre, ArrayList<Cliente> clientes) {
		this.nombre=nombre;
		this.clientes=clientes;
		this.totalClientes=clientes.size();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getTotalClientes() {
		return totalClientes;
	}

	public void setTotalClientes(int totalClientes) {
		this.totalClientes = totalClientes;
	}
	
	  public synchronized void put() {
    	  while (disponible){
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  
    	  disponible = true;
    	  System.out.println("Trabajando con cliente "+clientes.get(0).getName()+"....");
    	  clientes.get(0).start();
    	  try {
    	  clientes.get(0).join();
    	  }catch(InterruptedException e) {
    	  }
    		notifyAll();
    	}
	
	public synchronized void get() {
  	  while (!disponible) {
  	    try {
  	          wait();
  	    } catch (InterruptedException e) { }
  	  }   	  
  	  disponible = false;
  	System.out.println(clientes.get(0).getName()+" ha terminado.");
  	 clientes.remove(0);
  		notifyAll();

  	}

}

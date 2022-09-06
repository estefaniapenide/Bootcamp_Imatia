package ejercicio46;

import java.util.concurrent.ThreadLocalRandom;

public class Compra {
	
	private String nombre;
	private int numProductos;
	private boolean disponible=false;
	private int total;
	private int i;
	
	public Compra() {}
	
	public Compra(String nombre,int numProductos) {
		this.nombre=nombre;
		this.numProductos=numProductos;
		this.total=numProductos;
	}
	

    public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(int numProductos) {
		this.numProductos = numProductos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public synchronized void get() {
    	  while (!disponible) {
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }   	  
    	  disponible = false; 
    	  this.i =total-numProductos;
    	  int num = ThreadLocalRandom.current().nextInt(1000, 3000);
			try {
				Thread.sleep(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	  System.out.println("\tCOMPRA: "+this.nombre+" => Prducto número "+this.i+" pasado.\n");
    		notifyAll();

    	}


    public synchronized void put(int valor) {
    	  while (disponible){
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  this.numProductos-=valor;
    	  disponible = true;
    	  int a =this.i+1;
    	  System.out.println("\tCOMPRA: "+this.nombre+" => Prducto número "+a+" esperando.\n");
    		notifyAll();
    	}

}

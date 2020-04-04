package repaso2ev;

public class Automovil {
	
	private String modelo;
	private double capacidad;
	private double cantidad;
    private double consumo;
    private double recorrido;
    private double consumido;
    
    //set y get
    public double getCantidad()
    {
    	return cantidad;
    }
    
    
    //Constructores
    public Automovil(String modelo, double capacidad, double cantidad, double consumo)
    	    {
    	
    			this.modelo = modelo;
    			this.capacidad = capacidad;
    			this.cantidad = cantidad;
    			this.consumo = consumo;
    			this.recorrido= 0;
    			this.consumido= 0;
    			
    	    }
	
    public Automovil(String modelo, double capacidad, double consumo)
    {

		this.modelo = modelo;
		this.capacidad = capacidad;
		this.cantidad = 0;
		this.consumo = consumo;
		this.recorrido= 0;
		this.consumido= 0;
		
    }
    
	    
    
    //metodos Llenar deposito
    
    public void llenarDeposito()
    {
    	cantidad=capacidad;
    }

    public double llenarDeposito(double litros)
    {
    	if ((cantidad+litros) <= capacidad)
    	{
    		cantidad=cantidad+litros;
    		return 0;
    	}else
    	{
    		litros = cantidad+litros-capacidad;
    		cantidad=capacidad;
    		return litros;
    	}
    }
    
    
    
    
    //metodo desplazar
    public double desplazar(double distancia)
    {
        if (haycombustible(distancia)) 
        {
        	cantidad=cantidad-combustibleNecesario(distancia);
        	recorrido=recorrido+distancia;
        	consumido=consumido+combustibleNecesario(distancia);
        	return cantidad;
		}else 
		{
			//devuelve error
			return -1;
		}
        
    }
    
    
    //metodos auxiliares
    
    //combustible necesario para una distancia
    public double combustibleNecesario(double distancia)
    {
        return distancia*consumo; 

    }
    
    //¿Hay combustible para una distancia?
    public boolean haycombustible(double distancia)
    {
        if ((distancia*consumo)<=cantidad)
        {
        	return true; 
        }else
        {
        	return false; 
        }
        		

    }
    
    //Reescribir toString
    @Override
	public String toString() {
		return modelo + " " + cantidad + " " + recorrido + " " + consumido;
	}

    
}



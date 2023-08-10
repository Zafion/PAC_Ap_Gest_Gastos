
/**
 * \@author José Luis Montañana Llopis*/

public abstract class Dinero {	
	
	// PRIMERO GENERAMOS ATRIBUTOS (VARIABLES)
	protected double dinero;
    protected String description;
    
    //METODOS, GETERS, SETERS:
    
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}      
   
}
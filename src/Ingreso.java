
/**
 * \@author José Luis Montañana Llopis*/

public class Ingreso extends Dinero{	//HEREDA DE DINERO
	
	//CONSTRUCTOR:
	public Ingreso(double ingreso, String description){
		this.dinero=ingreso;
	    this.description=description;
	}
		
	//FUNCION toString 	
	@Override
	public String toString(){
		return "Concepto del ingreso: " + this.description + "\nValor: " + this.dinero + "€";
	}

}

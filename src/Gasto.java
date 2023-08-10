
/**
 * \@author José Luis Montañana Llopis*/

public class Gasto extends Dinero{	//HEREDA DE DINERO
	
	//CONSTRUCTOR:
	public Gasto(double gasto, String description){
        this.dinero=gasto;
        this.description=description;
    }
	
	
	//FUNCION toString 
	@Override
    public String toString(){	
        return "Concepto del gasto: " + this.description + "\nValor: " + this.dinero + "€";
	}
}

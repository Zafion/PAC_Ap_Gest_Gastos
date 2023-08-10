/**
 * \@author José Luis Montañana Llopis*/


public class GastoException extends Exception { //HEREDA DE LA CLASE Exception    
    
    public GastoException(){
        super("Saldo insuficiente.");	//NUEVO MENSAJE DE EXCEPTION
    }
}
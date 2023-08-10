/**
 * \@author José Luis Montañana Llopis*/

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	
	// PRIMERO GENERAMOS ATRIBUTOS (VARIABLES)  
	private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;
    
    //CONSTRUCTOR:	
    //Inicialmente (en el constructor) se recibirá el usuario que es dueño de la cuenta y el saldo inicial será de 0€.
    public Cuenta(Usuario usuario){
        this.usuario=usuario;	//usuario que es dueño de la cuenta
        this.saldo=0;			//el saldo inicial será de 0€
        this.gastos=new ArrayList<>();
        this.ingresos=new ArrayList<>();
    }
	
	/* INSTRUCCIONES PARA NUEVOS INGRESOS:
	 * //Al añadir un nuevo ingreso se sumará al saldo de la cuenta teniendo en esta variable nuestro dinero real, 
	 * la función devolverá el saldo de la cuenta.
	 */	
	public double addIngresos(String description, double cantidad) {			
		ingresos.add(new Ingreso(cantidad, description));	//NUEVO OBJETO Ingreso PARA AÑADIR A LA LISTA ingresos		
		this.saldo += cantidad;		//SUMAMOS CANTIDAD A saldo		
		return this.saldo;	//RETURN CON LA CANTIDAD ACTUALIZADA.
	}
	
	/*INSTRUCCIONES PARA NUEVOS GASTOS:
	 * Al añadir un nuevo gasto se debe comprobar si se dispone de saldo suficiente, 
	 * en caso contrario se deberá lanzar una nueva excepción del tipo GastoException(), 
	 * pero el programa no debe finalizar. 
	 * Si se dispone de saldo suficiente se restará el importe del gasto y se devolverá el saldo de la cuenta.
	 */
	
	
	
	public double addGastos (String description, double cantidad) throws GastoException {	//COMPROBACION DE SALDO SUFICIENTE Y EXCEPTION CON GastoException		
		if (cantidad > this.saldo)	
			throw new GastoException();		
		gastos.add(new Gasto(cantidad, description));	//NUEVO OBJETO Gasto PARA AÑADIR A LA LISTA gastos		
		this.saldo -= cantidad;	//RESTAMOS CANTIDAD A saldo		
		return this.saldo;	//RETURN CON LA CANTIDAD ACTUALIZADA.
	}
	
    //METODOS, GETERS, SETERS:
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	/*INSTRUCCIONES PARA getGastos Y getIngresos
	 * Las funciones getGastos y getIngresos nos devolverán todos los movimientos de un tipo u otro.
	 */
	
	
	public List<Gasto> getGastos() {	//DEVUELVE EL LISTADO DE GASTOS
		return this.gastos;
	}

	public List<Ingreso> getIngresos() {	//DEVUELVE EL LISTADO DE GASTOS
		return this.ingresos;
	}

	/*INSTRUCCIONES PARA toString
	 * La clase Cuenta tendrá una función toString con la que devolverá el usuario y su saldo.
	 */
	@Override
	public String toString() {
		return "Usuario: " + this.usuario + "\nSaldo disponible en cuenta: " + this.saldo + " Euros";
		
	}

	    
    
    

}

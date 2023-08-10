/**
 * \@author José Luis Montañana Llopis*/

import java.util.regex.Matcher;	//IMPORTADO PARA COMPROBACION DNI
import java.util.regex.Pattern;	//IMPORTADO PARA COMPROBACION DNI

public class Usuario {	
	
	// PRIMERO GENERAMOS ATRIBUTOS (VARIABLES)  
    private String nombre;
    private int edad;
    private String DNI;  
 
  
    
    
    //CONSTRUCTOR COMUN  	
	public Usuario() {
		nombre="";
		edad=0;
		DNI="";
		
	}


	//METODOS, GETERS, SETERS:
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}
	
  	
	/*	INSTRUCCIONES ESPECIALES PARA EL DNI:
	 * 
	 * El DNI deberá tener un formato concreto, está comprobación la realizará en la función setter, 
	 * la cual devolverá un booleano conforme es correcto o no. Si el DNI es correcto quedará asignado. 
	 * Es obligatorio utilizar expresiones regulares para la comprobación del DNI.							IMPORTAR MATCHER Y PATTER	
	 * FORMATO:					
	 * Los primeros 8 caracteres solo podrán ser numéricos.													\\d{8}
	 * El ultimo caracteres deberá ser una letra MAYÚSCULA entre la A y la Z.								[A-Z]{1}$
	 * El guion entre los números y la letra es opcional, admitiendo ambas posibilidades:					-?
	 		* DNI: 78844112L
	 		* DNI: 78844112-L
  	*/
	
	public boolean setDNI(String DNI) { 
		
		Pattern formato = Pattern.compile("\\d{8}-?[A-Z]{1}$");		// OBJETO Pattern CON FORMATO DE DNI
		Matcher esValido = formato.matcher(DNI);					// OBJETO Matcher DE COMPROBACION DEL FORMATO
		if (esValido.matches()) {
			this.DNI = DNI;
			return true;
		} else {
			System.out.println("El DNI introducido no incorrecto.");
			return false;
		}
	}

	//FUNCION toString 	
	@Override
    public String toString(){
        return "Usuario: " + this.nombre + ".\nEdad: " + this.edad + " años.\nDNI: " + this.DNI;
	}

}

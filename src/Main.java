/**
 * \@author José Luis Montañana Llopis*/


import java.text.NumberFormat;	//FUENTE DE USO DE NumberFormat - https://java-spain.com/formateando-numeros-numberformat
import java.util.Locale;	//FUENTE DE USO DE Locale - https://java-spain.com/formateando-numeros-numberformat
import java.util.InputMismatchException;	//FUENTE DE USO DE InputMismatchException - https://www.tutorialesprogramacionya.com/javaya/detalleconcepto.php?punto=81&codigo=161&inicio=80
import java.util.Scanner;


public class Main {
	
	
	//METODOS:
	
	/*INSTRUCCIONES ESPECIALES PARA LOS double:
	 *5. Los Valores Double con coma en lugar de punto para parte decimal; siguiendo la notación europea: 1000,35€ (para mostrarlos por consola) 
	 */
	
	
	public static String aDoubleES (double valor) {	//METODO PARA INSTANCIAR OBJETO NumberFormat Y PASAR A ESTRING CON FORMATO ESPAÑOL EL double.
		Locale espanya = new Locale("es", "ES");
		NumberFormat numberF = NumberFormat.getInstance(espanya);
		return numberF.format(valor);
	}
	
	private static double euroFormat() {	//METODO PARA MANEJAR LA EXCEPSCION TIPO InputMismatchException SI NO USA LA "," COMO SEPARADOR.  
		boolean esCorrecto = false;
		double valor = 0;
		Scanner SC2 = new Scanner(System.in);		
		do {
			System.out.println("Introduzca importe siguiendo la notación europea usando \",\" como separador");
			try {
				valor = SC2.nextDouble();
				esCorrecto = true;
			} catch (InputMismatchException ex) {
				esCorrecto = false;
				SC2.nextLine();
				System.out.println("Formato erróneo, debe usar \",\" como separador para los decimales");
			}
		} while (!esCorrecto);
		SC2.nextLine();	//RECOGEMOS EL RETORNO DE CARRO TRAS INSERTAR NÚMEROS POR TECLADO.
		return valor;
	}
	



	
	
	/*INSTRUCCIONES PARA MAIN:
	 * 
	 * La clase main será la que se ejecute al iniciar el programa y seguirá unos pasos definidos:*/

	
	public static void main(String[] args) {
		
		// PRIMERO GENERAMOS ATRIBUTOS (VARIABLES)  
		
		Scanner SC = new Scanner(System.in);	//OBJETO Scanner PARA RECOGER INFORMACION POR CONSOLA
		
		Usuario usuario = new Usuario();	//NUEVO OBJETO USUARIO CON VALORES POR DEFECTO PARA TRABAJAR SOBRE EL
		
		boolean correctoDNI;	//BOOLEAN PARA COMPROBACION DE DNI
		
		Cuenta cuenta;		//OBJETO CUENTA
		
		int seleccion = -1; 	//INT PARA DEFINIR SELECCION DEL MENU, DADO QUE EL MENU COMPRENDE OPCIONES ENTRE 0 Y 5 LE PONEMOS UN NUMERO INFERIOR -1
		
		String concepto;		//STRING DE CONCEPTO PARA GASTOS E INGRESOS
		
		double importe;	//DOUBLE PARA IMPORTE DE GASTOS E INGRESOS
		
		String salida;	//STRING PARA LA SALIDA POR CONSOLA DE MOSTRAR GASTOS Y MOSTRAR INGRESOS.
		
		
		
		/* 1. Creación del usuario y sus datos, el DNI no se establecerá hasta que se introduzca uno correcto, el orden de los datos será:
		 * 	a. Nombre
		 * 	b. Edad
		 * 	c. DNI 
		 */		
				
		System.out.println("*********** Aplicación de Gestión de Gastos Personales ***********.\n");
		System.out.println("Iniciando proceso para la creación de nuevo usuario.\nIntroduzca nombre de nuevo usuario:");		
		usuario.setNombre(SC.nextLine());		
		System.out.println("Introduzca edad de " + usuario.getNombre() + ":");
		usuario.setEdad(SC.nextInt());
		SC.nextLine();	//RECOGEMOS EL RETORNO DE CARRO TRAS INSERTAR NÚMEROS POR TECLADO.
		
		// BUBLE PARA SOLICITAR DNI VALIDO.
		do {
			System.out.println("Introduzca DNI de " + usuario.getNombre() + ":\nADVERTENCIA: Formatos soportados: \"12345678Z\" o \"12345678-Z\"):");
			correctoDNI = usuario.setDNI(SC.nextLine());
		} while (!correctoDNI);
		System.out.println("Finalizada la creación del nuevo usuario " + usuario.getNombre());
		System.out.println();

		
		/* 2. Creación de la cuenta
		 */
		
		cuenta = new Cuenta(usuario);
		
		/*Visualización del menú con las instrucciones tal y como se muestra en la siguiente figura: (Ver figura en PDF de PAC)
		 */
		
		
		while (seleccion != 0) {	//BUCLE PARA QUE EL MENU VUELVA A APARECER MIENTRAS NO SELECCIONEN LA OPCION "0 Salir" 
			
			System.out.println("Realiza una nueva acción");
			System.out.println("1 Introduce un nuevo gasto");
			System.out.println("2 Introduce un nuevo ingreso");
			System.out.println("3 Mostrar gastos");
			System.out.println("4 Mostrar ingresos");
			System.out.println("5 Mostrar saldo");
			System.out.println("0 Salir ");
			
			seleccion = SC.nextInt();
			SC.nextLine();	//RECOGEMOS EL RETORNO DE CARRO TRAS INSERTAR NÚMEROS POR TECLADO.
			
			/*4. Cada acción realizará una operación donde se deberán de solicitar los datos si los necesitase.
			 * 
			 *5. Los Valores Double con coma en lugar de punto para parte decimal; siguiendo la notación europea: 1000,35€ (para mostrarlos por consola) 
			 *
			 *6. Al finalizar la aplicación se deberá mostrar el mensaje (importante que sea igual al que se indica):
			 *Fin del programa.
			 *Gracias por utilizar la aplicación de M03B en el curso 1s2223.
			 */
			
			switch (seleccion) {	//CONDICIONAL switch PARA LA SELECCION DE OPCION.
				case 1: {
					System.out.println("Introduzca concepto del gasto.");
					concepto = SC.nextLine();					
					importe = euroFormat(); //LLAMAMOS AL METODO QUE SOLICITA LA CANTIDAD Y CONTROLA QUE SIGA EL FORMATO EUROPEO					
					try {	//TRY Y CATCH PARA CONTROLAR LA POSIBLE EXCEPSION
						System.out.println("Saldo actual: " + aDoubleES(cuenta.addGastos(concepto, importe)) + "€");	//MOSTRAMOS POR CONSOLA EL SALDO USANDO EL METODO aDoubleES
						System.out.println();
					} catch(GastoException error) {	//EN CASO DE ERROR, LO MUESTRA POR MENSAJE
						System.out.println(error.getMessage());
					}
					break;			
				
				}
				case 2: {
					System.out.println("Introduzca concepto del ingreso.");	//USAMOS EL MISMO SISTEMA QUE EN CASE 1
					concepto = SC.nextLine();					
					importe = euroFormat();					
					System.out.println("Saldo actual: " + aDoubleES(cuenta.addIngresos(concepto, importe)) + "€");					
					System.out.println();
					break;
				}
				case 3: {					 
					if (cuenta.getGastos().isEmpty()) {		//BUCLE IF QUE COMPRUEBA SI HAY ALGÚN GASTO ANTES DE MOSTRARLOS
						System.out.println("No tenemos registro de ningún gasto.\n");
					} else {						 									
						for (Gasto gasto : cuenta.getGastos()) {	//BUCLE FOR QUE RECORRE E IMPRIME LA LISTA DE GASTOS							
							salida = gasto.toString();	//PASAMOS A VARIABLE salida EL TEXTO DE gasto.toString();
							System.out.println(salida.replace(".", ","));	//SUSTITUIMOS LOS "." POR "," 
						}
						System.out.println();
					}
					break;
				}
				case 4: {					
					if (cuenta.getIngresos().isEmpty()) {	//MISMO SISTEMA QUE EN EL CASE 3
						System.out.println("No tenemos registro de ningún ingreso.\n");
					} else {
						for (Ingreso ingreso : cuenta.getIngresos()) {
							salida = ingreso.toString();	//PASAMOS A VARIABLE salida EL TEXTO DE ingreso.toString();
							System.out.println(salida.replace(".", ","));	//SUSTITUIMOS LOS "." POR "," 
						}
						System.out.println();
					}
					break;
				}
				case 5: {
					System.out.println("El saldo actual de la cuenta es de " + aDoubleES(cuenta.getSaldo()) + "€");		//MOSTRAMOS POR CONSOLA EL SALDO USANDO EL METODO aDoubleES
					break;
				}
				case 0: {					
					System.out.println("Fin del programa.\nGracias por utilizar la aplicación de M03B en el curso 1s2223."); //MOSTRAMOS POR CONSOLA MENSAJE DE CIERRE
					
					SC.close();	//CIERRE DE ESCANER
					break;
				}
			}
		}
	}	
}
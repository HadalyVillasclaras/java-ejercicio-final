import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class claseMain {

	private static int opcionElegida;
	private static Scanner leerTeclado = new Scanner(System.in);
	
	private static Usuario nuevoUsuario = new Usuario();
	
	private static String nombre;
	private static int edad;
	private static String DNI;
	private static boolean DNIvalido = false;
	
	//Ingresos
	private static String descriptionIngreso="";
	private static double cantidadIngreso=0;
	
	//Gastos
	private static String descriptionGasto="";
	private static double cantidadGasto=0;
	
	//Listas
	private static List <Ingreso> listaIngresos= new ArrayList<Ingreso>();
	private static List <Gasto> listaGastos= new ArrayList<Gasto>();
	
		
		
		
	private static Cuenta nuevaCuenta;
	
	
	
	//CREAR USUARIO
	private static boolean establecerUsuario() {
		System.out.println("Introduce tu nombre de usuario: ");
		nombre=leerTeclado.nextLine();	
		
		System.out.println("Introduce tu edad: ");
		edad=leerTeclado.nextInt();
		
		leerTeclado.nextLine();
		
	
		System.out.println("Introduce tu DNI: ");
		DNI=leerTeclado.nextLine();
		
		
		if(nuevoUsuario.setDNI(DNI)==false) {
			DNIvalido=false;
			System.out.println("DNI incorrecto");
		}
		else {
			DNIvalido=true;
		}
		
		nuevoUsuario.setNombre(nombre);
		nuevoUsuario.setEdad(edad);
		
		return true;
	}


	//MENÚ DE OPCIONES
	private static void verMenu () {
		System.out.println("--------------------------------------------");
		System.out.println("1. Introducir un nuevo gasto.");
		System.out.println("2. Introducir un nuevo ingreso.");
		System.out.println("3. Mostrar gastos.");
		System.out.println("4. Mostrar ingresos.");
		System.out.println("5. Mostrar el saldo de la cuenta.");
		System.out.println("0. Salir");
		System.out.println("--------------------------------------------");
		System.out.println("Por favor, elige la opción que desees realizar:");
		
		opcionElegida = leerTeclado.nextInt();
	}	
	
	
	//INTRODUCIR INGRESOS
	private static void introducirIngresos() {
		
		descriptionIngreso="";
		cantidadIngreso=0;
		
		System.out.println("Introduce el concepto del gasto: ");
		descriptionIngreso=leerTeclado.nextLine();
		leerTeclado.nextLine();
		System.out.println("Introduce la cantidad de ingreso: ");
		cantidadIngreso=leerTeclado.nextInt();
		
		leerTeclado.nextLine();
		
		//añadir a cuenta:
		nuevaCuenta.addIngresos(descriptionIngreso, cantidadIngreso);
		
	}
	
	
	//INTRODUCIR GASTOS
	private static void introducirGastos() {
		descriptionGasto="";
		cantidadGasto=0;
		
		System.out.println("Introduce el concepto del gasto: ");
		descriptionGasto=leerTeclado.nextLine();
		
		leerTeclado.nextLine();
		System.out.println("Introduce la cantidad del gasto: ");
		cantidadGasto=leerTeclado.nextInt();
		
		leerTeclado.nextLine();
		
		//añadir a cuenta:
		nuevaCuenta.addGastos(descriptionGasto, cantidadGasto);
		
	}
	
	
	//MOSTRAR LISTA INGRESOS
	private static void mostrarListaIngresos() {
		listaIngresos=nuevaCuenta.getIngreso();	
		
		if(listaIngresos.isEmpty()) {
			System.out.println("No hay ingresos en la cuenta.");
		}
		else {
			for(int i=0;i<listaIngresos.size(); i++) {
				System.out.println(listaIngresos.get(i));
			}
		}
	}
	
	//MOSTRAR LISTA GASTOS
	private static void mostrarListaGastos() {
		listaGastos=nuevaCuenta.getGastos();			
		if(listaGastos.isEmpty()) {
			System.out.println("No hay gastos en la cuenta.");
		}
		else {
			for(int i=0;i<listaGastos.size(); i++){
				System.out.println(listaIngresos.get(i));
			}
		}
		
	}
	
	//MÉTODO MAIN
	public static void main(String[] args) {
	

		if(establecerUsuario()==true) {
			nuevaCuenta = new Cuenta(nuevoUsuario);
			
			do{
				verMenu();
			
			switch(opcionElegida) {
				case 1: 
				introducirGastos();
				break;
				
				case 2:
					introducirIngresos();
					break;
				
				case 3:
					mostrarListaGastos();
					break;
				
				case 4:
					mostrarListaIngresos();
					break;
				
				case 5:
					System.out.println(nuevaCuenta.toString());
					break;
				case 0: 
					System.out.println("Fin del programa.\n"
						+ "Gracias por utilizar la aplicación.");
					break;
			}			

			}while(opcionElegida!=0);
			
		
		}
	}
	
}



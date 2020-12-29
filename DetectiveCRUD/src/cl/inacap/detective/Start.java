package cl.inacap.detective;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays; 
import org.apache.commons.lang3.ArrayUtils;
import cl.inacap.detective.classes.Detective;

public class Start {
	
	private static Scanner sc = new Scanner(System.in);
	private static Detective[] detectives = new Detective[3];
	private static int detectiveActual = 0;
	
	
	private static void ingresarDetective() {
		String nombre,direccion,rut;
		int telefono=0,nivel=0;
		
		//Nombre
		do {
			System.out.println("Ingrese nombre y apellido separado por un espacio:");
			nombre = sc.nextLine().trim().replaceAll("\\s{2,}", " ");
			if(nombre.isEmpty() || nombre.length()> 20) {
				System.out.println("Ingrese nuevamente");
			}
		}while(nombre.isEmpty()|| nombre.length()> 20);
		
		//RUT
		System.out.println("Ingrese RUT sin puntos y con guion:");
		do {
			rut = sc.nextLine().trim().toUpperCase();
			validarRut(rut);
			buscaRUT(rut);
			if(rut.isEmpty()||validarRut(rut)==false||buscaRUT(rut)==true) {
				System.out.println("Ingrese RUT nuevamente");
				
			}
		}while(nombre.isEmpty()||validarRut(rut)==false||buscaRUT(rut)==true);
		
		
		//Direccion
		do {
			System.out.println("Ingrese direccion:");
			direccion = sc.nextLine().trim();
			if(direccion.isEmpty()) {
				System.out.println("Debe ingresar una direccion");
			}
		}while(direccion.isEmpty());
		
		//Telefono
		String telefonoAux;
		do {
			System.out.println("Ingrese numero de telefono (9 digitos)");
			telefonoAux = sc.nextLine().trim();
			if(!(telefonoAux.length() == 9 )) {
				telefonoAux = "";
			}
			try {
				telefono = Integer.parseInt(telefonoAux);
				}
			catch(Exception ex) {
				System.out.println("Ingrese telefono nuevamente");
				telefonoAux = "";
			}
		}while(telefonoAux.isEmpty() || (!(telefonoAux.length() == 9 )));
		
		//Nivel
			String nivelAux;
			do {
				System.out.println("Ingrese nivel: (0)Oficial ; (1)Jefe de departamento");
				nivelAux = sc.nextLine().trim();
				try {
					nivel = Integer.parseInt(nivelAux);
					if((nivel !=0) && (nivel !=1)) {
						System.out.println("El numero debe ser 0 o 1");
						nivelAux = "";
					}
				}catch(Exception ex) {
					System.out.println("El nivel debe ser un numero");
					nivelAux = "";
				}
			}while(nivelAux.isEmpty());
			
		//Ingreso OK
		Detective dongraf  = new Detective();
		dongraf.setNombre(nombre);
		dongraf.setDireccion(direccion);
		dongraf.setRut(rut);
		dongraf.setTelefono(telefono);
		dongraf.setNivel(nivel);
		detectives[detectiveActual] = dongraf;
		++detectiveActual;
		 detectives = Arrays.copyOf(detectives, detectives.length + 1);
		
	}
	private static void buscarDetective() {
		System.out.println("Ingrese Apellido:");
		String filtro = sc.nextLine().trim();
		boolean encontrado = false;
		for(Detective d : detectives) {
			if(d!= null && d.getNombre().toUpperCase().contains(filtro.toUpperCase())) {
				
				String[] partes = d.getNombre().split(" ");
				String apellido = partes[1];

				if(apellido.equals(filtro)) {
					if(d.getNivel()==0) {
						System.out.println(d + "NO es jefe");
					}
					else {
						System.out.println(d + "SI es jefe");
					}
					encontrado = true;
				}	
			}
		}
		if(!encontrado) {
			System.out.println("No existe detective con ese apellido");
		}

	}
	
	private static void mostrarDetective() {
		for(int i=0; i < detectives.length; ++i) {
			if(detectives[i] != null) { 
				if(detectives[i].getNivel()==0) {
					System.out.println(i + " " + detectives[i] + "NO es jefe");
				}
				else {
					System.out.println(i + " " + detectives[i] + "SI es jefe");
				}
			}
		}
	}
	
	private static void dardebajaDetective() {
		System.out.println("Ingrese RUT:");
		String filtro = sc.nextLine().trim();
		boolean encontrado = false;
		for(Detective d : detectives) {
			if(d!= null && d.getRut().toUpperCase().equals(filtro.toUpperCase())) {
				encontrado = true;
				detectives = ArrayUtils.removeElement(detectives, d);
				System.out.println("Registro eliminado");
				
			}
		}
		if(!encontrado) {
			System.out.println("Detective desconocido");
		}
	}
	
	private static boolean menu() {
		boolean continuar = true;
		System.out.println("---------Menu---------");
		System.out.println("1. Ingresar Detective");
		System.out.println("2. Buscar Detective");
		System.out.println("3. Mostrar Detective");
		System.out.println("4. Dar de baja Detective");
		System.out.println("0. Salir");
		String opcion = sc.nextLine().trim();
		switch(opcion) {
		
		case "1": ingresarDetective();
		break;
		case "2": buscarDetective();
		break;
		case "3": mostrarDetective();
		break;
		case "4": dardebajaDetective();
		break;
		case "0": continuar = false;
		break;
		default: System.out.println("Opcion incorrecta");
		break;
		
		}
		return continuar;
	}
	
	public static void main(String[] args) {
		while(menu());

	}

	    public static boolean validarRut ( String rut ) {
			Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
			Matcher matcher = pattern.matcher(rut);
			if ( matcher.matches() == false ) return false;
			String[] stringRut = rut.split("-");
			return stringRut[1].toLowerCase().equals(dv(stringRut[0]));
		}
		
//Validador de RUT
		public static String dv ( String rut ) {
			Integer M=0,S=1,T=Integer.parseInt(rut);
			for (;T!=0;T=(int) Math.floor(T/=10))
				S=(S+T%10*(9-M++%6))%11;
			return ( S > 0 ) ? String.valueOf(S-1) : "k";		
		}
//Buscar RUT
		public static boolean buscaRUT(String rut) {
			boolean busted = false;
			for(Detective d : detectives) {
				if(d!= null && d.getRut().equals(rut)) {
					busted = true;
				}
			}
			return busted;	
		}
}

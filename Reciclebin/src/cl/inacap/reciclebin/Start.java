package cl.inacap.reciclebin;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

import cl.inacap.reciclebinModel.dao.ProductosDAO;
import cl.inacap.reciclebinModel.dao.ReciclajesDAO;
import cl.inacap.reciclebinModel.dao.ProveedoresDAO;
import cl.inacap.reciclebinModel.dto.BotellaPlastica;
import cl.inacap.reciclebinModel.dto.Lata;
import cl.inacap.reciclebinModel.dto.Producto;
import cl.inacap.reciclebinModel.dto.Reciclaje;
import cl.inacap.reciclebinModel.dto.Proveedor;

public class Start {

	private static Scanner sc = new Scanner(System.in);
	private static ProductosDAO producDAO = new ProductosDAO();
	private static ReciclajesDAO reciclajesDAO = new ReciclajesDAO();
	private static ProveedoresDAO proveedorDAO = new ProveedoresDAO();

	
	private static void ingresarProveedor() {
		String nombre,rut,tipoEmpresa;
		List<String> posiblesTipos = Arrays.asList("pequeña","mediana","grande");

		do {
			System.out.println("Ingrese nombre:");
			nombre = sc.nextLine().trim();
		} while (nombre.isEmpty());
		
		System.out.println("Ingrese RUT:");
		do {
			rut = sc.nextLine().trim().toUpperCase();
			validarRut(rut);
			if(rut.isEmpty()||validarRut(rut)==false) {
				System.out.println("Ingrese RUT nuevamente");
				
			}
		}while(rut.isEmpty()||validarRut(rut)==false);

		do {
			System.out.println("Ingrese tipo de empresa: Pequeña,Mediana,Grande");
			tipoEmpresa = sc.nextLine().trim();

			if (!posiblesTipos.contains(tipoEmpresa.toLowerCase())) {
				System.out.println("Tipo de empresa incorrecta");
				tipoEmpresa = "";
			}

		} while (tipoEmpresa.isEmpty());
		
		boolean tieneConvenio;
		System.out.println("Tiene convenio de reciclaje?");
		tieneConvenio = sc.nextLine().trim().equalsIgnoreCase("si");
		
		Proveedor pro = new Proveedor ();
		pro.setNombre(nombre);
		pro.setRut(rut);
		pro.setTipoEmpresa(tipoEmpresa);
		pro.setTieneConvenio(tieneConvenio);

		proveedorDAO.save(pro);
		
	}


	
	private static void ingresarProducto() {

		String nombre,tipo,capacidad,valorMercadoAux,anchoAux,altoAux,pesoAux,espesorAux;
		int valorMercado=0,ancho=0,alto=0,espesor=0;
		double peso=0;
		
		do {
			System.out.println("Ingrese nombre:");
			nombre = sc.nextLine().trim();
		} while (nombre.isEmpty());
		
		do {
			try {
				System.out.println("Ingrese valor del producto");
				valorMercadoAux = sc.nextLine().trim();
				valorMercado = Integer.parseInt(valorMercadoAux);
				if (valorMercado < 1) {
					System.out.println("El valor debe ser mayor a 0");
					valorMercadoAux = "";
				}
			} catch (Exception ex) {
				System.out.println("El valor debe ser un numero");
				valorMercadoAux = "";
			}

		} while (valorMercadoAux.isEmpty());
		
		do {
			try {
				System.out.println("Ingrese alto del producto");
				altoAux = sc.nextLine().trim();
				alto = Integer.parseInt(altoAux);
				if (alto < 6) {
					System.out.println("El valor debe ser mayor a 5");
					altoAux = "";
				}
			} catch (Exception ex) {
				System.out.println("El alto debe ser un numero");
				altoAux = "";
			}

		} while (altoAux.isEmpty());
		do {
			try {
				System.out.println("Ingrese ancho del producto");
				anchoAux = sc.nextLine().trim();
				ancho = Integer.parseInt(anchoAux);
				if (ancho < 6) {
					System.out.println("El ancho debe ser mayor a 5");
					anchoAux = "";
				}
			} catch (Exception ex) {
				System.out.println("El ancho debe ser un numero");
				anchoAux = "";
			}

		} while (anchoAux.isEmpty());
		
		do {
			try {
				System.out.println("Ingrese peso del producto");
				pesoAux = sc.nextLine().trim();
				peso = Double.parseDouble(pesoAux);
				if (peso > 100 || peso < 10) {
					System.out.println("El peso debe estar entre 10 y 100");
					pesoAux = "";
				}
			} catch (Exception ex) {
				System.out.println("El peso debe ser un numero");
				pesoAux = "";
			}

		} while (pesoAux.isEmpty());
		
		Producto p= new Producto();

		
		do {
			System.out.println("Ingrese tipo, botella plastica o lata");
			tipo = sc.nextLine().trim();

		} while (!tipo.equalsIgnoreCase("botella plastica") && !tipo.equalsIgnoreCase("lata"));
		if (tipo.equalsIgnoreCase("botella plastica")) {
			
			
			do {
				try {
					System.out.println("Ingrese espesor de la botella");
					espesorAux = sc.nextLine().trim();
					espesor = Integer.parseInt(espesorAux);
					if (espesor < 1) {
						System.out.println("El espesor debe ser mayor a 0");
						espesorAux = "";
					}
				} catch (Exception ex) {
					System.out.println("El espesor debe ser un numero");
					espesorAux = "";
				}

			} while (espesorAux.isEmpty());
			
		
				
				List<String> posiblesCapacidades = Arrays.asList("350 ml","500 ml","1 litro","2 litros","2.5 litros","3 litros");
				do {
					System.out.println("Ingrese uno de los valores");
					System.out.println("350 ml");
					System.out.println("500 ml");
					System.out.println("1 Litro");
					System.out.println("2 Litros");
					System.out.println("2.5 Litros");
					System.out.println("3 Litros");
					capacidad = sc.nextLine().trim();

					if (!posiblesCapacidades.contains(capacidad.toLowerCase())) {
						System.out.println("Capacidad no disponible");
						capacidad = "";
					}

				} while (capacidad.isEmpty());
				
				BotellaPlastica b = new BotellaPlastica();
				b.setNombre(nombre);
				b.setValorMercado(valorMercado);
				b.setAlto(alto);
				b.setAncho(ancho);
				b.setPeso(peso);
				b.setEspesor(espesor);
				b.setCapacidad(capacidad);
				p=b;
				
			} else {
				String tipoLata,resistenciaAux;
				int resistencia=0;
				do {
					System.out.println("Ingrese tipo de lata: Bebida o Conserva");
					tipoLata = sc.nextLine().trim();

				} while (!tipoLata.equalsIgnoreCase("bebida") && !tipoLata.equalsIgnoreCase("conserva"));
				do {
					try {
						System.out.println("Ingrese resistencia de la lata");
						resistenciaAux = sc.nextLine().trim();
						resistencia = Integer.parseInt(resistenciaAux);
						if (resistencia > 199 || resistencia < 1) {
							System.out.println("La resistencia debe ser mayor que 0 y menor que 200");
							resistenciaAux = "";
						}
					} catch (Exception ex) {
						System.out.println("La resistencia debe ser un numero");
						resistenciaAux = "";
					}

				} while (resistenciaAux.isEmpty());
				Lata l = new Lata ();
				l.setNombre(nombre);
				l.setValorMercado(valorMercado);
				l.setAlto(alto);
				l.setAncho(ancho);
				l.setPeso(peso);
				l.setTipo(tipoLata);
				l.setResistencia(resistencia);
				p=l;						
		}
		producDAO.save(p);

	}

	private static void verProveedores() {
		List<Proveedor> proveedores = proveedorDAO.getAll();
		for (int i = 0; i < proveedores.size(); ++i) {
			Proveedor pro = proveedores.get(i);
			System.out.print("ID " + i + "\n" + pro);
		}
	}

	private static void verLatas() {
		List<Producto> productos = producDAO.getAll();
		System.out.println("Latas Disponibles:");
		for (int i = 0; i < productos.size(); ++i) {
			Producto p = productos.get(i);
			if (p instanceof Lata) {
				Lata l = (Lata) p;
				System.out.println(p);
			} else if (p instanceof BotellaPlastica) {
			}
		}
	}
	private static void verBotellas() {
		List<Producto> productos = producDAO.getAll();
		System.out.println("Botellas Plasticas Disponibles:");
		for (int i = 0; i < productos.size(); ++i) {
			Producto p = productos.get(i);
			if (p instanceof BotellaPlastica) {
				BotellaPlastica b = (BotellaPlastica) p;
				System.out.println(p);
			} else if (p instanceof Lata) {
			}
		}
	}
	private static void verTodosLosProductos() {
		List<Producto> productos = producDAO.getAll();
		for (int i = 0; i < productos.size(); ++i) {
			Producto p = productos.get(i);
			System.out.print(i + " ");
			if (p instanceof BotellaPlastica) {
				BotellaPlastica b = (BotellaPlastica) p;
				System.out.println(p);
			} else if (p instanceof Lata) {
				Lata l = (Lata) p;
				System.out.println(p);
			}
		}
	}
	private static void agregarProductoProveedor() {

		Proveedor pro = new Proveedor();
		try {
				System.out.println("Elija un proveedor");				
				verProveedores();
				
				int indice = Integer.parseInt(sc.nextLine().trim());
				Proveedor pro2 = proveedorDAO.find(indice);

		} catch (Exception ex) {
				System.out.println("Indice de proveedor incorrecto");
		}
		
		String respuesta = "si";
		while (respuesta.equalsIgnoreCase("si")) {
			try {
				System.out.println("Productos disponibles");
				
				verTodosLosProductos();
				int indice = Integer.parseInt(sc.nextLine().trim());
				Producto p = producDAO.find(indice);
				pro.getProductos().add(p);
				System.out.println("Desea continuar?");
				respuesta = sc.nextLine().trim();
			} catch (Exception ex) {
				System.out.println("Indice de producto incorrecto");
				respuesta = "si";
			}
		}
		proveedorDAO.save(pro);

	}
				
	private static void reciclar() {
		String fecha;
		System.out.println("Presione ENTER para registrar fecha y hora del sistema");
		
		fecha = sc.nextLine().trim();
		       SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		       Date now = new Date();
		       fecha = sdfDate.format(now);
		       System.out.println(fecha);
		       
		   	Reciclaje r = new Reciclaje();
			r.setFecha(fecha);

			String respuesta = "si";
			while (respuesta.equalsIgnoreCase("si")) {
				try {
					System.out.println("Productos disponibles");
					
					verTodosLosProductos();
					int indice = Integer.parseInt(sc.nextLine().trim());
					Producto p = producDAO.find(indice);
					r.getProductos().add(p);
					System.out.println("Desea continuar?");
					respuesta = sc.nextLine().trim();
				} catch (Exception ex) {
					System.out.println("Indice de producto incorrecto");
					respuesta = "si";
				}
			}
			System.out.println("Reciclaje Registrado");
			System.out.println("Total:" + r.getValorPagado());
			
			reciclajesDAO.save(r);
	}
	private static void revisarReciclajes() {
		System.out.println("Ingrese Fecha en formato yyyy-MM-dd HH:mm:ss");
		String fecha = sc.nextLine().trim();
		List<Reciclaje> reciclajes = ReciclajesDAO.getAll();
		for (Reciclaje r: reciclajes) {
			if(fecha!= null && r.getFecha().toUpperCase().equals(fecha.toUpperCase())) { 
			System.out.print(r);
			}
		}
	}

	private static boolean menu() {
		boolean continuar = true;
		System.out.println("Que desea hacer?");
		System.out.println("1. Ingresar Proveedor");
		System.out.println("2. Ingresar Producto");
		System.out.println("3. Ver Proveedores");
		System.out.println("4. Ver Latas");
		System.out.println("5. Ver Botellas");
		System.out.println("6. Ver Todos los Productos");
		System.out.println("7. Agregar Producto a Proveedor");
		System.out.println("8. Reciclar");
		System.out.println("9. Revisar Reciclajes");
		System.out.println("0. Salir");
		switch (sc.nextLine()) {
		case "1":
			ingresarProveedor();
			break;
		case "2":
			ingresarProducto();
			break;
		case "3":
			verProveedores();
			break;
		case "4":
			verLatas();
			break;
		case "5":
			verBotellas();
			break;
		case "6":
			verTodosLosProductos();
			break;
		case "7":
			agregarProductoProveedor();
			break;
		case "8":
			reciclar();
			break;
		case "9":
			revisarReciclajes();
			break;
		case "0":
			continuar = false;
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;

		}
		return continuar;
	}

	public static void main(String[] args) {
		
		while (menu())
			;
	}
	public static boolean validarRut(String rut) {

		boolean validacion = false;
		try {
			rut =  rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

			char dv = rut.charAt(rut.length() - 1);

			int m = 0, s = 1;
			for (; rutAux != 0; rutAux /= 10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}

		} catch (java.lang.NumberFormatException e) {
		} catch (Exception e) {
		}
		return validacion;
	}
}

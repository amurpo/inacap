Proceso boletoavion
	Definir nombre,apellido,region,clase Como Caracter;
	Definir codigo,precio Como Entero;
	precio <- 0;
	codigo <- 0;
	Escribir 'Ingrese su nombre';
	Leer nombre;
	Escribir "Ingrese su apellido";
	Leer apellido;
	Repetir
		Escribir 'Ingrese su codigo de region,debe estar entre 1-5';
		Leer codigo;
	Hasta Que codigo>0 Y codigo<6
	Repetir
		Escribir 'Ingrese su clase: T para turista, E para ejecutivo';
		Leer clase;
		clase = minusculas(clase);
	Hasta Que clase='e' O clase='t'
	Segun codigo  Hacer
		1:
			precio <- 100000;
			region <- 'I region';
		2:
			precio <- 80000;
			region <- 'II region';
		3:
			precio <- 60000;
			region <- 'III region';
		4:
			precio <- 50000;
			region <- 'IV region';
		5:
			precio <- 30000;
			region <- 'V region';
	FinSegun
	Si clase = "e" Entonces
		precio = precio+20000;
	FinSi
	Escribir 'Sr(a). ',nombre," ",apellido,' se confirma su viaje a la ',region,' por un valor de $',precio;
FinProceso

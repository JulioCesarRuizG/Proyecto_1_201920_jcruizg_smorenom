package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Se carga el archivo con el trimestre");
			System.out.println("2. Consultar el tiempo promedio de viaje y desviación estándar de los viajes entre unas zonas - mes");
			System.out.println("3. Consultar los N viajes con mayor tiempo promedio - mes");
			System.out.println("4. Comparar los tiempo promedios de los viajes para una zona dada contra cada zona X en un rango - mes");
			System.out.println("5. Consultar el tiempo promedio de viaje y desviación estándar de los viajes entre unas zonas - día");
			System.out.println("6. Consultar los N viajes con mayor tiempo promedio - día");
			System.out.println("7. Comparar los tiempo promedios de los viajes para una zona dada contra cada zona X en un rango - día");
			System.out.println("8. Consultar el tiempo promedio de viaje y desviación estándar de los viajes entre unas zonas y una franja horaria - hora");
			System.out.println("9. Consultar la información de N viajes con mayor tiempo promedio para una hora dada");
			System.out.println("10. Generar una gráfica ASCII que muestre el tiempo promedio de los viajes entre una zona origen y destino. Cada hora de es representado con un *");
			System.out.println("11. Exit");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(MVCModelo modelo)
		{
			// TODO implementar
		}
}

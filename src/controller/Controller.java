package controller;

import java.util.Scanner;

import model.data_structures.Node;
import model.data_structures.Queue;
import model.data_structures.Viaje;
import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 * @throws Exception 
	 */
	public Controller () throws Exception
	{
		view = new MVCView();
		
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					System.out.println("--------- \nDar trimestre a utilizar para la carga: ");
				    int trimestre = lector.nextInt();
				try {
					modelo= new MVCModelo(trimestre);
				} catch (Exception e) {
					System.out.println("No se pudo realizar correctamente la carga");
				}
					
					break;
				case 2: 
					System.out.println("--------- \n Dar zona de origen para la consulta del tiempo promedio y desviación estandar de viajes en base al mes "); 
					 int zonaOM = lector.nextInt();
					 System.out.println("--------- \n Dar zona de destino"); 
					 int zonaDM = lector.nextInt();
					 System.out.println("--------- \n Dar mes a consultar");
					 int mesconsulta=lector.nextInt();
				try {
					Queue<Node<String>> consultaM=modelo.consultarTiempoPromedioYDesviacionMes(zonaOM, zonaDM, mesconsulta);
					while(!consultaM.isEmpty()){
						System.out.println(consultaM.deQueue());
					}
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
					break;	
				case 3: 
					System.out.println("--------- \n Dar numero N para la consulta de la información de los N viajes con mayor tiempo promedio para un mes dado"); 
					 int NM= lector.nextInt();
					 System.out.println("--------- \n Dar mes a consultar");
					 int mesnumero=lector.nextInt();
				try {
					Queue<Node<String>> consultaMN=modelo.MayorTiempoPromedioNViajesMes(NM, mesnumero);
					while(!consultaMN.isEmpty()){
						System.out.println(consultaMN.deQueue());
					}
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
					
					break;	
				case 4: 
					System.out.println("--------- \n Dar zona menor del rango para comparar los tiempos promedios de los viajes para una zona dada contra cada zona X en un rango de zonas dado en ambos sentidos para un mes dado"); 
					 int zonaMenorM= lector.nextInt();
					 System.out.println("--------- \n Dar zona mayor");
					 int zonaMayorM=lector.nextInt();
					 System.out.println("--------- \n Dar zona a comparar");
					 int zonaXM=lector.nextInt();
					 System.out.println("--------- \n Dar dia dado");
					 int mesZonas=lector.nextInt();
				try {
					Queue<Node<String>> consultaMZ=modelo.compararTiempoPromedioPorZonasMes(zonaMenorM, zonaMayorM, zonaXM, mesZonas);
					while(!consultaMZ.isEmpty()){
						System.out.println(consultaMZ.deQueue());
					}
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
					
					
					break;	
				case 5: 
					System.out.println("--------- \n Dar zona de origen para la consulta del tiempo promedio y desviación estandar de viajes en base al dia "); 
					 int zonaOD = lector.nextInt();
					 System.out.println("--------- \n Dar zona de destino"); 
					 int zonaDD = lector.nextInt();
					 System.out.println("--------- \n Dar mes a consultar");
					 int diaconsulta=lector.nextInt();
				try {
					Queue<Node<String>> consultaD=modelo.consultarTiempoPromedioYDesviacionDia(zonaOD, zonaDD, diaconsulta);
					while(!consultaD.isEmpty()){
						System.out.println(consultaD.deQueue());
					}
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
					break;	
				case 6: 
					System.out.println("--------- \n Dar numero N para la consulta de la información de los N viajes con mayor tiempo promedio para un dia dado"); 
					 int ND= lector.nextInt();
					 System.out.println("--------- \n Dar mes a consultar");
					 int dianumero=lector.nextInt();
				try {
					Queue<Node<String>> consultaDN=modelo.MayorTiempoPromedioNViajesDia(ND, dianumero);
					while(!consultaDN.isEmpty()){
						System.out.println(consultaDN.deQueue());
					}
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				case 7: 
					System.out.println("--------- \n Dar zona menor del rango para comparar los tiempos promedios de los viajes para una zona dada contra cada zona X en un rango de zonas dado en ambos sentidos para un día dado"); 
					 int zonaMenorD= lector.nextInt();
					 System.out.println("--------- \n Dar zona mayor");
					 int zonaMayorD=lector.nextInt();
					 System.out.println("--------- \n Dar zona a comparar");
					 int zonaXD=lector.nextInt();
					 System.out.println("--------- \n Dar dia dado");
					 int diaZonas=lector.nextInt();
				try {
					Queue<Node<String>> consultaDZ=modelo.compararTiemposZonaDadaDia(zonaMenorD, zonaMayorD, zonaXD, diaZonas);
					while(!consultaDZ.isEmpty()){
						System.out.println(consultaDZ.deQueue());
					}
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				case 8: 
					System.out.println("--------- \n Dar zona de origen para la consulta de los viajes entre una zona de origen y una zona destino en una franja horaria dada."); 
					 int zonaOH= lector.nextInt();
					 System.out.println("--------- \n Dar zona de destino");
					 int zonaDH=lector.nextInt();
					 System.out.println("--------- \n Dar hora inicial");
					 int horaI=lector.nextInt();
					 System.out.println("--------- \n Dar hora final");
					 int horaF=lector.nextInt();
				try {
					Queue<Node<String>> consultaHF=modelo.compararViajesFranjaHoraria(zonaOH, zonaDH, horaI, horaF);
					while(!consultaHF.isEmpty()){
						System.out.println(consultaHF.deQueue());
					}
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				case 9: 
					System.out.println("--------- \n Dar número N para la consulta de la información de los N viajes con mayor tiempo promedio para una hora dada"); 
					 int NH= lector.nextInt();
					 System.out.println("--------- \n Dar hora dada");
					 int horaN=lector.nextInt();
					
				try {
					Queue<Node<String>> consultaHN=modelo.MayorTiempoPromedioNViajesHora(NH, horaN);
					while(!consultaHN.isEmpty()){
						System.out.println(consultaHN.deQueue());
					}
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				case 10: 
					System.out.println("--------- \n Dar zona de origen para generar una gráfica ASCII que muestre el tiempo promedio de los viajes entre una zona origen y una zona destino para cada hora del día. "); 
					 int zonaOASCII= lector.nextInt();
					 System.out.println("--------- \n Dar zona de destino");
					 int zonaDASCII=lector.nextInt();
					
				try {
					Queue<Node<String>> consultaASCII=modelo.ASCIIZonas(zonaOASCII, zonaDASCII);
					while(!consultaASCII.isEmpty()){
						System.out.println(consultaASCII.deQueue());
					}
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				case 11: 
					System.out.println("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					System.out.println("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}

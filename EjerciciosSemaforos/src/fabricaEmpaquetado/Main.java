package fabricaEmpaquetado;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		int numMaxCiclindro = 3;
		int numMaxCubo = 2;

		int numRobotA = 1;
		int numRobotB = 1;
		int numRobotC = 1;

		Semaphore semaforoRobotA = new Semaphore(numMaxCiclindro);
		Semaphore semaforoRobotB = new Semaphore(numMaxCubo);
		
		Almacen almacen = new Almacen(numMaxCiclindro, numMaxCubo, semaforoRobotA, semaforoRobotB);
		
		ArrayList<RobotA> robotsA = new ArrayList<RobotA>();
		ArrayList<RobotB> robotsB = new ArrayList<RobotB>();
		ArrayList<RobotC> robotsC = new ArrayList<RobotC>();
		
		crearRobotA(robotsA, numRobotA, almacen);
		crearRobotB(robotsB, numRobotB, almacen);
		crearRobotC(robotsC, numRobotC, almacen);
		System.out.println("Robots creados");
		
		iniciarRobotA(robotsA);
		iniciarRobotB(robotsB);
		iniciarRobotC(robotsC);
		System.out.println("Robots iniciados");
		
		programa(robotsA, robotsB, robotsC);
		
		
	}

	private static void programa(ArrayList<RobotA> robotsA, ArrayList<RobotB> robotsB, ArrayList<RobotC> robotsC) {
		Scanner scanner = new Scanner(System.in);
		boolean parado = false;
		
		while(true){
			scanner.nextLine();
			if(parado) iniciarRobots(robotsA, robotsB, robotsC);
			if(!parado) pararRobots(robotsA, robotsB, robotsC);
		}
	}

	private static void iniciarRobots(ArrayList<RobotA> robotsA, ArrayList<RobotB> robotsB, ArrayList<RobotC> robotsC) {
		iniciarRobotA(robotsA);
		iniciarRobotB(robotsB);
		iniciarRobotC(robotsC);
	}

	private static void pararRobots(ArrayList<RobotA> robotsA, ArrayList<RobotB> robotsB, ArrayList<RobotC> robotsC) {
		pararRobotA(robotsA);
		pararRobotB(robotsB);
		pararRobotC(robotsC);
	}

	private static void crearRobotA(ArrayList<RobotA> robotsA, int numRobotA, Almacen almacen) {
		for(int i = 0; i < numRobotA; i++){
			robotsA.add(new RobotA(almacen));
		}
	}

	private static void crearRobotB(ArrayList<RobotB> robotsB, int numRobotB, Almacen almacen) {
		for(int i = 0; i < numRobotB; i++){
			robotsB.add(new RobotB(almacen));
		}
	}

	private static void crearRobotC(ArrayList<RobotC> robotsC, int numRobotC, Almacen almacen) {
		for(int i = 0; i < numRobotC; i++){
			robotsC.add(new RobotC(almacen));
		}
	}

	private static void iniciarRobotA(ArrayList<RobotA> robotsA) {
		for(int i = 0; i < robotsA.size(); i++){
			robotsA.get(i).start();
		}
	}

	private static void iniciarRobotB(ArrayList<RobotB> robotsB) {
		for(int i = 0; i < robotsB.size(); i++){
			robotsB.get(i).start();
		}
	}

	private static void iniciarRobotC(ArrayList<RobotC> robotsC) {
		for(int i = 0; i < robotsC.size(); i++){
			robotsC.get(i).start();
		}
	}
	
	private static void pararRobotA(ArrayList<RobotA> robotsA) {
		for(int i = 0; i < robotsA.size(); i++){
			robotsA.get(i).stop();
		}
	}

	private static void pararRobotB(ArrayList<RobotB> robotsB) {
		for(int i = 0; i < robotsB.size(); i++){
			robotsB.get(i).stop();
		}
	}

	private static void pararRobotC(ArrayList<RobotC> robotsC) {
		for(int i = 0; i < robotsC.size(); i++){
			robotsC.get(i).stop();
		}
	}

}

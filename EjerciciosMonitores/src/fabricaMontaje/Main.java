package fabricaMontaje;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {

		int numRobotA = 1;
		int numRobotB = 1;
		int numRobotC = 1;

		Almacen almacen = new Almacen(numRobotA + numRobotB + numRobotC);

		ArrayList<RobotA> robotsA = new ArrayList<RobotA>();
		ArrayList<RobotB> robotsB = new ArrayList<RobotB>();
		ArrayList<RobotC> robotsC = new ArrayList<RobotC>();

		crearRobotA(robotsA, numRobotA, almacen);
		crearRobotB(robotsB, numRobotB, almacen);
		crearRobotC(robotsC, numRobotC, almacen);
		RobotMontaje robotMontaje = new RobotMontaje(almacen);
		System.out.println("Robots creados");

		iniciarRobots(robotsA, robotsB, robotsC);
		robotMontaje.start();
		System.out.println("Robots iniciados");

		programa(robotsA, robotsB, robotsC, robotMontaje);

	}

	private static void programa(ArrayList<RobotA> robotsA, ArrayList<RobotB> robotsB, ArrayList<RobotC> robotsC,
			RobotMontaje rm) {
		Scanner scanner = new Scanner(System.in);
		boolean parado = false;

		scanner.nextLine();
		pararRobots(robotsA, robotsB, robotsC, rm);

	}

	private static void iniciarRobots(ArrayList<RobotA> robotsA, ArrayList<RobotB> robotsB, ArrayList<RobotC> robotsC) {
		iniciarRobotA(robotsA);
		iniciarRobotB(robotsB);
		iniciarRobotC(robotsC);
	}

	private static void pararRobots(ArrayList<RobotA> robotsA, ArrayList<RobotB> robotsB, ArrayList<RobotC> robotsC,
			RobotMontaje rm) {
		pararRobotA(robotsA);
		pararRobotB(robotsB);
		pararRobotC(robotsC);
		rm.setMovimiento();
		rm.interrupt();
	}

	private static void crearRobotA(ArrayList<RobotA> robotsA, int numRobotA, Almacen almacen) {
		for (int i = 0; i < numRobotA; i++) {
			robotsA.add(new RobotA(almacen));
		}
	}

	private static void crearRobotB(ArrayList<RobotB> robotsB, int numRobotB, Almacen almacen) {
		for (int i = 0; i < numRobotB; i++) {
			robotsB.add(new RobotB(almacen));
		}
	}

	private static void crearRobotC(ArrayList<RobotC> robotsC, int numRobotC, Almacen almacen) {
		for (int i = 0; i < numRobotC; i++) {
			robotsC.add(new RobotC(almacen));
		}
	}

	private static void iniciarRobotA(ArrayList<RobotA> robotsA) {
		for (int i = 0; i < robotsA.size(); i++) {
			robotsA.get(i).start();
		}
	}

	private static void iniciarRobotB(ArrayList<RobotB> robotsB) {
		for (int i = 0; i < robotsB.size(); i++) {
			robotsB.get(i).start();
		}
	}

	private static void iniciarRobotC(ArrayList<RobotC> robotsC) {
		for (int i = 0; i < robotsC.size(); i++) {
			robotsC.get(i).start();
		}
	}

	private static void pararRobotA(ArrayList<RobotA> robotsA) {
		for (int i = 0; i < robotsA.size(); i++) {
			robotsA.get(i).setMovimiento();
			robotsA.get(i).interrupt();
		}
	}

	private static void pararRobotB(ArrayList<RobotB> robotsB) {
		for (int i = 0; i < robotsB.size(); i++) {
			robotsB.get(i).setMovimiento();
			robotsB.get(i).interrupt();
		}
	}

	private static void pararRobotC(ArrayList<RobotC> robotsC) {
		for (int i = 0; i < robotsC.size(); i++) {
			robotsC.get(i).setMovimiento();
			robotsC.get(i).interrupt();
		}
	}

}

package Principal;

import java.util.Scanner;

public class Principal {
	public static void main(String [] arg) {
		String nombreP= "";
		String sexoP= "";
		Integer edadP= 0;
		double pesoP;
		double alturaP;
		System.out.println ("Nombre de la persona:");
        Scanner nombre = new Scanner (System.in);
        nombreP = nombre.nextLine ();
		System.out.println ("Sexo (H/M):");
        Scanner sexo = new Scanner (System.in);
        sexoP = sexo.nextLine();
		System.out.println ("Edad :");
        Scanner edad = new Scanner (System.in);
        edadP = Integer.parseInt(edad.nextLine());
		System.out.println ("Peso :");
        Scanner peso = new Scanner (System.in);
        pesoP = Double.parseDouble(peso.nextLine());
		System.out.println ("Altura :");
        Scanner altura = new Scanner (System.in);
        alturaP = Double.parseDouble(altura.nextLine());
		Persona p = new Persona(nombreP, edadP, sexoP, pesoP, alturaP);
		System.out.println(p.toString());
	}
}

package Principal;

import java.util.Random;
import java.nio.charset.*;


public class Persona {
	protected String nombre = "";
	protected Integer edad = 0;
	protected String NSS;
	protected String sexo = "H";
	protected double peso = 0;
	protected double altura = 0;
	public Persona(String nombre, Integer edad, String sexo, double peso, double altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		NSS = this.generaNSS();
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	public String getNSS() {
		return NSS;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public Integer calcularIMC() {
		Integer result= 0;
		double imc = (this.getPeso()/(this.getAltura()*this.getAltura()));		
		if (this.getSexo().equals("H")) {
			if(imc < 20) {
				result = -1;
			}
			else if(imc > 19 || imc <= 25) {
				result = 0;
			}
			else if(imc > 25) {
				result = 1;
			}
		}		
		if (this.getSexo().equals("M")) {
			if(imc < 19) {
				result = -1;
			}
			else if(imc > 18 || imc <= 24) {
				result = 0;
			}
			else if(imc > 24) {
				result = 1;
			}
		}
		return result;
	}
	public boolean esMayorDeEdad() {
		if (this.getEdad() >= 18) 
			return true;
		else 
			return false;
	}
	public boolean ComprobarSexo() {
		boolean resul = true;
		if (this.getSexo().equals("H") || this.getSexo().equals("M")) 
			resul =  true;
		else 
			resul = false;
		return resul;
	}
	public String toString() {
		String respuesta = "";
		if(this.esMayorDeEdad()) {
			if(this.ComprobarSexo()) {
				respuesta = "La persona " +this.getNombre() +" tiene un indice de masa corporal " + this.calcularIMC()
				+ " siendo mayor de edad y es " + this.getSexo()+" y con numero de seguro social "+this.getNSS();
			}
			else {
					respuesta = "La persona " +this.getNombre() +" tiene un indice de masa corporal " + this.calcularIMC()
						+ " siendo mayor de edad pero el sexo esta mal escrito y con numero de seguro social "+this.getNSS();;
			}
		}
		else {
			if(this.ComprobarSexo()) {
				respuesta = "La persona  " +this.getNombre() +" tiene un indice de masa corporal " + this.calcularIMC()
					+ " sin ser mayor de edad y es " + this.getSexo()+" y con numero de seguro social "+this.getNSS();;
			}
			else {
					respuesta = "La persona " +this.getNombre() +" tiene un indice de masa corporal " + this.calcularIMC()
						+ " sin ser mayor de edad pero el sexo esta mal escrito y con numero de seguro social "+this.getNSS();;
			}
		}
		return respuesta;
	}
	public String generaNSS() {
		int i = 15;
		byte[] bytearray;
		bytearray = new byte[256];
        String mystring;
        StringBuffer thebuffer;
        String theAlphaNumericS;
        new Random().nextBytes(bytearray); 
        mystring = new String(bytearray, Charset.forName("UTF-8"));
        thebuffer = new StringBuffer();
        theAlphaNumericS = mystring.replaceAll("[^A-Z0-9]", "");
        for (int m = 0; m < theAlphaNumericS.length(); m++) {
            if (Character.isLetter(theAlphaNumericS.charAt(m)) && (i > 0) 
                || Character.isDigit(theAlphaNumericS.charAt(m)) && (i > 0)) {
                	thebuffer.append(theAlphaNumericS.charAt(m)); 
                	i--; 
            }
        }
        return thebuffer.toString();
	}
}
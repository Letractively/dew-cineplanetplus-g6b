package pe.edu.upc.dew.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Util {

	public static String getHoraActual() throws Exception {

		Calendar calendario = new GregorianCalendar();
		return getCodigo("00", calendario.get(Calendar.HOUR_OF_DAY)) + ":"
				+ getCodigo("00", calendario.get(Calendar.MINUTE)) + ":"
				+ getCodigo("00", calendario.get(Calendar.SECOND));
	}

	public static String getCodigo(String mascara, int numero) throws Exception {
		String snumero = String.valueOf(numero);
		int lnumero = snumero.length();
		String codigo = mascara + snumero;
		return codigo.substring(lnumero);
	}

	/**
	 * Completa una cadena con un simbolo para una longitud dada
	 *
	 * @param pValor Variable String que contiene el valor a formatear.
	 * @param pLongitud Variable int que determina la longitud q tendrá la cadena.
	 * @param pSimbolo Variable String que contiene el simbolo a completar.
	 * @param pAlineacion Variable String que determina la alineación del Simbolo.
	 * 
	 * @return String nuevo texto con los simbolos
	 */
	public static String completarConSimbolo(String pValor, int pLongitud, String pSimbolo, String pAlineacion) {
		String tempString = pValor;
		for (int i = pValor.length(); i < pLongitud; i++) {
			if (pAlineacion.trim().equalsIgnoreCase("I"))
				tempString = pSimbolo + tempString;
			else
				tempString += pSimbolo;
		}
		return tempString;
	}

	/**
	  *	linea la variable int hacia la derecha colocando CARACTERES a la
	  * izquierda según la longitud que se establezca y el CARACTER dado.
	  *
	  * @param parmint Variable int que sera alineada.
	  * @param parmLon Longitud dentro de la cual sera la alineacion.
	  * @param parmCaracter String de relleno para la alineación.
	  * 
	  * @return String String alineado a la derecha con el CARACTER.
	  */
	public static String caracterIzquierda(int parmint, int parmLon, String parmCaracter) {
		return caracterIzquierda(String.valueOf(parmint), parmLon, parmCaracter);
	}

	/**
	  *
	  * Alinea la variable long hacia la derecha colocando CARACTERES a la
	  * izquierda según la longitud que se establezca y el CARACTER dado.
	  *
	  * @param parmlong Variable long que será alineada.
	  * @param parmLon Longitud dentro de la cual sera la alineacion.
	  * @param parmCaracter String de relleno para la alineacion.
	  * 
	  * @return String String alineado a la derecha con el CARACTER.
	  */
	public static String caracterIzquierda(long parmlong, int parmLon, String parmCaracter) {
		return caracterIzquierda(String.valueOf(parmlong), parmLon, parmCaracter);
	}

	/**
	  * 
	  * Alinea la variable double hacia la derecha colocando CARACTERES a la
	  * izquierda según la longitud que se establezca y el CARACTER dado.
	  *
	  * @param parmdou Variable double que sera alineada.
	  * @param parmLon Longitud dentro de la cual sera la alineacion.
	  * @param parmCaracter String de relleno para la alineacion.
	  * 
	  * @return String String alineado a la derecha con el CARACTER.
	  */
	public static String caracterIzquierda(double parmdou, int parmLon, String parmCaracter) {
		return caracterIzquierda(String.valueOf(parmdou), parmLon, parmCaracter);
	}

	/**
	  * 
	  * Alinea la variable String hacia la derecha colocando CARACTERES a la
	  * izquierda según la longitud que se establezca y el CARACTER dado.
	  *
	  * @param parmString Variable String que será alineada.
	  * @param parmLon Longitud dentro de la cual sera la alineacion.
	  * @param parmCaracter String de relleno para la alineacion.
	  * 
	  * @return String String alineado a la derecha con el CARACTER.
	  */
	public static String caracterIzquierda(String parmString, int parmLon, String parmCaracter) {

		String tempString = parmString;

		if (tempString.length() > parmLon)
			tempString = tempString.substring(tempString.length() - parmLon, tempString.length());
		else {
			while (tempString.length() < parmLon)
				tempString = parmCaracter + tempString;
		}

		return tempString;

	}
}

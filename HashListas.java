/**
 * 
 */
package es.upm.dit.adsw.ej3;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase HashListas
 * 
 * @author juan
 * @source Carlos Iglesias
 * @version 14.03.2016
 */
public class HashListas implements Diccionario {
	private final List<CV>[] slots;
	private int nDatos = 0;

	@SuppressWarnings("unchecked")
	public HashListas(int nSlots) {
		slots = new List[nSlots];

	}

	@Override
	public void put(String clave, String valor) throws IllegalArgumentException {
		if (clave == null || valor == null || clave.length() == 0)
			throw new IllegalArgumentException();
		int h = Math.abs(clave.hashCode() % slots.length);
		if (slots[h] == null)
			slots[h] = new ArrayList<CV>();
		put(slots[h], clave, valor);
	}

	/**
	 * Introducimos el objeto dentro de su correspondiente lista.
	 * 
	 * @param list
	 * @param clave
	 * @param valor
	 */
	private void put(List<CV> list, String clave, String valor) {

		for (CV cv : list) {
			if (OpMeter.compareTo(cv.getClave(), clave) == 0) {
				cv.setValor(valor);
				return;
			}
		}
		list.add(new CV(clave, valor));
		nDatos++;
	}

	@Override
	public String get(String clave) {
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException();
		int h = Math.abs(clave.hashCode()) % slots.length;
		return get(slots[h], clave);
	}

	/**
	 * Buscamos el objeto dentro de su correspondiente lista.
	 * 
	 * @param list
	 * @param clave
	 * @return
	 */
	private String get(List<CV> list, String clave) {
		if (list == null) {
			return null;
		}
		for (CV cv : list) {
			if (OpMeter.compareTo(cv.getClave(), clave) == 0)
				return cv.getValor();
		}
		return null;
	}

	@Override
	public String remove(String clave) {

		// TODO Auto-generated method stub
		if (clave == null || clave.length() == 0)
			throw new IllegalArgumentException();
		int h = Math.abs(clave.hashCode()) % slots.length;
		return remove(slots[h], clave);
	}

	/**
	 * Borramos el objeto dentro de su correspondiente lista.
	 * 
	 * @param list
	 * @param clave
	 * @return
	 */
	private String remove(List<CV> list, String clave) {
		CV s = null;
		if (list == null)
			return null;
		for (CV cv : list) {
			if (OpMeter.compareTo(clave, cv.getClave()) == 0) {
				s = cv;
				break;
			}

		}
		if (s == null)
			return null;
		String value = s.getValor();
		list.remove(s);
		nDatos--;
		return value;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return nDatos;
	}

	@Override
	public void clear() {
		for (int i = 0; i < slots.length; i++) {
			if (slots[i] != null) {
				slots[i] = null;
				nDatos = 0;
			}

		}
	}

}

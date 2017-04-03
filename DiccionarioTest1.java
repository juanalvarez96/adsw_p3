package es.upm.dit.adsw.ej3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Pruebas de diccionario
 * 
 * @source jpuente
 * @author Juan Álvarez
 * @version 20160217
 */
public class DiccionarioTest1 {

	private Diccionario HashListas;

	private static int size = 5;

	@Before
	public void setUp() {
		HashListas = new HashListas(size);

	}

	/**
	 * Diccionario vacío
	 */
	
	@Test
	public void testEmpty() {
		testEmpty(HashListas);

	}

	private void testEmpty(Diccionario diccionario) {
		assertEquals(0, diccionario.size());
		assertNull(diccionario.get("clave"));
		assertNull(diccionario.remove("clave)"));
	}

	/**
	 * Introducir clave nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPut00() {
		testPut00(HashListas);

	}

	private void testPut00(Diccionario diccionario) {
		diccionario.put(null, "valor");

	}

	/**
	 * Introducir clave vacía
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPut01() {
		testPut01(HashListas);

	}

	private void testPut01(Diccionario diccionario) {
		diccionario.put("", "valor");
	}

	/**
	 * Introducir clave nueva
	 */
	@Test
	public void testPut02() {
		testPut02(HashListas);
	}

	private void testPut02(Diccionario diccionario) {
		diccionario.put("clave", "valor");
		assertEquals(1, diccionario.size());
		assertEquals("valor", diccionario.get("clave"));
	}

	/**
	 * Introducir clave repetida
	 */
	@Test
	public void testPut03() {
		testPut03(HashListas);

	}

	private void testPut03(Diccionario diccionario) {
		diccionario.put("clave", "valor1");
		assertEquals(1, diccionario.size());
		diccionario.put("clave", "valor2");
		assertEquals(1, diccionario.size());
		assertEquals("valor2", diccionario.get("clave"));
	}

	/**
	 * Introducir valor nuevo en diccionario lleno
	 */
	//@Test(expected = RuntimeException.class)
	public void testPut04() {
		testPut04(HashListas);
	}

	private void testPut04(Diccionario diccionario) {
		for (int i = 0; i < size; i++) {
			diccionario.put(Integer.toString(i), "valor");
		}
		diccionario.put("otro", "lleno");
	}

	/**
	 * Recuperar clave nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGet00() {
		testGet00(HashListas);

	}

	private void testGet00(Diccionario diccionario) {
		diccionario.get(null);
	}

	/**
	 * Recuperar clave vacía
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGet01() {
		testGet01(HashListas);

	}

	private void testGet01(Diccionario diccionario) {
		diccionario.get("");
	}

	/**
	 * Recuperar clave inexistente (diccionario vacío)
	 */
	@Test
	public void testGet02() {
		testGet02(HashListas);
		
	}

	private void testGet02(Diccionario diccionario) {
		assertNull(diccionario.get("clave"));
	}

	/**
	 * Recuperar clave inexistente
	 */
	@Test
	public void testGet03() {
		testGet03(HashListas);

	}

	private void testGet03(Diccionario diccionario) {
		diccionario.put("clave", "valor");
		assertNull(diccionario.get("clave1"));
	}

	/**
	 * Eliminar clave nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemove00() {
		testRemove00(HashListas);

	}

	private void testRemove00(Diccionario diccionario) {
		diccionario.remove(null);
	}

	/**
	 * Eliminar clave vacía
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemove01() {
		testRemove01(HashListas);

	}

	private void testRemove01(Diccionario diccionario) {
		diccionario.remove("");
	}

	/**
	 * Eliminar clave inexistente (diccionario vacío)
	 */
	@Test
	public void testRemove02() {
		testRemove02(HashListas);

	}

	private void testRemove02(Diccionario diccionario) {
		assertNull(diccionario.remove("clave"));
		assertEquals(0, diccionario.size());
	}

	/**
	 * Eliminar clave inexistente
	 */
	@Test
	public void testRemove03() {
		testRemove03(HashListas);

	}

	private void testRemove03(Diccionario diccionario) {
		diccionario.put("clave", "valor");
		assertNull(diccionario.remove("clave1"));
		assertEquals(1, diccionario.size());
	}

	/**
	 * Eliminar clave existente
	 */
	@Test
	public void testRemove04() {
		testRemove04(HashListas);
	}

	private void testRemove04(Diccionario diccionario) {
		diccionario.put("clave", "valor");
		assertEquals("valor", diccionario.remove("clave"));
		assertEquals(0, diccionario.size());
	}

	/**
	 * Eliminar clave existente, comprobar que el resto sigue igual
	 */
	@Test
	public void testRemove05() {
		testRemove05(HashListas);
		
	}

	private void testRemove05(Diccionario diccionario) {
		diccionario.put("clave1", "valor1");
		diccionario.put("clave2", "valor2");
		diccionario.put("clave3", "valor3");
		assertEquals(3, diccionario.size());
		assertEquals("valor2", diccionario.remove("clave2"));
		assertEquals("valor1", diccionario.get("clave1"));
		assertNull(diccionario.get("clave2"));
		assertEquals("valor3", diccionario.get("clave3"));
		assertEquals(2, diccionario.size());
	}

	/**
	 * Borrar todo el diccionario
	 */
	@Test
	public void testClear00() {
		testClear00(HashListas);

	}

	private void testClear00(Diccionario diccionario) {
		diccionario.put("clave", "valor");
		diccionario.put("clave1", "valor1");
		diccionario.put("clave2", "valor2");
		diccionario.put("clave3", "valor3");
		diccionario.put("clave4", "valor4");
		diccionario.put("clave5", "valor5");
		diccionario.put("clave6", "valor6");
		diccionario.put("clave7", "valor7");
		diccionario.put("clave8", "valor8");
		diccionario.put("clave9", "valor9");
		diccionario.put("clave10", "valor10");
		diccionario.put("clave11", "valor11");
		diccionario.put("clave12", "valor12");
		diccionario.put("clave13", "valor13");
		diccionario.put("clave14", "valor14");
		diccionario.put("clave15", "valor15");
		diccionario.put("clave16", "valor16");
		diccionario.put("clave17", "valor17");
		diccionario.put("clave18", "valor18");
		diccionario.clear();
		assertNull(diccionario.get("clave"));
		assertEquals(0, diccionario.size());
		assertNull(diccionario.get("clave4"));
	}
	/**
	 * Comprobamos que el método put, clear y remove funcionan correctamente. Prueba por prueba.
	 */
	@Test 
	public void testAdd00(){
		testAdd00(HashListas);
	}
	private void testAdd00(Diccionario diccionario){
	
			
			diccionario.put("clave1", "valor1");
			assertEquals(1, diccionario.size());
			diccionario.put("clave2", "valor2");
			assertEquals(2, diccionario.size());
			diccionario.put("clave3", "valor3");
			assertEquals(3, diccionario.size());
			diccionario.put("clave4", "valor4");
			assertEquals(4, diccionario.size());
			diccionario.put("clave5", "valor5");
			assertEquals(5, diccionario.size());
			diccionario.put("clave6", "valor6");
			assertEquals(6, diccionario.size());
			diccionario.put("clave7", "valor7");
			assertEquals(7, diccionario.size());
			diccionario.put("clave8", "valor8");
			assertEquals(8, diccionario.size());
			diccionario.put("clave9", "valor9");
			assertEquals(9, diccionario.size());
			diccionario.put("clave10", "valor10");
			assertEquals(10, diccionario.size());
			diccionario.put("clave1", "valorn1");
			assertEquals("valorn1",diccionario.get("clave1"));
			diccionario.put("clave2", "valorn2");
			assertEquals("valorn2",diccionario.get("clave2"));
			diccionario.put("clave3", "valorn3");
			assertEquals("valorn3",diccionario.get("clave3"));
			diccionario.put("clave4", "valorn4");
			assertEquals("valorn4",diccionario.get("clave4"));
			diccionario.put("clave5", "valorn5");
			assertEquals("valorn5",diccionario.get("clave5"));
			diccionario.put("clave6", "valorn6");
			assertEquals("valorn6",diccionario.get("clave6"));
			diccionario.put("clave7", "valorn7");
			assertEquals("valorn7",diccionario.get("clave7"));
			diccionario.put("clave8", "valorn8");
			assertEquals("valorn8",diccionario.get("clave8"));
			diccionario.put("clave9", "valorn9");
			assertEquals("valorn9",diccionario.get("clave9"));
			diccionario.put("clave10", "valorn10");			
			assertEquals("valorn10",diccionario.get("clave10"));
			diccionario.clear();		
			assertEquals(0,diccionario.size());
			diccionario.put("clave1", "valor1");
			diccionario.put("clave2", "valor2");
			diccionario.put("clave3", "valor3");
			diccionario.put("clave4", "valor4");
			diccionario.put("clave5", "valor5");
			diccionario.put("clave6", "valor6");
			diccionario.put("clave7", "valor7");
			diccionario.put("clave8", "valor8");
			diccionario.put("clave9", "valor9");
			diccionario.put("clave10", "valor10");
			diccionario.remove("clave1");
			assertEquals(9,diccionario.size());
			assertNull(diccionario.get("clave1"));
			diccionario.remove("clave2");
			assertEquals(8,diccionario.size());
			assertNull(diccionario.get("clave2"));
			diccionario.remove("clave3");
			assertEquals(7,diccionario.size());
			assertNull(diccionario.get("clave3"));
			diccionario.remove("clave4");
			assertEquals(6,diccionario.size());
			assertNull(diccionario.get("clave4"));
			diccionario.remove("clave5");
			assertEquals(5,diccionario.size());
			assertNull(diccionario.get("clave5"));
			diccionario.remove("clave6");
			assertEquals(4,diccionario.size());
			assertNull(diccionario.get("clave6"));
			diccionario.remove("clave7");
			assertEquals(3,diccionario.size());
			assertNull(diccionario.get("clave7"));
			diccionario.remove("clave8");
			assertEquals(2,diccionario.size());
			assertNull(diccionario.get("clave8"));
			diccionario.remove("clave9");
			assertEquals(1,diccionario.size());
			assertNull(diccionario.get("clave9"));
			diccionario.remove("clave10");
			assertEquals(0,diccionario.size());
			assertNull(diccionario.get("clave10"));
			
			
			
		}

	

	
	}



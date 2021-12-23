package abstract_data_type;

import org.junit.jupiter.api.Test;

class FilaStringTest {

	@Test
	void test() {
		FilaString fila = new FilaString();
		
		String test, aux = "cleitin";
		
		fila.Add(aux);
		
		test = fila.StartRemove();
		System.out.println(test);
		
	}

}

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

package Main;

class MainTest {

	@Test
	void getInputTest() {
		Main junit = new Main();
		
		String expBusca = "teste";
	    InputStream in = new ByteArrayInputStream(expBusca.getBytes());
	    System.setIn(in);
		assertEquals("teste", Input.getInput());
	}

	@Test
	public void testExhibitResults() {
		Main junit = new Main();
	    String request = "Teste";
	    String expResp = "Teste";
	    String resposta = Main.exhibitResults(request);
	    assertEquals(expResp, resposta);
	}
}

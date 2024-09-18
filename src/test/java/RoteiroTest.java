import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class RoteiroTest {

    @Test
	public void test() {
		FilaPrioridade heap = new HeapFilaPrioridade(5);
		FilaPrioridade insereFinal = new InsereFinalFilaPrioridade(5);
		FilaPrioridade insertion = new InsereOrdenadoFilaPrioridade(5);
		FilaPrioridade[] estrategias = new FilaPrioridade[3];
		estrategias[0] = heap;
		estrategias[1] = insereFinal;
        estrategias[2] = insertion;

        // 1, 2, 3, 4, 5
		for (FilaPrioridade fila : estrategias) {
			fila.add("a", 1);
			fila.add("b", 2);
			fila.add("c", 3);
			fila.add("d", 4);
			fila.add("e", 5);
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "e");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "d");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "c");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "b");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "a");
		}

		// 5, 4, 3, 2, 1
		for (FilaPrioridade fila : estrategias) {
			fila.add("a", 5);
			fila.add("b", 4);
			fila.add("c", 3);
			fila.add("d", 2);
			fila.add("e", 1);
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "a");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "b");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "c");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "d");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "e");
		}


		// 7, 2, 1, 9, -1 (valores de prioridade iguais segue fifo)
		for (FilaPrioridade fila : estrategias) {
			fila.add("a", 7);
			fila.add("b", 2);
			fila.add("c", 1);
			fila.add("d", 9);
			fila.add("e", -1);
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "d");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "a");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "b");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "c");
		}

		for (FilaPrioridade fila : estrategias) {
			assertEquals(fila.removeNext(), "e");
		}

	}

}

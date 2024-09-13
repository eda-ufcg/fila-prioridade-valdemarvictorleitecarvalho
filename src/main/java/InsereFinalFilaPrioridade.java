import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair newPair = new Pair(elemento, prioridade);

		if (this.fila.isEmpty()) {
			this.fila.add(newPair);
			return;
		}

		for (int i = this.fila.size() - 1; i >= 0; i--) {
			if (this.fila.get(i).getPrioridade() <= newPair.getPrioridade()) {
				this.fila.add(i, newPair);
				break;
			}
		}
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		Pair pair = this.fila.get(this.fila.size() - 1); 
		
		this.fila.remove(this.fila.size() - 1);

		return pair.getElemento();
	}

}

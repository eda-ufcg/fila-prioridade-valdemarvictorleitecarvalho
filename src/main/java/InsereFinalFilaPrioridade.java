import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}

	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair newPair = new Pair(elemento, prioridade);

	    this.fila.add(newPair);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
        Pair elem = this.fila.get(0);

        for (Pair par : this.fila) {
            if (par.getPrioridade() > elem.getPrioridade()) {
                elem = par;
            }
        }

        this.fila.remove(elem);

		return elem.getElemento();
	}

}

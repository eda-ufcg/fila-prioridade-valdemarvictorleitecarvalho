public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}

	private boolean isEmpty() {
		return this.head == -1 && this.tail == -1;
	}

	private void resize() {
		Pair[] newFila = new Pair[this.fila.length * 2];

		for (int i = 0; i < newFila.length; i++) {
			newFila[i] = this.fila[i];
		}
		this.fila = newFila;
	}

	private void shiftParaDireita(int index) {
		if (index == this.lista.length - 1) throw new IndexOutBoundsException();
		
		for (int i = this.last; i > index; i--) {
			this.lista[i] = this.lista[i - 1];
		}
	}

	private void shiftParaEsquerda(int index) {
		for (int i = index; i < this.last - 1; i++) {
			this.fila[i] = this.fila[i + 1];
		}
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		if (this.fila.length == this.tail) resize();

		Pair newPair = new Pair(elemento, prioridade);

		if (isEmpty()) {
			this.head++;
			this.last++;
			this.fila[head] = newPair;
		}
		else {
			for (int i = this.head; i <= this.tail; i++) {
				if (this.fila[i].getPrioridade() >= newPair.getPrioridade()) {
					shiftParaDireita();
					this.fila[i] = newPair;
					return;
				}
			}			
		}
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		return "";
	}

}

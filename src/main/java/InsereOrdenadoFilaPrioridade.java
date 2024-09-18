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
		return this.head == -1 && this.last == -1;
	}

    private boolean isFull() {
        return ((this.last + 1) % this.fila.length) == this.head;
    }

	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		Pair newPair = new Pair(elemento, prioridade);

        if (isEmpty()) this.head = 0;

        if (isFull()) this.head = (this.head + 1) % this.fila.length;

        this.last = (this.last + 1) % this.fila.length;
        this.fila[this.last] = newPair;

        for (int i = this.last; i < this.head; i--) {
            if (this.fila[i].getPrioridade() > this.fila[i - 1].getPrioridade()) {
                swap(i, i - 1);
            }
        }
    }

    private void swap(int i, int j) {
        Pair aux = this.fila[i];
        this.fila[i] = this.fila[j];
        this.fila[j] = aux;
    }


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
        if (isEmpty()) throw new RuntimeException("Fila vazia");

        String elem = this.fila[this.head].getElemento();

        if (this.head == this.last) {
            this.head = -1;
            this.last = -1;
        }
        else this.head = (this.head + 1) % this.fila.length;

		return elem;
	}

}

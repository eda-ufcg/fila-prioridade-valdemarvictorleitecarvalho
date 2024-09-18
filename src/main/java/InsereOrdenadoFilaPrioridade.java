public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;
    private int size;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
        this.size = 0;
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

        if (isFull()) resize();

        this.size++;

        this.last = (this.last + 1) % this.fila.length;
        this.fila[this.last] = newPair;

        int i = this.last;
        while (i > 0 && this.fila[i].getPrioridade() > this.fila[i - 1].getPrioridade()) {
            swap(i, i - 1);
            i--;
        }
    }

    public int size() {
        return this.size;
    }

    private void swap(int i, int j) {
        Pair aux = this.fila[i];
        this.fila[i] = this.fila[j];
        this.fila[j] = aux;
    }

    private void resize(){
		Pair[] newFila = new Pair[this.fila.length * 2];
		int j = this.head;
		int end = size();

		for(int i = 0 ; i < end ; i++){
			newFila[i] = this.fila[j];
			j = (j + 1) % this.fila.length;
		}

		this.head = 0;
		this.last = end - 1;

		this.fila = newFila;
	}

	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
        if (isEmpty()) throw new RuntimeException("Fila vazia");

        String elem = this.fila[this.head].getElemento();
        this.size--;

        if (this.head == this.last) {
            this.head = -1;
            this.last = -1;
        }
        else this.head = (this.head + 1) % this.fila.length;

		return elem;
	}

}

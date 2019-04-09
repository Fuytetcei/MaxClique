package max_clique;

public class HeapClique {
	private Node heap[];
	private int len;
	private int maxLen;

	public HeapClique(){
		this.maxLen = 2;
		this.len = 0;
		this.heap = new Node[2];
	}

	public boolean insert(Node v) {
		int curr = this.len;
		int padre;
		Node aux;

		// Compruebo la memoria
		checkMemory();

		// Asigno el nuevo elemento
		heap[curr] = v;
		heap[curr].setIndice(curr);
		this.len++;

		while((this.len > 0)) {
			// Calculo posición del padre
			if(curr % 2 != 0)
				padre = (curr-1)/2;
			else
				padre = (curr-2)/2;

			// Comparo con el padre
			if(padre < 0)
				break;
			if(esMenor(heap[padre].getG().getSize(), heap[curr].getG().getSize())) {
				// Floto clave
				aux = heap[padre];
				heap[padre] = heap[curr];
				heap[padre].setIndice(padre);
				heap[curr] = aux;
				heap[curr].setIndice(curr);
				curr = padre;
			} else // Termino
				break;
		}
		return true;
	}

	public boolean removeHead() {
		int min;
		// Intercambio cabeza con el último elemento
		Node aux = this.heap[len-1];
			this.heap[len-1] = this.heap[0];
			this.heap[len-1].setIndice(len-1);
			this.heap[0] = aux;
			this.heap[0].setIndice(0);
		// Actualizo contadores
			this.len--;
		// Hundo cabeza
			int curr = 0;

			while(true) {
				// Recojo hijo menor
				if(((curr*2)+2)>=len && ((curr*2)+1)<len)
					min = (curr*2)+1;
				else if (((curr*2)+1)>=len && ((curr*2)+2)>=len)
					break;
				else
					min = (esMenor(this.heap[(curr*2)+2].getG().getSize(), this.heap[(curr*2)+1].getG().getSize())) ? (curr*2)+1 : (curr*2)+2;
				// Intercambio
				if(esMenor(this.heap[curr].getG().getSize(), this.heap[min].getG().getSize())) {
					aux = this.heap[curr];
					this.heap[curr] = this.heap[min];
					this.heap[curr].setIndice(curr);
					this.heap[min] = aux;
					this.heap[min].setIndice(min);
				}

				curr = min;
			}
		// Actualizo memoria
			checkMemory();

		return true;
	}

	public Node getHeadKey() {
		if(this.len>0)
			return this.heap[0];
		else
			return null;
	}

	public int getLen() {
		return this.len;
	}
	public void print() {
		int i;
		System.out.print("Len: " + this.len + " --> ");
		for(i = 0; i<this.len; i++) {
			System.out.print("(" + this.heap[i].getG().getSize() + ", " + this.heap[i].getIndice() + ", " + i + ") -- ");
		}
		System.out.print("<-- " + i);
		System.out.println();
	}

	public boolean isReady() {
		return this.len > 0;
	}

	private void checkMemory() {
		// Compruebo si tengo que aumentar la memoria
		if(this.len == (this.maxLen)) {
			// Creo nuevo array
			Node newArray [] = new Node[maxLen*2];

			// Guardo en el nuevo array
			for(int i = 0; i<len; i++) {
				newArray[i] = this.heap[i];
				newArray[i].setIndice(i);
			}
			this.heap = newArray;
			this.maxLen = this.maxLen*2;

			return;
		}

		// Compruebo si tengo que disminuir la memoria
		if(this.len == (this.maxLen/4)) {
			// Creo nuevo array
			Node newArray [] = new Node[maxLen/2];

			// Guardo en el nuevo array
			for(int i = 0; i<len; i++) {
				newArray[i] = this.heap[i];
				newArray[i].setIndice(i);
			}
			this.heap = newArray;
			this.maxLen = this.maxLen/2;

			return;
		}
	}

	private static boolean esMenor(int a, int b) {
		if(a == -1)
			return false;
		if(b == -1)
			return true;
		return (a < b);
	}
}
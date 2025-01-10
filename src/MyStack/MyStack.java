package MyStack;

public class MyStack<T> {

	private T[] elements;
	private int stackSize;

	public T[] getElements() {
		return elements;
	}

	public MyStack() {
		elements = (T[]) new Object[2];
		stackSize = 0;
	}

	private void resize(int max) {
		T[] auxStack;
		auxStack = (T[]) new Object[max];
		for (int i = 0; i < stackSize; i++) {
			auxStack[i] = elements[i];
		}
		elements = auxStack;
	}

	public boolean isEmpty() {
		return stackSize == 0;
	}

	public T peek() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();

		}
		return elements[stackSize - 1];
	}

	public void push(T t) {
		if (stackSize == elements.length) {
			resize(2 * elements.length);
		}
		elements[stackSize++] = t;
	}

	public T pop() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T t = elements[--stackSize];
		if (stackSize > 0 && stackSize == elements.length / 4) {
			resize(elements.length / 2);
		}
		return t;
	}

	@Override
	public String toString() {
		if (this.stackSize == 0) {
			return "[]";
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = this.stackSize - 1; i >= 0; i--) {
			elements[i] = getElements()[i];
			stringBuilder.append(elements[i]).append(", ");
		}
		stringBuilder.setLength(stringBuilder.length() - 2);
		return "[" + stringBuilder.toString() + "] ";
	}
}

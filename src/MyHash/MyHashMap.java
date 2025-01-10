package MyHash;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> {

	private class Pair<K, V> {
		K key;
		V value;

		Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private static final double LOAD_FACTOR = 0.75;
	private int capacity;
	private int size;
	private Pair<K, V>[] map;

	public MyHashMap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.map = new Pair[capacity];
	}

	private int hash(K key) {
		return Math.abs(key.hashCode() % capacity);
	}

	private void rehash() {
		int newSize = capacity * 2;
		Pair[] oldMap = map;
		map = new Pair[newSize];
		capacity = newSize;
		size = 0;

		for (Pair<K, V> pair : oldMap) {
			if (pair != null) {
				put(pair.key, pair.value);
			}
		}
	}

	public void delete(K key) {
		int index = hash(key);

		while (map[index] != null) {
			if (map[index].key.equals(key)) {
				map[index] = null;
				size--;

				int nextIndex = (index + 1) % capacity;
				while (map[nextIndex] != null) {
					Pair<K, V> pairToRehash = map[nextIndex];
					map[nextIndex] = null;
					size--;
					put(pairToRehash.key, pairToRehash.value);
					nextIndex = (nextIndex + 1) % capacity;
				}
				return;
			}
			index = (index + 1) % capacity;
		}

		System.out.println("Key not found: " + key);
	}

	public void put(K key, V value) {
		if ((double) size / capacity >= LOAD_FACTOR) {
			rehash();
		}

		if (contains(key)) {
			value = null;
			delete(key);
		}

		int index = hash(key);
		while (map[index] != null && map[index].key != key) {
			index = (index + 1) % capacity;
		}
		if (map[index] == null) {
			map[index] = new Pair(key, value);
			size++;
		} else {
			map[index].value = value;
		}
	}

	public V get(K key) {
		int index = hash(key);
		while (map[index] != null) {
			if (map[index].key.equals(key)) {
				return map[index].value;
			}
			index = (index + 1) % capacity;
		}
		return null;
	}

	public V getValue() {
		for (Pair<K, V> pair : map) {
			if (pair != null && pair.value != null) {
				return pair.value;
			}
		}

		throw new Error();
	}

	public boolean contains(K key) {
		int index = hash(key);
		while (map[index] != null) {
			if (map[index].key.equals(key)) {
				return true;
			}
			index = (index + 1) % capacity;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MyHashMap[");
		for (int i = 0; i < capacity; i++) {
			if (map[i] != null && map[i].value != null) {
				sb.append(map[i].value).append(",");
			}
		}
		if (sb.length() > 10) {
			sb.setLength(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}

}

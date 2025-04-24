package MyHash;

/**
 * A generic hash map implementation with linear probing collision resolution.
 *
 * @param <K> Key type
 * @param <V> Value type
 */
public class MyHashMap<K, V> {

	/**
	 * Internal class to represent a key-value pair.
	 *
	 * @param <K> Key type
	 * @param <V> Value type
	 */
	private class Pair<K, V> {
		private final K key;
		private V value;

		/**
		 * Constructs a key-value pair.
		 *
		 * @param key The key
		 * @param value The value
		 */
		Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private static final Double LOAD_FACTOR = 0.75;
	private Integer capacity;
	private Integer size;
	private Pair<K, V>[] map;

	/**
	 * Constructs a hash map with the specified initial capacity.
	 *
	 * @param capacity Initial capacity of the hash map
	 */
	public MyHashMap(Integer capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.map = new Pair[capacity];
	}

	/**
	 * Computes the hash code for a key.
	 *
	 * @param key The key to hash
	 * @return The hash code
	 */
	private Integer hash(K key) {
		return Math.abs(key.hashCode() % capacity);
	}

	/**
	 * Resizes the hash map when the load factor threshold is reached.
	 */
	private void rehash() {
		Integer newSize = capacity * 2;
		Pair<K, V>[] oldMap = map;
		map = new Pair[newSize];
		capacity = newSize;
		size = 0;

		for (Pair<K, V> pair : oldMap) {
			if (pair != null) {
				put(pair.key, pair.value);
			}
		}
	}

	/**
	 * Removes a key-value pair from the hash map.
	 *
	 * @param key The key to remove
	 */
	public void delete(K key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}

		Integer index = hash(key);

		while (map[index] != null) {
			if (map[index].key.equals(key)) {
				map[index] = null;
				size--;

				// Rehash all elements in the same cluster
				Integer nextIndex = (index + 1) % capacity;
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

	/**
	 * Adds a key-value pair to the hash map.
	 *
	 * @param key The key
	 * @param value The value
	 * @throws IllegalArgumentException if key is null
	 */
	public void put(K key, V value) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}

		if ((double) size / capacity >= LOAD_FACTOR) {
			rehash();
		}

		if (contains(key)) {
			delete(key);
		}

		Integer index = hash(key);
		while (map[index] != null && !map[index].key.equals(key)) {
			index = (index + 1) % capacity;
		}

		if (map[index] == null) {
			map[index] = new Pair<>(key, value);
			size++;
		} else {
			map[index].value = value;
		}
	}

	/**
	 * Gets the value associated with the specified key.
	 *
	 * @param key The key
	 * @return The value associated with the key or null if not found
	 * @throws IllegalArgumentException if key is null
	 */
	public V get(K key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}

		Integer index = hash(key);
		while (map[index] != null) {
			if (map[index].key.equals(key)) {
				return map[index].value;
			}
			index = (index + 1) % capacity;
		}
		return null;
	}

	/**
	 * Gets the first non-null value in the hash map.
	 *
	 * @return The first non-null value
	 * @throws IllegalStateException if the hash map is empty
	 */
	public V getValue() {
		for (Pair<K, V> pair : map) {
			if (pair != null && pair.value != null) {
				return pair.value;
			}
		}
		throw new IllegalStateException("Hash map is empty");
	}

	/**
	 * Checks if the hash map contains the specified key.
	 *
	 * @param key The key to check
	 * @return true if the key exists, false otherwise
	 * @throws IllegalArgumentException if key is null
	 */
	public boolean contains(K key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}

		Integer index = hash(key);
		while (map[index] != null) {
			if (map[index].key.equals(key)) {
				return true;
			}
			index = (index + 1) % capacity;
		}
		return false;
	}

	/**
	 * Returns the size of the hash map.
	 *
	 * @return The number of key-value pairs in the hash map
	 */
	public Integer size() {
		return size;
	}

	/**
	 * Checks if the hash map is empty.
	 *
	 * @return true if the hash map is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns a string representation of the hash map.
	 *
	 * @return String representation of the hash map
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("MyHashMap[");
		boolean first = true;

		for (Integer i = 0; i < capacity; i++) {
			if (map[i] != null && map[i].value != null) {
				if (!first) {
					sb.append(", ");
				}
				first = false;
				sb.append(map[i].value);
			}
		}
		sb.append("]");
		return sb.toString();
	}
}

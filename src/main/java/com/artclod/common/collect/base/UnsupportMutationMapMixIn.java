package com.artclod.common.collect.base;

import java.util.Map;
import java.util.function.BiFunction;

public interface UnsupportMutationMapMixIn<K, V> extends Map<K, V> {

	@Deprecated
	public default V put(K key, V value) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default void putAll(Map<? extends K, ? extends V> m) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default V remove(Object key) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default void clear() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default V putIfAbsent(K key, V value) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default boolean remove(Object key, Object value) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default boolean replace(K key, V oldValue, V newValue) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default V replace(K key, V value) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
		throw new UnsupportedOperationException();
	}
	
}

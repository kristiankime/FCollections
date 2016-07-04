package com.artclod.common.collect;

import java.util.Map;
import java.util.function.BiFunction;

public interface ViewFMap<K, V> extends FMap<K, V> {

	@Deprecated
	public V put(K key, V value);

	@Deprecated
	public void putAll(Map<? extends K, ? extends V> m);

	@Deprecated
	public V remove(Object key);

	@Deprecated
	public void clear();

	@Deprecated
	public V putIfAbsent(K key, V value);

	@Deprecated
	public boolean remove(Object key, Object value);

	@Deprecated
	public boolean replace(K key, V oldValue, V newValue);

	@Deprecated
	public V replace(K key, V value);

	@Deprecated
	public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction);

	@Deprecated
	public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function);
	
}

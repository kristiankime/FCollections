package com.artclod.common.collect.base;

import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import com.artclod.common.collect.FMap;
import com.artclod.common.collect.LinkedHashViewFSet;
import com.artclod.common.collect.ViewFSet;
import com.artclod.common.collect.builder.MapBuilder;

public abstract class BaseFMap<K, V, M extends FMap<K, V>> implements FMap<K, V> {

	protected final Map<K, V> inner;
	private transient LinkedHashViewFSet<K> keyView;
//	private transient CollectionView<V> valueView;
	private transient LinkedHashViewFSet<java.util.Map.Entry<K, V>> entryView;
	
	public BaseFMap(Map<K, V> inner) {
		this.inner = inner;
	}
	
    protected abstract MapBuilder<K, V, M> builder();
    
	// ========== NEW F METHODS =========
	@Override
	public FMap<K, V> filter(BiPredicate<? super K, ? super V> filter) {
		MapBuilder<K, V, M> builder = builder();
		for (java.util.Map.Entry<K, V> entry : entrySet()) {
			if(filter.test(entry.getKey(), entry.getValue())) {
				builder.put(entry.getKey(), entry.getValue());
			}
		}
		return builder.build();
	}
	
	@Override
	public FMap<K, V> filterKeys(Predicate<? super K> filter) {
		MapBuilder<K, V, M> builder = builder();
		for (java.util.Map.Entry<K, V> entry : entrySet()) {
			if(filter.test(entry.getKey())) {
				builder.put(entry.getKey(), entry.getValue());
			}
		}
		return builder.build();
	}
	
	@Override
	public boolean nonEmpty() {
		return !isEmpty();
	}

	// =========== Identity as inner ===========
	public boolean equals(Object o) {
		return inner.equals(o);
	}

	public int hashCode() {
		return inner.hashCode();
	}

	@Override
	public String toString() {
		return inner.toString();
	}
	
	// ========== COLLECTION VIEWS =========
	public ViewFSet<K> keySet() {
		if(keyView == null) {
			keyView = new LinkedHashViewFSet<>(inner.keySet());
		}
		return keyView;
	}

	public Collection<V> values() {
		return inner.values();
	}

	public ViewFSet<java.util.Map.Entry<K, V>> entrySet() {
		if(entryView == null) {
			entryView = new LinkedHashViewFSet<>(inner.entrySet());
		}
		return entryView;
	}
	
	// ========== DELEGATE METHODS =========
	public int size() {
		return inner.size();
	}

	public boolean isEmpty() {
		return inner.isEmpty();
	}

	public V get(Object key) {
		return inner.get(key);
	}

	public boolean containsKey(Object key) {
		return inner.containsKey(key);
	}

	public V put(K key, V value) {
		return inner.put(key, value);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		inner.putAll(m);
	}

	public V remove(Object key) {
		return inner.remove(key);
	}

	public void clear() {
		inner.clear();
	}

	public boolean containsValue(Object value) {
		return inner.containsValue(value);
	}

	public V getOrDefault(Object key, V defaultValue) {
		return inner.getOrDefault(key, defaultValue);
	}

	public V putIfAbsent(K key, V value) {
		return inner.putIfAbsent(key, value);
	}

	public boolean remove(Object key, Object value) {
		return inner.remove(key, value);
	}

	public boolean replace(K key, V oldValue, V newValue) {
		return inner.replace(key, oldValue, newValue);
	}

	public V replace(K key, V value) {
		return inner.replace(key, value);
	}

	public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
		return inner.computeIfAbsent(key, mappingFunction);
	}

	public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return inner.computeIfPresent(key, remappingFunction);
	}

	public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return inner.compute(key, remappingFunction);
	}

	public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		return inner.merge(key, value, remappingFunction);
	}

	public void forEach(BiConsumer<? super K, ? super V> action) {
		inner.forEach(action);
	}

	public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
		inner.replaceAll(function);
	}

}

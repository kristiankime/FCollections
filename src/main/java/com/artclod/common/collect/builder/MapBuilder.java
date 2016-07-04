package com.artclod.common.collect.builder;

import java.util.Map;

public interface MapBuilder<K, V, M extends Map<K, V>> {

	public V put(K key, V value);
	
	public M build();

}

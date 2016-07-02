package com.artclod.common.collect.builder;

import com.artclod.common.collect.FMap;

public interface MapBuilder<K, V, M extends FMap<K, V>> {

	public V put(K key, V value);
	
	public M build();

}

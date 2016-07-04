package com.artclod.common.collect.builder;

import com.artclod.common.collect.GuavaImFMap;
import com.google.common.collect.ImmutableMap;

public class GuavaImFMapBuilder<K, V> implements MapBuilder<K, V, GuavaImFMap<K, V>> {
	private ImmutableMap.Builder<K, V> inner;

	public GuavaImFMapBuilder(ImmutableMap.Builder<K, V> inner) {
		this.inner = inner;
	}

	@Override
	public V put(K key, V value) {
		inner.put(key, value);
		return value;
	}

	@Override
	public GuavaImFMap<K, V> build() {
		return new GuavaImFMap<>(inner.build());
	}

}

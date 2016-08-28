package com.artclod.common.collect;

import java.util.Map.Entry;

import com.artclod.common.collect.contract.ImmutableFMapContract;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class GuavaImFMapTest extends ImmutableFMapContract {
	
	@Override
	public <K, V> ImFMap<K, V> fMap(@SuppressWarnings("unchecked") Entry<K, V>... elements) {
		Builder<K, V> builder = ImmutableMap.<K, V> builder();
		for (Entry<K, V> element : elements) {
			builder.put(element);
		}
		return new GuavaImFMap<>(builder.build());
	}

}

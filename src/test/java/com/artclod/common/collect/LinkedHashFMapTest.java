package com.artclod.common.collect;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.artclod.common.collect.contract.FMapContract;

public class LinkedHashFMapTest extends FMapContract {

	@Override
	public <K, V> FMap<K, V> fMap(@SuppressWarnings("unchecked") Entry<K, V>... elements) {
		LinkedHashFMap<K, V> ret = new LinkedHashFMap<>(new LinkedHashMap<>());
		for (Entry<K, V> element : elements) {
			ret.put(element.getKey(), element.getValue());
		}
		return ret;
	}
}

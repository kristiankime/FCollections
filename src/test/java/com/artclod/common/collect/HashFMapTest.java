package com.artclod.common.collect;

import java.util.HashMap;
import java.util.Map.Entry;

import com.artclod.common.collect.contract.MutableFMapContract;

public class HashFMapTest extends MutableFMapContract {

	@Override
	public <K, V> HashFMap<K, V> fMap(@SuppressWarnings("unchecked") Entry<K, V>... elements) {
		HashFMap<K, V> ret = new HashFMap<>(new HashMap<>());
		for (Entry<K, V> element : elements) {
			ret.put(element.getKey(), element.getValue());
		}
		return ret;
	}

}

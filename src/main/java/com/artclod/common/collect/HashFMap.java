package com.artclod.common.collect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.artclod.common.base.T2;
import com.artclod.common.collect.base.BaseFMap;
import com.artclod.common.collect.builder.MapBuilder;

public class HashFMap<K, V> extends BaseFMap<K, V, HashFMap<K,V>> implements FMap<K, V>, Serializable{
	private static final long serialVersionUID = 1L;

	public HashFMap(HashMap<K, V> inner) {
		super(inner);
	}

	// ========== Builder =========
	private static class HashFMapBuilder<K, V> extends HashFMap<K, V> implements MapBuilder<K, V, HashFMap<K, V>> {
		private static final long serialVersionUID = 1L;

		public HashFMapBuilder(HashMap<K, V> inner) {
			super(inner);
		}

		@Override
		public HashFMap<K, V> build() {
			return this;
		}
	}
	
    protected HashFMapBuilder<K, V> builder() {
        return new HashFMapBuilder<K, V>(new HashMap<K, V>());
    }
	
	// ========== NEW F METHODS =========
	@Override
	public <NK, NV> FMap<NK, NV> map(BiFunction<? super K, ? super V, T2<? extends NK, ? extends NV>> f) {
		HashFMap<NK, NV> ret = new HashFMap<>(new HashMap<>(this.size()));
		for (java.util.Map.Entry<K, V> entry : entrySet()) {
			T2<? extends NK,? extends NV> t = f.apply(entry.getKey(), entry.getValue());
			ret.put(t._1, t._2);
		}
		return ret;
	}
	
	@Override
	public <NV> HashFMap<K, NV> mapValues(Function<? super V, ? extends NV> f) {
		HashFMap<K, NV> ret = new HashFMap<>(new HashMap<>(this.size()));
		for (java.util.Map.Entry<K, V> entry : entrySet()) {
			ret.put(entry.getKey(), f.apply(entry.getValue()));
		}
		return ret;
	}
	
}


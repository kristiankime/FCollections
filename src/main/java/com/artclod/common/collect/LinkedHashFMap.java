package com.artclod.common.collect;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.artclod.common.base.T2;
import com.artclod.common.collect.base.BaseFMap;
import com.artclod.common.collect.builder.MapBuilder;

public class LinkedHashFMap<K, V> extends BaseFMap<K, V, LinkedHashFMap<K,V>> implements FMap<K, V>, Serializable {
	private static final long serialVersionUID = 1L;

	public LinkedHashFMap(LinkedHashMap<K, V> inner) {
		super(inner);
	}

	// ========== Builder =========
	private static class LinkedHashFMapBuilder<K, V> extends LinkedHashFMap<K, V> implements MapBuilder<K, V, LinkedHashFMap<K, V>> {
		private static final long serialVersionUID = 1L;

		public LinkedHashFMapBuilder(LinkedHashMap<K, V> inner) {
			super(inner);
		}

		@Override
		public LinkedHashFMap<K, V> build() {
			return this;
		}
	}
	
    protected LinkedHashFMapBuilder<K, V> builder() {
        return new LinkedHashFMapBuilder<K, V>(new LinkedHashMap<K, V>());
    }
	
	// ========== NEW F METHODS =========
	@Override
	public <NK, NV> FMap<NK, NV> map(BiFunction<? super K, ? super V, T2<? extends NK, ? extends NV>> f) {
		LinkedHashFMap<NK, NV> ret = new LinkedHashFMap<>(new LinkedHashMap<>(this.size()));
		for (java.util.Map.Entry<K, V> entry : entrySet()) {
			T2<? extends NK,? extends NV> t = f.apply(entry.getKey(), entry.getValue());
			ret.put(t._1, t._2);
		}
		return ret;
	}
	
	@Override
	public <NV> LinkedHashFMap<K, NV> mapValues(Function<? super V, ? extends NV> f) {
		LinkedHashFMap<K, NV> ret = new LinkedHashFMap<>(new LinkedHashMap<>(this.size()));
		for (java.util.Map.Entry<K, V> entry : entrySet()) {
			ret.put(entry.getKey(), f.apply(entry.getValue()));
		}
		return ret;
	}
	
}


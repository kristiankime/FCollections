package com.artclod.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.artclod.common.base.T2;
import com.artclod.common.collect.base.BaseFMap;
import com.artclod.common.collect.builder.MapBuilder;

public class HashFMap<K, V> extends BaseFMap<K, V, HashFMap<K,V>> implements FMap<K, V> {
	private static final long serialVersionUID = 1L;

	public static <K, V> HashFMap<K, V> wrap(HashMap<K, V> inner) {
		return new HashFMap<>(inner);
	}
	
	public static <K, V> HashFMap<K, V> create() {
		return new HashFMap<>();
	}
	
	public static <K, V> HashFMap<K, V> create(K k1, V v1) {
		HashMap<K, V> inner = new HashMap<>();
		inner.put(k1, v1);
		return new HashFMap<>(inner);
	}

	public static <K, V> HashFMap<K, V> create(K k1, V v1, K k2, V v2) {
		HashMap<K, V> inner = new HashMap<>();
		inner.put(k1, v1);
		inner.put(k2, v2);
		return new HashFMap<>(inner);
	}

	public static <K, V> HashFMap<K, V> create(K k1, V v1, K k2, V v2, K k3, V v3) {
		HashMap<K, V> inner = new HashMap<>();
		inner.put(k1, v1);
		inner.put(k2, v2);
		inner.put(k3, v3);
		return new HashFMap<>(inner);
	}
	
	public static <K, V> HashFMap<K, V> create(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
		HashMap<K, V> inner = new HashMap<>();
		inner.put(k1, v1);
		inner.put(k2, v2);
		inner.put(k3, v3);
		inner.put(k4, v4);
		return new HashFMap<>(inner);
	}

	public static <K, V> HashFMap<K, V> create(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
		HashMap<K, V> inner = new HashMap<>();
		inner.put(k1, v1);
		inner.put(k2, v2);
		inner.put(k3, v3);
		inner.put(k4, v4);
		inner.put(k5, v5);
		return new HashFMap<>(inner);
	}
	
	@SafeVarargs
	public static <K, V> HashFMap<K, V> create(Map.Entry<K, V>... c) {
		return create(Arrays.asList(c));
	}
	
	public static <K, V> HashFMap<K, V> create(Collection<? extends Map.Entry<K, V>> c) {
		return new HashFMap<>(c);
	}

	private static <V, K> HashMap<K, V> toMap(Collection<? extends Map.Entry<K, V>> c) {
		HashMap<K, V> inner = new HashMap<>();
		for (java.util.Map.Entry<K, V> entry : c) {
			inner.put(entry.getKey(), entry.getValue());
		}
		return inner;
	}
	
	public static <K, V> HashFMap<K, V> create(Map<K, V> map) {
		return new HashFMap<>(map);
	}
	
	public HashFMap() {
		this(new HashMap<>());
	}
	
	public HashFMap(Collection<? extends Map.Entry<K, V>> c) {
		this(toMap(c));
	}
		
	public HashFMap(Map<K, V> map) {
		this(new HashMap<>(map));
	}
	
	protected HashFMap(HashMap<K, V> inner) {
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
    
    protected HashFMapBuilder<K, V> builder(Map<K, V> m) {
        return new HashFMapBuilder<K, V>(new HashMap<K, V>(m));
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


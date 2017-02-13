package com.artclod.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.artclod.common.base.Product2;
import com.artclod.common.collect.base.BaseFMap;
import com.artclod.common.collect.builder.MapBuilder;

public class LinkedHashFMap<K, V> extends BaseFMap<K, V, LinkedHashFMap<K,V>> implements FMap<K, V> {
	private static final long serialVersionUID = 1L;

	public static <K, V> LinkedHashFMap<K, V> wrap(LinkedHashMap<K, V> inner) {
		return new LinkedHashFMap<>(inner);
	}
	
	public static <K, V> LinkedHashFMap<K, V> create() {
		return new LinkedHashFMap<>(new LinkedHashMap<>());
	}
	
	public static <K, V> LinkedHashFMap<K, V> create(K k1, V v1) {
		LinkedHashMap<K, V> inner = new LinkedHashMap<>();
		inner.put(k1, v1);
		return new LinkedHashFMap<>(inner);
	}

	public static <K, V> LinkedHashFMap<K, V> create(K k1, V v1, K k2, V v2) {
		LinkedHashMap<K, V> inner = new LinkedHashMap<>();
		inner.put(k1, v1);
		inner.put(k2, v2);
		return new LinkedHashFMap<>(inner);
	}

	public static <K, V> LinkedHashFMap<K, V> create(K k1, V v1, K k2, V v2, K k3, V v3) {
		LinkedHashMap<K, V> inner = new LinkedHashMap<>();
		inner.put(k1, v1);
		inner.put(k2, v2);
		inner.put(k3, v3);
		return new LinkedHashFMap<>(inner);
	}
	
	public static <K, V> LinkedHashFMap<K, V> create(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
		LinkedHashMap<K, V> inner = new LinkedHashMap<>();
		inner.put(k1, v1);
		inner.put(k2, v2);
		inner.put(k3, v3);
		inner.put(k4, v4);
		return new LinkedHashFMap<>(inner);
	}

	public static <K, V> LinkedHashFMap<K, V> create(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
		LinkedHashMap<K, V> inner = new LinkedHashMap<>();
		inner.put(k1, v1);
		inner.put(k2, v2);
		inner.put(k3, v3);
		inner.put(k4, v4);
		inner.put(k5, v5);
		return new LinkedHashFMap<>(inner);
	}
	
	@SafeVarargs
	public static <K, V> LinkedHashFMap<K, V> create(Map.Entry<K, V>... c) {
		return new LinkedHashFMap<>(c);
	}
	
	public static <K, V> LinkedHashFMap<K, V> create(Collection<? extends Map.Entry<K, V>> c) {
		return new LinkedHashFMap<>(c);
	}

	private static <V, K> LinkedHashMap<K, V> toMap(Collection<? extends Map.Entry<K, V>> c) {
		LinkedHashMap<K, V> inner = new LinkedHashMap<>();
		for (java.util.Map.Entry<K, V> entry : c) {
			inner.put(entry.getKey(), entry.getValue());
		}
		return inner;
	}
	
	public static <K, V> LinkedHashFMap<K, V> create(Map<K, V> map) {
		return new LinkedHashFMap<>(new LinkedHashMap<>(map));
	}

	public LinkedHashFMap() {
		this(new LinkedHashMap<>());
	}
		
	@SafeVarargs
	public LinkedHashFMap(Map.Entry<K, V>... c) {
		this(Arrays.asList(c));
	}
	
	public LinkedHashFMap(Collection<? extends Map.Entry<K, V>> c) {
		this(new LinkedHashMap<>(toMap(c)));
	}
	
	public LinkedHashFMap(Map<K, V> map) {
		this(new LinkedHashMap<>(map));
	}
	
	protected LinkedHashFMap(LinkedHashMap<K, V> inner) {
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
    
    protected LinkedHashFMapBuilder<K, V> builder(Map<K, V> m) {
        return new LinkedHashFMapBuilder<K, V>(new LinkedHashMap<K, V>(m));
    }
	
	// ========== NEW F METHODS =========
	@Override
	public <NK, NV> FMap<NK, NV> map(BiFunction<? super K, ? super V, Product2<? extends NK, ? extends NV>> f) {
		LinkedHashFMap<NK, NV> ret = new LinkedHashFMap<>(new LinkedHashMap<>(this.size()));
		for (java.util.Map.Entry<K, V> entry : entrySet()) {
			Product2<? extends NK,? extends NV> t = f.apply(entry.getKey(), entry.getValue());
			ret.put(t.get1(), t.get2());
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


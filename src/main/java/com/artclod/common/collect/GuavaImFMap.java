package com.artclod.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.artclod.common.base.T2;
import com.artclod.common.collect.base.BaseFMap;
import com.artclod.common.collect.base.UnsupportMutationMapMixIn;
import com.artclod.common.collect.builder.GuavaImFMapBuilder;
import com.google.common.collect.ImmutableMap;

public class GuavaImFMap<K, V> extends BaseFMap<K, V, GuavaImFMap<K,V>> implements ImFMap<K, V>, UnsupportMutationMapMixIn<K, V> {
	private static final long serialVersionUID = 1L;

	public static <K, V> GuavaImFMap<K, V> wrap(ImmutableMap<K, V> inner) {
		return new GuavaImFMap<>(inner);
	}
	
	public static <K, V> GuavaImFMap<K, V> create() {
		return new GuavaImFMap<>(ImmutableMap.of());
	}

	public static <K, V> GuavaImFMap<K, V> create(K k1, V v1) {
		return new GuavaImFMap<>(ImmutableMap.of(k1, v1));
	}

	public static <K, V> GuavaImFMap<K, V> create(K k1, V v1, K k2, V v2) {
		return new GuavaImFMap<>(ImmutableMap.of(k1, v1, k2, v2));
	}

	public static <K, V> GuavaImFMap<K, V> create(K k1, V v1, K k2, V v2, K k3, V v3) {
		return new GuavaImFMap<>(ImmutableMap.of(k1, v1, k2, v2, k3, v3));
	}
	
	public static <K, V> GuavaImFMap<K, V> create(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
		return new GuavaImFMap<>(ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4));
	}

	public static <K, V> GuavaImFMap<K, V> create(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
		return new GuavaImFMap<>(ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5));
	}

	@SafeVarargs
	public static <K, V> GuavaImFMap<K, V> create(Map.Entry<K, V>... c) {
		return create(Arrays.asList(c));
	}
	
	public static <K, V> GuavaImFMap<K, V> create(Collection<? extends Map.Entry<K, V>> c) {
		ImmutableMap<K, V> build = toMap(c);
		return new GuavaImFMap<>(build);
	}

	private static <V, K> ImmutableMap<K, V> toMap(Collection<? extends Map.Entry<K, V>> c) {
		ImmutableMap.Builder<K, V> inner = ImmutableMap.builder();
		for (java.util.Map.Entry<K, V> entry : c) {
			inner.put(entry.getKey(), entry.getValue());
		}
		ImmutableMap<K, V> build = inner.build();
		return build;
	}

	public static <K, V> GuavaImFMap<K, V> create(Map<K, V> map) {
		return new GuavaImFMap<>(map);
	}
	
	public static <K, V> GuavaImFMap<K, V> create(ImmutableMap.Builder<K, V> builder) {
		return new GuavaImFMap<>(builder);
	}
	
	public GuavaImFMap() {
		this(ImmutableMap.of());
	}
	
	@SafeVarargs
	public GuavaImFMap(Map.Entry<K, V>... c) {
		this(Arrays.asList(c));
	}
	
	public GuavaImFMap(Collection<? extends Map.Entry<K, V>> c) {
		this(toMap(c));
	}
	
	public GuavaImFMap(Map<K, V> map) {
		this(ImmutableMap.copyOf(map));
	}
	
	public GuavaImFMap(ImmutableMap.Builder<K, V> builder) {
		this(builder.build());
	}
	
	protected GuavaImFMap(ImmutableMap<K, V> inner) {
		super(inner);
	}
	
	@Override
	public <NK, NV> GuavaImFMap<NK, NV> map(BiFunction<? super K, ? super V, T2<? extends NK, ? extends NV>> f) {
		ImmutableMap.Builder<NK, NV> builder = ImmutableMap.<NK, NV> builder();
		for (Map.Entry<K, V> entry : entrySet()) {
			T2<? extends NK,? extends NV> t = f.apply(entry.getKey(), entry.getValue());
			builder.put(t._1, t._2);
		}
		return new GuavaImFMap<>(builder.build());
	}

	@Override
	public <NV> GuavaImFMap<K, NV> mapValues(Function<? super V, ? extends NV> f) {
		ImmutableMap.Builder<K, NV> builder = ImmutableMap.<K, NV> builder();
		for (Map.Entry<K, V> entry : entrySet()) {
			builder.put(entry.getKey(), f.apply(entry.getValue()));
		}
		return new GuavaImFMap<>(builder.build());
	}

	@Override
	protected GuavaImFMapBuilder<K, V> builder() {
		return new GuavaImFMapBuilder<K, V> (ImmutableMap.<K, V> builder());
	}

	@Override
	protected GuavaImFMapBuilder<K, V> builder(Map<K, V> m) {
		return new GuavaImFMapBuilder<K, V> (ImmutableMap.<K, V> builder().putAll(m));
	}
}

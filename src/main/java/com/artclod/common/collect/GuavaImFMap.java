package com.artclod.common.collect;

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

	public GuavaImFMap(ImmutableMap<K, V> inner) {
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

}

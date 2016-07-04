package com.artclod.common.collect;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.artclod.common.base.T2;
import com.artclod.common.collect.base.BaseFMap;
import com.artclod.common.collect.base.UnsupportMutationMapMixIn;
import com.artclod.common.collect.builder.MapBuilder;
import com.google.common.collect.ImmutableMap;

public class GuavaImFMap<K, V> extends BaseFMap<K, V, FMap<K,V>> implements ImFMap<K, V>, UnsupportMutationMapMixIn<K, V>, Serializable {
	private static final long serialVersionUID = 1L;

	public GuavaImFMap(ImmutableMap<K, V> inner) {
		super(inner);
	}

	@Override
	public <NK, NV> FMap<NK, NV> map(BiFunction<? super K, ? super V, T2<? extends NK, ? extends NV>> f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <NV> FMap<K, NV> mapValues(Function<? super V, ? extends NV> f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MapBuilder<K, V, FMap<K, V>> builder() {
		// TODO Auto-generated method stub
		return null;
	}

}

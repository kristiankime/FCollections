package com.artclod.common.collect;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import com.artclod.common.base.T2;

public interface ImFMap<K,V> extends ViewFMap<K, V> {

	public <NK, NV> ImFMap<NK, NV> map(BiFunction<? super K, ? super V, T2<? extends NK, ? extends NV>> f);	
	
	public <NV> ImFMap<K, NV> mapValues(Function<? super V, ? extends NV> f);	
	
	public ImFMap<K, V> filter(BiPredicate<? super K, ? super V> filter);

	public ImFMap<K, V> filterKeys(Predicate<? super K> filter);
	
}

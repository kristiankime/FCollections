package com.artclod.common.collect;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import com.artclod.common.base.Product2;

public interface ImFMap<K,V> extends ViewFMap<K, V> {

	public <NK, NV> ImFMap<NK, NV> map(BiFunction<? super K, ? super V, Product2<? extends NK, ? extends NV>> f);	
	
	public <NV> ImFMap<K, NV> mapValues(Function<? super V, ? extends NV> f);	
	
	public ImFMap<K, V> filter(BiPredicate<? super K, ? super V> filter);

	public ImFMap<K, V> filterKeys(Predicate<? super K> filter);
	
	public ImFMap<K, V> putCp(Map.Entry<K, V> entry);

	public ImFMap<K, V> putCp(K key, V value);
	
	public ImFMap<K, V> putAllCp(Map<? extends K, ? extends V> m);
}

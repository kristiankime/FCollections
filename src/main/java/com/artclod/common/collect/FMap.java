package com.artclod.common.collect;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import com.artclod.common.base.T2;

public interface FMap<K, V> extends Map<K, V> {

	public boolean nonEmpty();
	
	public ViewFSet<K> keySet();
	
	public ViewFCollection<V> values();
	
	public ViewFSet<Map.Entry<K, V>> entrySet();

	public <NK, NV> FMap<NK, NV> map(BiFunction<? super K, ? super V, T2<? extends NK, ? extends NV>> f);	
	
	public <NV> FMap<K, NV> mapValues(Function<? super V, ? extends NV> f);	
	
	public FMap<K, V> filter(BiPredicate<? super K, ? super V> filter);

	public FMap<K, V> filterKeys(Predicate<? super K> filter);

	public default V put(Map.Entry<K, V> entry) {
		return this.put(entry.getKey(), entry.getValue());
	}
	
}

package com.artclod.common.collect;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.artclod.common.base.Product2;
import com.artclod.common.collect.base.Option;

public interface FMap<K, V> extends Map<K, V> {

	public boolean nonEmpty();
	
	public ViewFSet<K> keySet();
	
	public ViewFCollection<V> values();
	
	public ViewFSet<Map.Entry<K, V>> entrySet();

	public <NK, NV> FMap<NK, NV> map(BiFunction<? super K, ? super V, Product2<? extends NK, ? extends NV>> f);	
	
	public <NV> FMap<K, NV> mapValues(Function<? super V, ? extends NV> f);	
	
	public FMap<K, V> filter(BiPredicate<? super K, ? super V> filter);

	public FMap<K, V> filterKeys(Predicate<? super K> filter);

	public default V put(Map.Entry<K, V> entry) {
		return this.put(entry.getKey(), entry.getValue());
	}
	
	public FMap<K, V> putCp(Map.Entry<K, V> entry);

	public FMap<K, V> putCp(K key, V value);
	
	public FMap<K, V> putAllCp(Map<? extends K, ? extends V> m);
	
	public ImFMap<K, V> toIm();
	
	public default Option<V> getOp(K key) {
		return Option.of(get(key));
	}
	
	public default Option<V> putOp(K key, Option<V> value) {
		if(value.isEmpty()) {
			return Option.of(remove(key));
		}
		return Option.of(put(key, value.get()));
	}
	
	public default V getOrElse(K key, Supplier<? extends V> supplier) {
		V v = get(key);
		if(v == null) {
			return supplier.get();
		}
		return v;
	}
	
}

package com.artclod.common.collect;

import java.util.Collection;
import java.util.function.Function;

public interface ImFSet<E> extends ViewFSet<E>, ImFCollection<E> {
	
	public <K> ImFMap<K, FCollection<E>> groupBy(Function<? super E, ? extends K> f);
	public <K> ImFMap<K, FSet<E>> groupByS(Function<? super E, ? extends K> f);
	public <K> ImFMap<K, ImFSet<E>> groupByIS(Function<? super E, ? extends K> f);
	
	public ImFSet<E> addCp(E e);
	public ImFSet<E> addAllCp(Collection<? extends E> c);
	public ImFSet<E> removeCp(Object o);
	public ImFSet<E> removeAllCp(Collection<?> c);
	public ImFSet<E> retainAllCp(Collection<?> c);
	
}

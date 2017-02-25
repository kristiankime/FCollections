package com.artclod.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public interface ImFSet<E> extends ViewFSet<E>, ImFCollection<E> {
	
	public ImFSet<E> filter(Predicate<? super E> filter);
	public ImFSet<E> filterNot(Predicate<? super E> filter);

	public <O> ImFSet<O> map(Function<? super E, ? extends O> f);
	public <O> ImFSet<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);
	
	public <K> ImFMap<K, FCollection<E>> groupBy(Function<? super E, ? extends K> f);
	public <K> ImFMap<K, FSet<E>> groupByS(Function<? super E, ? extends K> f);
	public <K> ImFMap<K, ImFSet<E>> groupByIS(Function<? super E, ? extends K> f);
	
	public ImFSet<E> cp();
	public ImFSet<E> addCp(E e);
	public ImFSet<E> addAllCp(Collection<? extends E> c);
	public ImFSet<E> removeCp(Object o);
	public ImFSet<E> removeAllCp(Collection<?> c);
	public ImFSet<E> retainAllCp(Collection<?> c);
	
	public ImFSet<E> union(Set<E> s);
	public ImFSet<E> intersection(Set<E> s);
	
}

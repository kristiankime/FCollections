package com.artclod.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FSet<E> extends Set<E>, FCollection<E> {

	public FSet<E> filter(Predicate<? super E> filter);
	public FSet<E> filterNot(Predicate<? super E> filter);

	public <O> FSet<O> map(Function<? super E, ? extends O> f);
	public <O> FSet<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);

	public FSet<E> cp();
	public FSet<E> addCp(E e);
	public FSet<E> addAllCp(Collection<? extends E> c);
	public FSet<E> removeCp(Object o);
	public FSet<E> removeAllCp(Collection<?> c);
	public FSet<E> retainAllCp(Collection<?> c);
	
	public <K> FMap<K, FSet<E>> groupByS(Function<? super E, ? extends K> f);

	public ImFSet<E> toIm();
	public FSet<E> toMu();
	
	public FSet<E> union(Set<E> s);
	
	public FSet<E> intersection(Set<E> s);
	
}

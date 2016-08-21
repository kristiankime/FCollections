package com.artclod.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface ImFList<E> extends ViewFList<E>, ImFCollection<E> {	

	public ImFList<E> filter(Predicate<? super E> filter);
	public ImFList<E> filterNot(Predicate<? super E> filter);

	public <O> ImFList<O> map(Function<? super E, ? extends O> f);
	public <O> ImFList<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);
	
	public <K> ImFMap<K, FCollection<E>> groupBy(Function<? super E, ? extends K> f);
	public <K> ImFMap<K, FList<E>> groupByL(Function<? super E, ? extends K> f);
	public <K> ImFMap<K, ImFList<E>> groupByIL(Function<? super E, ? extends K> f);

	public ImFList<E> cp();
	public ImFList<E> addCp(E e);
	public ImFList<E> removeCp(Object o);
	public ImFList<E> addAllCp(Collection<? extends E> c);
	public ImFList<E> addAllCp(int index, Collection<? extends E> c);
	public ImFList<E> removeAllCp(Collection<?> c);
	public ImFList<E> retainAllCp(Collection<?> c);
	public ImFList<E> replaceAllCp(UnaryOperator<E> operator);
	public ImFList<E> setCp(int index, E element);
	public ImFList<E> addCp(int index, E element);
	public ImFList<E> removeCp(int index);
	public ImFList<E> removeIfCp(Predicate<? super E> filter);	

	public ImFList<E> sortWith(Comparator<? super E> c);
	public ImFList<E> sorted();
	public ImFList<E> sortWithCp(Comparator<? super E> c);
    public ImFList<E> sortedCp();
    
	
	public FList<E> toMu();
	

}

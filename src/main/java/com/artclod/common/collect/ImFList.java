package com.artclod.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface ImFList<E> extends ViewFList<E>, ImFCollection<E> {	

	public ImFList<E> addCp(E e);
	public ImFList<E> removeCp(Object o);
	public ImFList<E> addAllCp(Collection<? extends E> c);
	public ImFList<E> addAllCp(int index, Collection<? extends E> c);
	public ImFList<E> removeAllCp(Collection<?> c);
	public ImFList<E> retainAllCp(Collection<?> c);
	public ImFList<E> replaceAllCp(UnaryOperator<E> operator);
	public ImFList<E> sortCp(Comparator<? super E> c);
	public ImFList<E> setCp(int index, E element);
	public ImFList<E> addCp(int index, E element);
	public ImFList<E> removeCp(int index);
	public ImFList<E> removeIfCp(Predicate<? super E> filter);	

	public FList<E> toMu();

}

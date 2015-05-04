package com.artclod.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface ImFList<E> extends FList<E> {

	// ==== Copy modifiers ====

	ImFList<E> addCp(E e);

	ImFList<E> removeCp(Object o);

	ImFList<E> addAllCp(Collection<? extends E> c);

	ImFList<E> addAllCp(int index, Collection<? extends E> c);

	ImFList<E> removeAllCp(Collection<?> c);

	ImFList<E> retainAllCp(Collection<?> c);

	ImFList<E> replaceAllCp(UnaryOperator<E> operator);

	ImFList<E> sortCp(Comparator<? super E> c);

	ImFList<E> setCp(int index, E element);

	ImFList<E> addCp(int index, E element);

	ImFList<E> removeCp(int index);

	ImFList<E> removeIfCp(Predicate<? super E> filter);
	
	// ==== Unsupported modifiers ====
	
	@Deprecated
	boolean add(E e);

	@Deprecated
	boolean remove(Object o);

	@Deprecated
	boolean addAll(Collection<? extends E> c);

	@Deprecated
	boolean addAll(int index, Collection<? extends E> c);

	@Deprecated
	boolean removeAll(Collection<?> c);

	@Deprecated
	boolean retainAll(Collection<?> c);

	@Deprecated
	void replaceAll(UnaryOperator<E> operator);

	@Deprecated
	void sort(Comparator<? super E> c);

	@Deprecated
	void clear();

	@Deprecated
	E set(int index, E element);

	@Deprecated
	void add(int index, E element);

	@Deprecated
	E remove(int index);

	@Deprecated
	boolean removeIf(Predicate<? super E> filter);

}

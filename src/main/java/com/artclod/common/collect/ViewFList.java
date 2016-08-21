package com.artclod.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.UnaryOperator;

public interface ViewFList<E> extends FList<E>, ViewFCollection<E> {

	@Deprecated
	public boolean addAll(int index, Collection<? extends E> c);

	@Deprecated
	public void replaceAll(UnaryOperator<E> operator);

	@Deprecated
	public void sort(Comparator<? super E> c);

	@Deprecated
	public void clear();

	@Deprecated
	public E set(int index, E element);

	@Deprecated
	public void add(int index, E element);

	@Deprecated
	public E remove(int index);

	@Deprecated
	public FList<E> sortWith(Comparator<? super E> c);
	
	@Deprecated
	public FList<E> sorted();
}

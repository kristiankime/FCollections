package com.artclod.common.collect;

import java.util.Collection;

public interface ImFSet<E> extends ViewFSet<E>, ImFCollection<E> {

	public ImFSet<E> addCp(E e);
	public ImFSet<E> addAllCp(Collection<? extends E> c);
	public ImFSet<E> removeCp(Object o);
	public ImFSet<E> removeAllCp(Collection<?> c);
	public ImFSet<E> retainAllCp(Collection<?> c);
	
}

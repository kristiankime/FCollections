package com.artclod.common.collect;

import java.util.Collection;

public interface ImFCollection<E> extends ViewFCollection<E> {

	public ImFCollection<E> addCp(E e);
	
	public ImFCollection<E> addAllCp(Collection<? extends E> c);
	
	public ImFCollection<E> removeCp(Object o);
	
	public ImFCollection<E> removeAllCp(Collection<?> c);
	
	public ImFCollection<E> retainAllCp(Collection<?> c);
		
}

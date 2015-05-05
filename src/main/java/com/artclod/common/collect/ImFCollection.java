package com.artclod.common.collect;

import java.util.Collection;
import java.util.function.Predicate;

public interface ImFCollection<E> extends FCollection<E> {

	public boolean addCp(E e);
	
	public boolean addAllCp(Collection<? extends E> c);
	
	public boolean removeCp(Object o);
	
	public boolean removeAllCp(Collection<?> c);
	
	public boolean retainAllCp(Collection<?> c);
		
	// ==== Unsupported modifiers ====
	
	@Deprecated
	@Override
	public boolean add(E e);
	
	@Deprecated
	@Override
	public boolean addAll(Collection<? extends E> c);
	
	@Deprecated
	@Override
	public boolean remove(Object o);
	
	@Deprecated
	@Override
	public boolean removeAll(Collection<?> c);
	
	@Deprecated
	@Override
	public boolean removeIf(Predicate<? super E> filter);

	@Deprecated
	@Override
	public boolean retainAll(Collection<?> c);
	
	@Deprecated
	@Override
	public void clear();
	
}

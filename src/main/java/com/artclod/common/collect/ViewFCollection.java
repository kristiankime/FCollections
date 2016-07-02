package com.artclod.common.collect;

import java.util.Collection;
import java.util.function.Predicate;

public interface ViewFCollection<E> extends FCollection<E> {

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

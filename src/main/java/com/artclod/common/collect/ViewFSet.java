package com.artclod.common.collect;

import java.util.Collection;

public interface ViewFSet<E> extends FSet<E>, ViewFCollection<E> {

	@Deprecated
    boolean add(E e);

	@Deprecated
    boolean remove(Object o);

	@Deprecated
    boolean containsAll(Collection<?> c);

	@Deprecated
    boolean addAll(Collection<? extends E> c);

	@Deprecated
    boolean retainAll(Collection<?> c);

	@Deprecated
    boolean removeAll(Collection<?> c);
	
	@Deprecated
    void clear();

}

package com.artclod.common.collect;

import java.util.Collection;
import java.util.function.Predicate;

public interface ViewFSet<E> extends FSet<E>, ViewFCollection<E> {

	@Deprecated
    boolean add(E e);

	@Deprecated
    boolean addAll(Collection<? extends E> c);

	@Deprecated
    boolean remove(Object o);

	@Deprecated
    boolean removeAll(Collection<?> c);

	@Deprecated
	boolean removeIf(Predicate<? super E> filter);

	@Deprecated
    boolean retainAll(Collection<?> c);
	
	@Deprecated
    void clear();

}

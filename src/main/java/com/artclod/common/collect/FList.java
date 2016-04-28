package com.artclod.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.google.common.collect.Ordering;

public interface FList<E> extends List<E>, FCollection<E> {

	public ImFList<E> toIm();
	
	public FList<E> filter(Predicate<? super E> filter);

	public FList<E> filterNot(Predicate<? super E> filter);

	public <O> FList<O> map(Function<? super E, ? extends O> f);

	public <O> FList<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);

	public String mkString(String sep);

	public String mkString(String start, String sep, String end);
	
	/**
	 * This is the same as {@link java.util.List#sort(Comparator)} but it returns the list.
	 * 
	 * @param c the comparator that should be used
	 * @return the current list
	 */
	public default FList<E> sortBy(Comparator<? super E> c) {
	    List.super.sort(c);
	    return this;
	}
	
	/**
	 * This method assumes the elements of the list are comparable and uses the "natural" comparator to sort them.
	 * Note that it is up to the user of this method to ensure the elements implement {@link java.lang.Comparable} no compile time guarantee is ensured.
	 * 
     * @return the current list (which will be sorted)
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    default FList<E> sort() {
        Ordering natural = Ordering.natural();
        return sortBy(natural);
    }
}

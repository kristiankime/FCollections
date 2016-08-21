package com.artclod.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface FList<E> extends List<E>, FCollection<E> {

	public FList<E> filter(Predicate<? super E> filter);
	public FList<E> filterNot(Predicate<? super E> filter);

	public <O> FList<O> map(Function<? super E, ? extends O> f);
	public <O> FList<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);
    
	public FList<E> cp();
	public FList<E> addCp(E e);
	public FList<E> addAllCp(Collection<? extends E> c);
	public FList<E> addAllCp(int index, Collection<? extends E> c);
	public FList<E> removeCp(Object o);
	public FList<E> removeAllCp(Collection<?> c);
	public FList<E> retainAllCp(Collection<?> c);
	public FList<E> replaceAllCp(UnaryOperator<E> operator);
	
	public <K> FMap<K, FList<E>> groupByL(Function<? super E, ? extends K> f);

	public ImFList<E> toIm();

	/**
	 * This is the same as {@link java.util.List#sort(Comparator)} but it returns the list.
	 * 
	 * @param c the comparator that should be used
	 * @return the current list
	 */
	public  FList<E> sortWith(Comparator<? super E> c);
	
	/**
	 * This method assumes the elements of the list are comparable and uses the "natural" comparator to sort them.
	 * Note that it is up to the user of this method to ensure the elements implement {@link java.lang.Comparable} no compile time guarantee is ensured.
	 * 
     * @return the current list (which will be sorted)
	 */
    public FList<E> sorted();
	
    
	/**
	 * This is similar to {@link java.util.List#sort(Comparator)} but it creates a copy, then sorts and returns the list.
	 * 
	 * @param c the comparator that should be used
	 * @return the current list
	 */
	public  FList<E> sortWithCp(Comparator<? super E> c);
	
	/**
	 * This method creates a copy and sorts and returns that copy.
	 * This method assumes the elements of the list are comparable and uses the "natural" comparator to sort them.
	 * Note that it is up to the user of this method to ensure the elements implement {@link java.lang.Comparable} no compile time guarantee is ensured.
	 * 
     * @return the current list (which will be sorted)
	 */
    public FList<E> sortedCp();
    
}

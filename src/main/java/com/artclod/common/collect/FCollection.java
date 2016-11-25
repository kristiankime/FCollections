package com.artclod.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This interface is an extension of the {@link Collection} interface that adds many functional style methods.
 * Most of these methods are based on the {@link java.util.stream.Stream} interface and have similar if not identical signatures.
 * There are additional methods and these are often based on scala methods with similar intents.
 *
 * @param <E> the type of the collection elements
 */
public interface FCollection<E> extends Collection<E> {

    /**
     * Returns whether all elements of this collection match the provided predicate.
     * May not evaluate the predicate on all elements if not necessary for
     * determining the result.  If the collection is empty then {@code true} is
     * returned and the predicate is not evaluated.
     *
     * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> predicate to apply to elements of this collection
     * @return {@code true} if either all elements of the collection match the provided predicate or the collection is empty, otherwise {@code false}
     */
	public default boolean allMatch(Predicate<? super E> predicate) {
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			E e = iterator.next();
			if(!predicate.test(e)) {
				return false;
			}
		}
		return true;
	}
	
    /**
     * Returns whether any elements of this collection match the provided
     * predicate.  May not evaluate the predicate on all elements if not
     * necessary for determining the result.  If the collection is empty then
     * {@code false} is returned and the predicate is not evaluated.
     *
     * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> predicate to apply to elements of this collection
     * @return {@code true} if any elements of the collection match the provided predicate, otherwise {@code false}
     */
	public default boolean anyMatch(Predicate<? super E> predicate) {
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			E e = iterator.next();
			if(predicate.test(e)) {
				return true;
			}
		}
		return false;
	}
	
    /**
     * Returns whether no elements of this collection match the provided predicate.
     * May not evaluate the predicate on all elements if not necessary for
     * determining the result.  If the collection is empty then {@code true} is
     * returned and the predicate is not evaluated.
     *
     *
     * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> predicate to apply to elements of this collection
     * @return {@code true} if either no elements of the collection match the provided predicate or the collection is empty, otherwise {@code false}
     */
	public default boolean noneMatch(Predicate<? super E> predicate) {
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			E e = iterator.next();
			if(predicate.test(e)) {
				return false;
			}
		}
		return true;
	}
	
    /**
     * Returns a new collection consisting of the elements of this collection that match
     * the given predicate. Subtypes should type the return to be the same
     * as the given subclass.
     *
     * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> predicate to apply to each element to determine if it should be included
     * @return the new collection
     */
	public FCollection<E> filter(Predicate<? super E> predicate);
	
	/**
	 * See {@link #filter(Predicate)} except the predicate is negated.
	 * 
     * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> predicate to apply to each element to determine if it should be included
     * @return the new collection
	 */
	public FCollection<E> filterNot(Predicate<? super E> predicate);

    /**
     * Returns a new collection consisting of the results of applying the given
     * function to the elements of this collection. Subtypes should type the return 
     * to be the same as the given subclass.
     *
     * @param <O> The element type of the new collection
     * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> function to apply to each element
     * @return the new collection
     */
	public <O> FCollection<O> map(Function<? super E, ? extends O> mapper);
	
    /**
     * Returns a collection consisting of the results of replacing each element of
     * this collection with the contents of a mapped collection produced by applying
     * the provided mapping function to each element.
     *
     * <p><b>Example.</b>
     *
     * <p>If {@code orders} is a collection of purchase orders, and each purchase
     * order contains a collection of line items, then the following produces a
     * collection containing all the line items in all the orders:
     * <pre>{@code
     *     orders.flatMap(order -> order.getLineItems())...
     * }</pre>
     *
     * @param <O> The element type of the new collection
     * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> function to apply to each element which produces a collection of new values
     * @return the new collection
     */
	public <O> FCollection<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);

	/**
	 * This function returns a shallow copy of current collection.
	 * 
	 * @return a shallow copy of the collection
	 */
	public FCollection<E> cp();
	
	/**
	 * This function is equivalent to making a copy of the current collection
	 * and then calling {@link #add}.
	 * 
	 * @param e element to add
	 * @return the new collection
	 */
	public FCollection<E> addCp(E e);
	
	/**
	 * This function is equivalent to making a copy of the current collection
	 * and then calling {@link #addAll}.
	 * 
	 * @param c the collection of elements to add
	 * @return the new collection
	 */
	public FCollection<E> addAllCp(Collection<? extends E> c);
	
	/**
	 * This function is equivalent to making a copy of the current collection
	 * and then calling {@link #remove}.
	 * 
	 * @param o the object to remove
	 * @return the new collection
	 */
	public FCollection<E> removeCp(Object o);
	
	/**
	 * This function is equivalent to making a copy of the current collection
	 * and then calling {@link #removeAll}.
	 * 
	 * @param c the collection of elements to remove
	 * @return the new collection
	 */
	public FCollection<E> removeAllCp(Collection<?> c);
	
	/**
	 * This function is equivalent to making a copy of the current collection
	 * and then calling {@link #retainAll}.
	 * 
	 * @param c the collection of elements to retain
	 * @return the new collection
	 */
	public FCollection<E> retainAllCp(Collection<?> c);
	
	/**
	 * Checks to see if the collection is not empty.
	 * 
	 * @return indicates if the collection is not empty
	 */
	public default boolean nonEmpty() { return !isEmpty(); }

	/**
	 * Displays all elements of this mutable indexed sequence in a string.
	 * 
	 * @return a string representation of this mutable indexed sequence. In the resulting string the string representations (w.r.t. the method toString) of all elements of this mutable indexed sequence follow each other without any separator string.
	 */
	public default String mkString() { return mkString("", "", ""); }
	
	/**
	 * Displays all elements of this mutable indexed sequence in a string using a separator string.
	 * 
	 * @param sep the separator string
	 * @return a string representation of this mutable indexed sequence. In the resulting string the string representations (w.r.t. the method toString) of all elements of this mutable indexed sequence follow each other without any separator string.
	 */
	public default String mkString(String sep) { return mkString("", sep, ""); }
	
	/**
	 * 
	 * @param start the starting string
	 * @param sep the separator string
	 * @param end the ending string
	 * @return a string representation of this mutable indexed sequence. The resulting string begins with the string start and ends with the string end. Inside, the string representations (w.r.t. the method toString) of all elements of this mutable indexed sequence are separated by the string sep.
	 */
	public default String mkString(String start, String sep, String end) {
		StringBuilder ret = new StringBuilder(start);
		Iterator<E> iterator = iterator();
		boolean first = true;
		while (iterator.hasNext()) {
			E e = iterator.next();
			if (first) {
				ret.append(e);
				first = false;
			} else {
				ret.append(sep).append(e);
			}
		}
		return ret.append(end).toString();
	}

    /**
     * Performs a <a href="package-summary.html#Reduction">reduction</a> on the
     * elements of this collection, using an
     * <a href="package-summary.html#Associativity">associative</a> accumulation
     * function, and returns an {@code Optional} describing the reduced value,
     * if any. This is equivalent to:
     * <pre>{@code
     *     boolean foundAny = false;
     *     T result = null;
     *     for (T element : this collection) {
     *         if (!foundAny) {
     *             foundAny = true;
     *             result = element;
     *         }
     *         else
     *             result = accumulator.apply(result, element);
     *     }
     *     return foundAny ? Optional.of(result) : Optional.empty();
     * }</pre>
     *
     * but is not constrained to execute sequentially.
     *
     * <p>The {@code accumulator} function must be an
     * <a href="package-summary.html#Associativity">associative</a> function.
     *
     * @param accumulator an <a href="package-summary.html#Associativity">associative</a>, <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> function for combining two values
     * @return an {@link Optional} describing the result of the reduction
     * @throws NullPointerException if the result of the reduction is null
     * @see #reduce(Object, BinaryOperator)
     * @see #min(Comparator)
     * @see #max(Comparator)
     */
	public Optional<E> reduce(BinaryOperator<E> accumulator);
	
	/**
	 * see {@link #reduce(BinaryOperator)} except when possible the operations will be done left to right.
	 * @param accumulator an <a href="package-summary.html#Associativity">associative</a>, <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> function for combining two values
	 * @return an {@link Optional} describing the result of the reduction
	 */
	public Optional<E> reduceLeft(BinaryOperator<E> accumulator);
	
	/**
	 * see {@link #reduce(BinaryOperator)} except when possible the operations will be done right to left.
	 * @param accumulator an <a href="package-summary.html#Associativity">associative</a>, <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> function for combining two values
	 * @return an {@link Optional} describing the result of the reduction
	 */
	public Optional<E> reduceRight(BinaryOperator<E> accumulator);
	
    /**
     * Performs a <a href="package-summary.html#Reduction">reduction</a> on the
     * elements of this collection, using the provided identity value and an
     * <a href="package-summary.html#Associativity">associative</a>
     * accumulation function, and returns the reduced value.  This is equivalent
     * to:
     * <pre>{@code
     *     T result = identity;
     *     for (T element : this collection)
     *         result = accumulator.apply(result, element)
     *     return result;
     * }</pre>
     *
     * but is not constrained to execute sequentially.
     *
     * <p>The {@code identity} value must be an identity for the accumulator
     * function. This means that for all {@code t},
     * {@code accumulator.apply(identity, t)} is equal to {@code t}.
     * The {@code accumulator} function must be an
     * <a href="package-summary.html#Associativity">associative</a> function.
     *
     * Sum, min, max, average, and string concatenation are all special
     * cases of reduction. Summing a collection of numbers can be expressed as:
     *
     * <pre>{@code
     *     Integer sum = integers.reduce(0, (a, b) -> a+b);
     * }</pre>
     *
     * or:
     *
     * <pre>{@code
     *     Integer sum = integers.reduce(0, Integer::sum);
     * }</pre>
     *
     * <p>While this may seem a more roundabout way to perform an aggregation
     * compared to simply mutating a running total in a loop, reduction
     * operations parallelize more gracefully, without needing additional
     * synchronization and with greatly reduced risk of data races.
     *
     * @param identity the identity value for the accumulating function
     * @param accumulator an <a href="package-summary.html#Associativity">associative</a>, <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> function for combining two values
     * @return the result of the reduction
     */
	public E reduce(E identity, BinaryOperator<E> accumulator);
	
	/**
	 * See {@link #reduce(Object, BinaryOperator)} except when possible the operations will be done left to right.
	 * 
     * @param identity the identity value for the accumulating function
     * @param accumulator an <a href="package-summary.html#Associativity">associative</a>, <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> function for combining two values
     * @return the result of the reduction
	 */
	public E reduceLeft(E identity, BinaryOperator<E> accumulator);

	/**
	 * See {@link #reduce(Object, BinaryOperator)} except when possible the operations will be done right to left.
	 * 
     * @param identity the identity value for the accumulating function
     * @param accumulator an <a href="package-summary.html#Associativity">associative</a>, <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> function for combining two values
     * @return the result of the reduction
	 */
	public E reduceRight(E identity, BinaryOperator<E> accumulator);

	/**
	 * Partitions the elements in this collection into a map of collections according to some discriminator function.
	 * In other words all of the elements of the current will be grouped together based on the keys provided by the function.
	 * 
	 * Note because of the limitations of generics in Java sub types will often have methods like  {@link com.artclod.common.collect.FList#groupByL(Function)} 
	 * which type the values in the returned map to more specific types.
	 * 
	 * @param f the discriminator function. Its result will be used to determine which elements go into each group.
	 * @param <K> The type of the key in the group map, ie the type of the objects that be used to group elements
	 * @return the partion map
	 */
	public <K> FMap<K, FCollection<E>> groupBy(Function<? super E, ? extends K> f);
	
    /**
     * Returns the minimum element of this collection according to the provided
     * {@code Comparator}.  This is a special case of a
     * <a href="package-summary.html#Reduction">reduction</a>.
     *
     * @param comparator a <a href="package-summary.html#NonInterference">non-interfering</a>,  <a href="package-summary.html#Statelessness">stateless</a> {@code Comparator} to compare elements of this collection
     * @return an {@code Optional} describing the minimum element of this collection,
     * or an empty {@code Optional} if the collection is empty
     * @throws NullPointerException if the minimum element is null
     */
	public default Optional<E> min(Comparator<? super E> comparator) {
        return reduce(BinaryOperator.minBy(comparator));
    }

    /**
     * Returns the maximum element of this collection according to the provided
     * {@code Comparator}.  This is a special case of a
     * <a href="package-summary.html#Reduction">reduction</a>.
     *
     * @param comparator a <a href="package-summary.html#NonInterference">non-interfering</a>, <a href="package-summary.html#Statelessness">stateless</a> {@code Comparator} to compare elements of this collection
     * @return an {@code Optional} describing the maximum element of this collection,
     * or an empty {@code Optional} if the collection is empty
     * @throws NullPointerException if the maximum element is null
     */
	public default Optional<E> max(Comparator<? super E> comparator) {
        return reduce(BinaryOperator.maxBy(comparator));
    }
    
	/**
	 * Converts this collection to an {@code FList}. If the Collection is already an {@code FList} the current Collection is returned.
	 * 
	 * @return An {@code FList} version of the collection. 
	 */
	public default FList<E> toList() {
    	return ArrayFList.create(this);
    }
	
	/**
	 * Copies this collection to an {@code FList}.
	 * 
	 * @return A copy of this collection as an {@code FList}. 
	 */
	public default FList<E> copyToList() {
    	return ArrayFList.create(this);
    }
	
	/**
	 * Converts this collection to an {@code ImFList}.
	 * 
	 * @return An {@code ImFList} version of the collection. 
	 */
	public default ImFList<E> toImList() {
    	return GuavaImFList.create(this);
    }
    
	/**
	 * Converts this collection to an {@code FSet}. If the Collection is already an {@code FSet} the current Collection is returned.
	 * 
	 * @return An {@code FSet} version of the collection. 
	 */
	public default FSet<E> toSet() {
    	return LinkedHashFSet.create(this);
    }
    
	/**
	 * Copies this collection to an {@code FSet}.
	 * 
	 * @return A copy of this collection as an {@code FSet}. 
	 */
	public default FSet<E> copyToSet() {
    	return LinkedHashFSet.create(this);
    }
	
	/**
	 * Converts this collection to an {@code ImFSet}.
	 * 
	 * @return An {@code FSet} version of the collection. 
	 */
	public default ImFSet<E> toImSet() {
    	return GuavaImFSet.create(this);
    }
}

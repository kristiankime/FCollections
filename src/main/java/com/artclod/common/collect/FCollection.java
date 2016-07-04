package com.artclod.common.collect;

import java.util.Collection;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FCollection<E> extends Collection<E> {

	public FCollection<E> filter(Predicate<? super E> filter);
	public FCollection<E> filterNot(Predicate<? super E> filter);

	public <O> FCollection<O> map(Function<? super E, ? extends O> f);
	public <O> FCollection<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);

	public FCollection<E> addCp(E e);
	public FCollection<E> addAllCp(Collection<? extends E> c);
	public FCollection<E> removeCp(Object o);
	public FCollection<E> removeAllCp(Collection<?> c);
	public FCollection<E> retainAllCp(Collection<?> c);
	
	public boolean nonEmpty();

	public String mkString(String sep);
	public String mkString(String start, String sep, String end);

	public Optional<E> reduce(BinaryOperator<E> accumulator);
	public Optional<E> reduceLeft(BinaryOperator<E> accumulator);
	public Optional<E> reduceRight(BinaryOperator<E> accumulator);
	
	public E reduce(E identity, BinaryOperator<E> accumulator);
	public E reduceLeft(E identity, BinaryOperator<E> accumulator);
	public E reduceRight(E identity, BinaryOperator<E> accumulator);
	
	public <O> O fold(O initial, BiFunction<O, E, O> f);
	public <O> O foldLeft(O initial, BiFunction<O, E, O> f);
	public <O> O foldRight(O initial, BiFunction<O, E, O> f);

	public <K> FMap<K, FCollection<E>> groupBy(Function<? super E, ? extends K> f);

}

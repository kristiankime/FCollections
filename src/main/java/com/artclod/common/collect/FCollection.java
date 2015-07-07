package com.artclod.common.collect;

import java.util.Collection;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FCollection<E> extends Collection<E> {

	public boolean nonEmpty();

	public FCollection<E> filter(Predicate<? super E> filter);
	public FCollection<E> filterNot(Predicate<? super E> filter);

	public <O> FCollection<O> map(Function<? super E, ? extends O> f);
	public <O> FCollection<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);

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

}

package com.artclod.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

import com.artclod.common.base.Function2;

public interface FList<E> extends List<E>, FCollection<E> {

	public ImFList<E> toIm();
	
	public boolean nonEmpty();

	public FList<E> filter(Predicate<? super E> filter);

	public FList<E> filterNot(Predicate<? super E> filter);

	public <O> FList<O> map(Function<? super E, ? extends O> f);

	public <O> FList<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);

	public String mkString(String sep);

	public String mkString(String start, String sep, String end);

	public E reduce(Function2<E, E, E> f);

	public E reduceLeft(Function2<E, E, E> f);

	public E reduceRight(Function2<E, E, E> f);

	public <O> O fold(O initial, Function2<O, E, O> f);

	public <O> O foldLeft(O initial, Function2<O, E, O> f);

	public <O> O foldRight(O initial, Function2<O, E, O> f);
	
}

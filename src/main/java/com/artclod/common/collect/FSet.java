package com.artclod.common.collect;

import java.util.Set;
import java.util.function.Predicate;

import com.artclod.common.base.Function2;
import com.google.common.base.Function;

public interface FSet<E> extends Set<E>, FCollection<E> {

	public boolean nonEmpty();

	public <O> FSet<O> map(Function<E, O> f);

	public FSet<E> filter(Predicate<? super E> filter);

	public FSet<E> filterNot(Predicate<? super E> filter);

	public String mkString(String sep);

	public String mkString(String start, String sep, String end);

	public E reduce(Function2<E, E, E> f);

	public E reduceLeft(Function2<E, E, E> f);

	public E reduceRight(Function2<E, E, E> f);

	public <O> O fold(O initial, Function2<O, E, O> f);

	public <O> O foldLeft(O initial, Function2<O, E, O> f);

	public <O> O foldRight(O initial, Function2<O, E, O> f);
	
}

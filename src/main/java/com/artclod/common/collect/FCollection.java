package com.artclod.common.collect;

import java.util.Collection;
import java.util.function.Predicate;

import com.artclod.common.base.Function2;
import com.google.common.base.Function;

public interface FCollection<E> extends Collection<E> {

	public boolean nonEmpty();

	public <O> FCollection<O> map(Function<E, O> f);

	public FCollection<E> filter(Predicate<? super E> filter);

	public FCollection<E> filterNot(Predicate<? super E> filter);

	public String mkString(String sep);

	public String mkString(String start, String sep, String end);

	public E reduce(Function2<E, E, E> f);

	public E reduceLeft(Function2<E, E, E> f);

	public E reduceRight(Function2<E, E, E> f);

	public <O> O fold(O initial, Function2<O, E, O> f);

	public <O> O foldLeft(O initial, Function2<O, E, O> f);

	public <O> O foldRight(O initial, Function2<O, E, O> f);

}

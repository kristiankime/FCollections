package com.artclod.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Function;

import com.artclod.common.base.Function2;

public interface FSet<E> extends Set<E>, FCollection<E> {

	public boolean nonEmpty();

	public FSet<E> filter(Predicate<? super E> filter);

	public FSet<E> filterNot(Predicate<? super E> filter);

	public <O> FSet<O> map(Function<? super E, ? extends O> f);

	public <O> FSet<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);

	public String mkString(String sep);

	public String mkString(String start, String sep, String end);

	public <O> O fold(O initial, Function2<O, E, O> f);

	public <O> O foldLeft(O initial, Function2<O, E, O> f);

	public <O> O foldRight(O initial, Function2<O, E, O> f);
	
}

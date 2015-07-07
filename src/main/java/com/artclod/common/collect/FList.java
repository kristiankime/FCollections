package com.artclod.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FList<E> extends List<E>, FCollection<E> {

	public ImFList<E> toIm();
	
	public boolean nonEmpty();

	public FList<E> filter(Predicate<? super E> filter);

	public FList<E> filterNot(Predicate<? super E> filter);

	public <O> FList<O> map(Function<? super E, ? extends O> f);

	public <O> FList<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper);

	public String mkString(String sep);

	public String mkString(String start, String sep, String end);
	
}

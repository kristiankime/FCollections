package com.artclod.common.collect;

import java.util.List;
import java.util.function.Predicate;

import com.artclod.common.base.Function2;
import com.artclod.common.base.T2;
import com.google.common.base.Function;

public interface FList<E> extends List<E> {

	public boolean nonEmpty();
	
	public <O> FList<O> map(Function<E, O> f);
	
	public FList<E> filter(Predicate<? super E> filter);

	public FList<E> filterNot(Predicate<? super E> filter);

	public String mkString(String sep);

	public String mkString(String start, String sep, String end);

	public E reduce(Function2<E, E, E> f);
	
	public E reduceLeft(Function2<E, E, E> f);

	public E reduceRight(Function2<E, E, E> f);
	
	public E reduce(Function<T2<E, E>, E> f);
	
	public E reduceLeft(Function<T2<E, E>, E> f);

	public E reduceRight(Function<T2<E, E>, E> f);

}

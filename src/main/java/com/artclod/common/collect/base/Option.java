package com.artclod.common.collect.base;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Option<T> extends Collection<T>, UnsupportMutationCollectionMixIn<T> {

	public static <T> Option<T> of(T t) {
		if(t == null) {
			return none();
		}
		return some(t);
	}
	
	public static <T> None<T> none() {
		return None.withType();
	}
	
	public static <T> Some<T> some(T t) {
		return new Some<T>(t);
	}
	
	public default boolean isPresent() {
    	return !isEmpty();
    }
	
    public default boolean nonEmpty() {
    	return !isEmpty();
    }
    
	public T get();
			
	public T or(T defaultValue);
	
   public default T orElse(T defaultValue) {
	   return or(defaultValue);
    }
	
	public default T getOrElse(T defaultValue) {
		return or(defaultValue);
	}
	
	public Option<T> orElse(Option<? extends T> secondChoice);
		
	public T getOrElse(Supplier<? extends T> supplier);
	
	public <O> Option<O> map(Function<? super T, ? extends O> mapper);
	
	public <O> Option<O> flatMap(Function<? super T, ? extends Option<? extends O>> mapper);
	
	public Option<T> filter(Predicate<? super T> predicate);

	public default  Option<T> filterNot(Predicate<? super T> predicate) {
		return filter(predicate.negate());
	}

	public <O> O fold(O ifEmpty, Function<? super T, ? extends O> mapper);

}

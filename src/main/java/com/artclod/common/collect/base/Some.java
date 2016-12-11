/*
 * Copyright (C) 2011 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.artclod.common.collect.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.google.common.collect.Iterators;

/**
 * Implementation of an {@link Option} containing a value.
 */
public final class Some<T> implements Option<T>, Serializable {
	private static final long serialVersionUID = 0;

	private final T value;
	
	Some(T value) {
		this.value = value;
	}
		
	@Override 
	public T get() {
		return value;
	}
	
	public Option<T> orElse(Option<? extends T> secondChoice) {
		return this;
	}
	
	public T getOrElse(Supplier<? extends T> supplier) {
		return get();
	}
	
	@Override 
	public T or(T defaultValue) {
		return value;
	}
	
	@Override 
	public boolean equals(Object object) {
		if (object instanceof Some) {
			Some<?> other = (Some<?>) object;
			return value.equals(other.value);
		}
		return false;
	}
	
	@Override 
	public int hashCode() {
	  return 0x598df91c + value.hashCode();
	}
	
	@Override 
	public String toString() {
	  return "Some(" + value + ")";
	}

	@Override
	public <O> Some<O> map(Function<? super T, ? extends O> mapper) {
		return new Some<O>(mapper.apply(value));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <O> Option<O> flatMap(Function<? super T, ? extends Option<? extends O>> mapper) {
		return (Option<O>) mapper.apply(value);
	}

	@Override
	public Option<T> filter(Predicate<? super T> predicate) {
		if(predicate.test(value)) {
			return this;
		}
		return None.withType();
	}

	@Override
	public <O> Option<O> fold(O ifEmpty, Function<? super T, ? extends O> mapper) {
		return Option.of(mapper.apply(value));
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return value.equals(o);
	}

	@Override
	public Iterator<T> iterator() {
		return Iterators.singletonIterator(value);
	}

	@Override
	public Object[] toArray() {
		return new Object[]{value};
	}

	@SuppressWarnings("unchecked")
	@Override
	public <O> O[] toArray(O[] a) {
		Objects.requireNonNull(a);
		if(a.length < 1) {
			return (O[]) new Object[]{value}; 
		}
		a[0] = (O) value;
		
		if(a.length >= 1) {
			a[1] = null;
		}
		return a;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o : c) {
			if(!contains(o)) {
				return false;
			}
		}
		return true;
	}

}

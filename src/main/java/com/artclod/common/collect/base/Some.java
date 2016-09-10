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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.google.common.base.GuavaOption;
import com.google.common.base.Optional;
import com.google.common.collect.Iterators;

/**
 * Implementation of an {@link Option} containing a value.
 */
final class Some<T> extends GuavaOption<T> {
	private static final long serialVersionUID = 0;

	private final T reference;
	
	Some(T reference) {
		this.reference = reference;
	}
	
	@Override public boolean isPresent() {
		return true;
	}
	
	@Override public T get() {
		return reference;
	}
	
	public Option<T> getOrElse(Option<? extends T> secondChoice) {
		return this;
	}
	
	public T getOrElse(Supplier<? extends T> supplier) {
		return get();
	}
	
	@Override public T or(T defaultValue) {
		checkNotNull(defaultValue, "use Optional.orNull() instead of Optional.or(null)");
		return reference;
	}
	
	@Override public Optional<T> or(Optional<? extends T> secondChoice) {
		checkNotNull(secondChoice);
		return this;
	}
	
	@Override public T or(com.google.common.base.Supplier<? extends T> supplier) {
		checkNotNull(supplier);
		return reference;
	}
	
	@Override public T orNull() {
		return reference;
	}
	
	@Override public Set<T> asSet() {
		return Collections.singleton(reference);
	}
	
	@Override public <V> Optional<V> transform(com.google.common.base.Function<? super T, V> function) {
		return new Some<V>(checkNotNull(function.apply(reference), "the Function passed to Optional.transform() must not return null."));
	}
	
	@Override public boolean equals(Object object) {
		if (object instanceof Some) {
			Some<?> other = (Some<?>) object;
			return reference.equals(other.reference);
		}
		return false;
	}
	
	@Override public int hashCode() {
	  return 0x598df91c + reference.hashCode();
	}
	
	@Override public String toString() {
	  return "Some(" + reference + ")";
	}

	@Override
	public <O> Some<O> map(Function<? super T, ? extends O> mapper) {
		return new Some<O>(mapper.apply(reference));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <O> Option<O> flatMap(Function<? super T, ? extends Option<? extends O>> mapper) {
		return (Option<O>) mapper.apply(reference);
	}

	@Override
	public Option<T> filter(Predicate<? super T> predicate) {
		if(predicate.test(reference)) {
			return this;
		}
		return None.withType();
	}

	@Override
	public <O> Option<O> fold(O ifEmpty, Function<? super T, ? extends O> mapper) {
		return Option.of(mapper.apply(reference));
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
		return reference.equals(o);
	}

	@Override
	public Iterator<T> iterator() {
		return Iterators.singletonIterator(reference);
	}

	@Override
	public Object[] toArray() {
		return new Object[]{reference};
	}

	@SuppressWarnings("unchecked")
	@Override
	public <O> O[] toArray(O[] a) {
		Objects.requireNonNull(a);
		if(a.length < 1) {
			return (O[]) new Object[]{reference}; 
		}
		a[0] = (O) reference;
		
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

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

/**
 * Implementation of an empty {@link Option}.
 */
final class None<T> extends GuavaOption<T> {
	private static final long serialVersionUID = 0;

	static final None<Object> INSTANCE = new None<Object>();
	
	@SuppressWarnings("unchecked") // implementation is "fully variant"
	static <T> None<T> withType() {
	  return (None<T>) INSTANCE;
	}
		
	private None() {}
		
	// === Basic Functionality ===
	@Override
	public boolean isPresent() {
	  return false;
	}
		
	@Override
	public T get() {
	  throw new IllegalStateException("Optional.get() cannot be called on an absent value");
	}
		
	@Override
	public T or(T defaultValue) {
	  return checkNotNull(defaultValue, "use Optional.orNull() instead of Optional.or(null)");
	}
	
	@SuppressWarnings("unchecked")
	public Option<T> getOrElse(Option<? extends T> secondChoice) {
		return (Option<T>) secondChoice;
	}
	
	public T getOrElse(Supplier<? extends T> supplier) {
		return supplier.get();
	}
		
	// === Guava Methods ===
	@SuppressWarnings("unchecked") // safe covariant cast
	@Override
	public Optional<T> or(Optional<? extends T> secondChoice) {
	  return (Optional<T>) checkNotNull(secondChoice);
	}
		
	@Override
	public T or(com.google.common.base.Supplier<? extends T> supplier) {
	  return checkNotNull(supplier.get(),
	      "use Optional.orNull() instead of a Supplier that returns null");
	}
		
	@Override
	public T orNull() {
	  return null;
	}
		
	@Override
	public Set<T> asSet() {
	  return Collections.emptySet();
	}
		
	@Override
	public <V> Optional<V> transform(com.google.common.base.Function<? super T, V> function) {
	  checkNotNull(function);
	  return withType();
	}

	// === Functional Methods ===
	@SuppressWarnings("unchecked")
	@Override
	public <O> Option<O> map(Function<? super T, ? extends O> mapper) {
		return (Option<O>) INSTANCE;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <O> Option<O> flatMap(Function<? super T, ? extends Option<? extends O>> mapper) {
		return (Option<O>) INSTANCE;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Option<T> filter(Predicate<? super T> predicate) {
		return (Option<T>) INSTANCE;
	}
	
	@Override
	public <O> Option<O> fold(O ifEmpty, Function<? super T, ? extends O> mapper) {
		return new Some<O>(ifEmpty);
	}
	
	// === Collection Methods ===
	@Override
	public int size() {
		return 0;
	}
	
	@Override
	public boolean isEmpty() {
		return true;
	}
	
	@Override
	public boolean contains(Object o) {
		Objects.requireNonNull(o);
		return false;
	}
	
	@Override
	public Iterator<T> iterator() {
		return Collections.emptyIterator();
	}
	
	@Override
	public Object[] toArray() {
		return new Object[]{};
	}
	
	@Override
	public <O> O[] toArray(O[] a) {
		Objects.requireNonNull(a);
		if(a.length >= 1) {
			a[0] = null;
		}
		return a;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return c.isEmpty() ? true : false;
	}
	
	// === Utility Methods ===
	@Override
	public boolean equals(Object object) {
		return object instanceof None;
	}
		
	@Override
	public int hashCode() {
	  return 219;
	}
		
	@Override
	public String toString() {
	  return "None";
	}
		
	private Object readResolve() {
	  return INSTANCE;
	}
}

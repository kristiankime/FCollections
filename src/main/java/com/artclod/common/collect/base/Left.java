package com.artclod.common.collect.base;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Left<L, R> implements Either<L, R> {
	private final L value;
	
	public Left(L value) {
		this.value = value;
	}

	@Override
	public boolean isLeft() {
		return true;
	}

	@Override
	public boolean isRight() {
		return false;
	}
	
	@Override
	public L left() {
		return value;
	}
	
	@Override
	public R right() {
		throw new NoSuchElementException();
	}
	
	@Override
	public Option<R> toOption() {
		return Option.none();
	}
	
	@Override
	public <O> O fold(Function<L, O> fa, Function<R, O> fb) {
		return fa.apply(value);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <B> Either<L, B> map(Function<R, B> fb) {
		return (Either) this;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <LL extends L, Y> Either<LL, Y> flatMap(Function<R, Either<LL, Y>> f) {
		return (Either) this;
	}

	// ==== Collection Methods
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
		return Collections.EMPTY_SET.contains(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsAll(Collection<?> c) {
		return Collections.EMPTY_SET.containsAll(c);
	}

	@Override
	public Iterator<R> iterator() {
		return Collections.emptyIterator();
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if(a.length > 0) {
			a[0] = null;
		}
		return a;
	}

	// ==== Utility Methods
	@Override
	public String toString() {
		return "Left(" + value + ")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		Left other = (Left) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}

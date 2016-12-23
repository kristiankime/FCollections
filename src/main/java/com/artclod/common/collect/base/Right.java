package com.artclod.common.collect.base;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;

public class Right<L, R> implements Either<L, R> {
	private final R value;
	
	public Right(R value) {
		this.value = value;
	}
	
	@Override
	public boolean isLeft() {
		return false;
	}

	@Override
	public boolean isRight() {
		return true;
	}
	
	@Override
	public L left() {
		throw new NoSuchElementException();
	}
	
	@Override
	public R right() {
		return value;
	}
	
	@Override
	public Option<R> toOption() {
		return Option.some(value);
	}
	
	@Override
	public <A, B> Either<A, B> fold(Function<L, A> fa, Function<R, B> fb) {
		return new Right<>(fb.apply(value));
	}

	@Override
	public <B> Either<L, B> map(Function<R, B> fb) {
		return new Right<>(fb.apply(value));
	}
	
	@Override
	public <LL extends L, Y> Either<LL, Y> flatMap(Function<R, Either<LL, Y>> f) {
		return f.apply(value);
	}

	// ==== Collection Methods
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
		return Objects.equals(value, o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
		}
        return true;
	}

	@Override
	public Iterator<R> iterator() {
		return Collections.emptyIterator();
	}

	@Override
	public Object[] toArray() {
		return new Object[]{value};
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if(a.length == 0) {
			return (T[]) new Object[]{value};
		} else if(a.length >= 1) {
			a[0] = (T) value;
		}
		if(a.length >= 2) {
			a[1] = null;
		}
		return a;
	}

	
	// ==== Utility Methods
	@Override
	public String toString() {
		return "Right(" + value + ")";
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
		Right other = (Right) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}

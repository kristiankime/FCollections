package com.artclod.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.function.Function;

import com.artclod.common.collect.base.BaseFSet;
import com.artclod.common.collect.builder.CollectionBuilder;
import com.google.common.collect.Sets;

public class LinkedHashFSet<E> extends BaseFSet<E, LinkedHashFSet<E>> {
    private static final long serialVersionUID = 1L;

    public static <E> LinkedHashFSet<E> wrap(LinkedHashSet<E> inner) {
        return new LinkedHashFSet<E>(inner);
    }

    public static <E> LinkedHashFSet<E> create() {
        return new LinkedHashFSet<E>();
    }

    @SafeVarargs
    public static <E> LinkedHashFSet<E> create(E... elements) {
        return new LinkedHashFSet<>(elements);
    }

    public static <E> LinkedHashFSet<E> create(Iterable<? extends E> elements) {
        return new LinkedHashFSet<E>(elements);
    }

    public static <E> LinkedHashFSet<E> createWithExpectedSize(int expectedSize) {
        return new LinkedHashFSet<E>(Sets.newLinkedHashSetWithExpectedSize(expectedSize));
    }
    
    public LinkedHashFSet() {
        this(Sets.newLinkedHashSet());
    }
    
    @SafeVarargs
	public LinkedHashFSet(E... elements) {
        this(Sets.newLinkedHashSet(Arrays.asList(elements)));
    }
    
	public LinkedHashFSet(Iterable<? extends E> elements) {
        this(Sets.newLinkedHashSet(elements));
    }
    
    protected LinkedHashFSet(LinkedHashSet<E> inner) {
        super(inner);
    }

    // This exist so we can create a CollectionBuilder of the right type 
    protected static class LinkedHashFSetBuilder<E> extends LinkedHashFSet<E> implements CollectionBuilder<E, LinkedHashFSet<E>> {
        private static final long serialVersionUID = 1L;

        public LinkedHashFSetBuilder(LinkedHashSet<E> inner) {
            super(inner);
        }

        @Override
        public LinkedHashFSet<E> build() {
            return this;
        }
    }

    @Override
    protected CollectionBuilder<E, LinkedHashFSet<E>> builder() {
        return new LinkedHashFSetBuilder<E>(new LinkedHashSet<E>());
    }
    
	@Override
	protected CollectionBuilder<E, LinkedHashFSet<E>> builder(Collection<E> c) {
		return new LinkedHashFSetBuilder<E>(new LinkedHashSet<E>(c));
	}

    @Override
    protected Iterator<E> reverseIterator() {
        return iterator(); // There is no sensible reverse of a HashSet
    }

    @Override
    public <O> LinkedHashFSet<O> map(Function<? super E, ? extends O> f) {
        LinkedHashFSet<O> ret = new LinkedHashFSet<O>(new LinkedHashSet<O>());
        for (E e : this) {
            ret.add(f.apply(e));
        }
        return ret;
    }

    @Override
    public <O> LinkedHashFSet<O> flatMap(Function<? super E, ? extends Collection<? extends O>> mapper) {
        LinkedHashFSet<O> ret = new LinkedHashFSet<O>(new LinkedHashSet<O>());
        for (E e : this) {
            ret.addAll(mapper.apply(e));
        }
        return ret;
    }

}

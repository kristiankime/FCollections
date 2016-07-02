package com.artclod.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;

import com.artclod.common.collect.LinkedHashFSet.LinkedHashFSetBuilder;
import com.artclod.common.collect.base.BaseFSet;
import com.artclod.common.collect.base.UnsupportMutationSetMixIn;
import com.artclod.common.collect.builder.CollectionBuilder;

public class LinkedHashViewFSet<E> extends BaseFSet<E, LinkedHashFSet<E>> implements ViewFSet<E>, UnsupportMutationSetMixIn<E> {
	private static final long serialVersionUID = 1L;

	public static <E> LinkedHashViewFSet<E> wrap(Set<E> inner) {
		return new LinkedHashViewFSet<E>(inner);
	}

	public LinkedHashViewFSet(Set<E> inner) {
		super(inner);
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
		return iterator(); // No sensible reverse
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

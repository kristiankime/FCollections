package com.artclod.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class ArrayFList<E> extends BaseFList<E> implements Serializable {
	private static final long serialVersionUID = 2789999731173364042L;

	public ArrayFList(ArrayList<E> inner) {
		super(inner);
	}
	
	public ArrayFList() {
		super(Lists.newArrayList());
	}
	
	public ArrayFList(@SuppressWarnings("unchecked") E... elements) {
		super(Lists.newArrayList(elements));
	}
	
	public ArrayFList(Iterable<? extends E> elements) {
		super(Lists.newArrayList(elements));
	}
	
	public ArrayFList(Iterator<? extends E> elements) {
		super(Lists.newArrayList(elements));
	}

	// ============ FLIST METHODS =========
	@Override
	public <O> ArrayFList<O> map(Function<E, O> f) {
		ArrayList<O> create = Lists.newArrayListWithCapacity(inner.size());
		for(int i = 0; i< inner.size(); i++){
			create.add(f.apply(inner.get(i)));
		}
		return new ArrayFList<O>(create);
	}
	
	public String mkString(String start, String sep, String end){
		StringBuilder ret = new StringBuilder(start);
		for(int i = 0; i< inner.size(); i++){
			ret.append(inner.get(i));
			if(i != (inner.size()-1)){
				ret.append(sep);
			}
		}
		return ret.append(end).toString();
	}
}

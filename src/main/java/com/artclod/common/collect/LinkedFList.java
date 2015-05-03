package com.artclod.common.collect;

import java.io.Serializable;
import java.util.LinkedList;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class LinkedFList<E> extends BaseFList<E> implements Serializable {
	private static final long serialVersionUID = 2789999731173364042L;

	public LinkedFList(LinkedList<E> inner) {
		super(inner);
	}
	
	public LinkedFList() {
		super(Lists.newLinkedList());
	}
	
	public LinkedFList(Iterable<? extends E> elements) {
		super(Lists.newLinkedList(elements));
	}

	// ============ FLIST METHODS =========
	@Override
	public <O> LinkedFList<O> map(Function<E, O> f) {
		LinkedList<O> create = Lists.newLinkedList();
		for(E e: this){
			create.add(f.apply(e));
		}
		return new LinkedFList<O>(create);
	}
	
	public String mkString(String start, String sep, String end){
		StringBuilder ret = new StringBuilder(start);
		String s = "";
		for(E e: this){
			ret.append(s).append(e);
			s = sep;
		}
		return ret.append(end).toString();
	}
}

package com.artclod.common.collect.contract;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public abstract class MutableFListContract extends FListContract {

	@Test
	public void add(){
		List<Integer> list = fList(1, 2);
		list.add(3);
		assertEquals(asList(1,  2, 3), list);
	}
	
//	remove
//
//	addAll
//
//	addAll
//	
//	removeAll
//
//	retainAll
//
//	replaceAll
//
//	sort
//
//	clear
//
//	set
//
//	add
//
//	remove
//
//	removeIf
}

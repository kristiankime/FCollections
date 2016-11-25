package com.artclod.common.collect.contract;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.artclod.common.collect.FCollection;
import com.artclod.common.collect.FList;
import com.artclod.common.collect.ImFList;
import com.google.common.collect.Ordering;

public abstract class ImFListContract extends FListContract {

	public abstract <T> ImFList<T> fList(@SuppressWarnings("unchecked") T... elements);
	
	@Test(expected=UnsupportedOperationException.class)
	public void add(){
		List<Integer> list = fList(1, 2);
		list.add(3);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void add_indexed(){
		List<Integer> list = fList(1, 2);
		list.add(1, 3);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void remove(){
		List<String> list = fList("1", "2", "3", "5");
		list.remove("3");
	}

	@Test(expected=UnsupportedOperationException.class)
	public void remove_indexed(){
		List<String> list = fList("1", "2", "3", "5");
		list.remove(3);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void addAll(){
		List<Integer> list = fList(1, 2, 5);
		list.addAll(asList(3, 4));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void addAll_indexed(){
		List<Integer> list = fList(1, 2, 5);
		list.addAll(1, asList(3, 4));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void removeAll(){
		List<Integer> list = fList(1, 7, 6, 2, 5);
		list.removeAll(asList(3, 7, 6));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void retainAll(){
		List<Integer> list = fList(1, 7, 6, 2, 5);
		list.retainAll(asList(3, 6, 7));
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void replaceAll(){
		List<Integer> list = fList(1, 7, 6);
		list.replaceAll((v) -> v + 1);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void sort(){
		List<Integer> list = fList(1, 5, 7, 6, 2);
		list.sort((a, b) -> Integer.valueOf(a).compareTo(b));
	}

	@Test(expected=UnsupportedOperationException.class)
	public void clear(){
		List<Integer> list = fList(1, 6, 2);
		list.clear();
	}
		
	@Test(expected=UnsupportedOperationException.class)
	public void set(){
		List<Integer> list = fList(1, 2, 6, 7);
		list.set(2, 3);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void removeIf(){
		List<Integer> list = fList(1, 7, 3, 6, 2);
		list.removeIf((v) -> v > 3);
	}
    
    // Copy methods
//	@Test
//	public void addCp(){
//		List<Integer> list = fList(1, 2).addCp(3);
//		assertEquals(asList(1, 2, 3), list);
//	}
//	
//	@Test
//	public void addCp_indexed(){
//		List<Integer> list = fList(1, 2).addCp(1, 3);
//		assertEquals(asList(1, 3, 2), list);
//	}
//	
//	@Test
//	public void removeCp(){
//		List<String> list = fList("1", "2", "3", "5").removeCp("3");
//		assertEquals(asList("1", "2", "5"), list);
//	}
//
//	@Test
//	public void removeCp_indexed(){
//		List<String> list = fList("1", "2", "3", "5").removeCp(3);
//		assertEquals(asList("1", "2", "3"), list);
//	}
//	
//	@Test
//	public void addAllCp(){
//		List<Integer> list = fList(1, 2, 5).addAllCp(asList(3, 4));
//		assertEquals(asList(1, 2, 5, 3, 4), list);
//	}
//	
//	@Test
//	public void addAllCp_indexed(){
//		List<Integer> list = fList(1, 2, 5).addAllCp(1, asList(3, 4));
//		assertEquals(asList(1, 3, 4, 2, 5), list);
//	}
//	
//	@Test
//	public void removeAllCp(){
//		List<Integer> list = fList(1, 7, 6, 2, 5).removeAllCp(asList(3, 7, 6));
//		assertEquals(asList(1, 2, 5), list);
//	}
//	
//	@Test
//	public void retainAllCp(){
//		List<Integer> list = fList(1, 7, 6, 2, 5).retainAllCp(asList(3, 6, 7));
//		assertEquals(asList(7, 6), list);
//	}
//	
//	@Test
//	public void replaceAllCp(){
//		List<Integer> list = fList(1, 7, 6).replaceAllCp((v) -> v + 1);
//		assertEquals(asList(2, 8, 7), list);
//	}
//	
//	@Test
//	public void setCp(){
//		List<Integer> list = fList(1, 2, 6, 7).setCp(2, 3);
//		assertEquals(asList(1, 2, 3, 7), list);
//	}
//	
//	@Test
//	public void removeIfCp(){
//		List<Integer> list = fList(1, 7, 3, 6, 2).removeIfCp((v) -> v > 3);
//		assertEquals(asList(1, 3, 2), list);
//	}
	
	// --- sort
    @Test(expected=UnsupportedOperationException.class)
    public void sortWith() throws Exception {
        fList(3, 1, 2).sortWith(Ordering.<Integer> natural());
    }

    @Test(expected=UnsupportedOperationException.class)
    public void sorted() throws Exception {
        fList(3, 1, 2).sorted();
    }
	
	// --- group
	@Test
	public void groupByIL_empty_map_for_empty_collection() throws Exception {
		Map<Integer, ImFList<Integer>> actual = this.<Integer> fList().groupByIL(i -> i);
		assertTrue(actual.isEmpty());
	}
	
	@Test
	public void groupByIL_groups_as_specified() throws Exception {
		Map<Integer, ImFList<Integer>> actual = this.<Integer> fList(0, 1, 2, 3).groupByIL(i -> i % 2);
		assertEquals(2, actual.size());
		assertThat(actual.get(0), contains(0, 2));
		assertThat(actual.get(1), contains(1, 3));
	}
	
	@Test
    public void toList_return_is_mutable() throws Exception {
		FCollection<Integer> original = fCollection(3, 1, 2);
		FList<Integer> mu = original.toList();
		assertEquals(original, mu);
		
		mu.add(4);
		assertThat(original, contains(3, 1, 2)); // Here mutating new does not change the original
		assertThat(mu, contains(3, 1, 2, 4));
	}
}

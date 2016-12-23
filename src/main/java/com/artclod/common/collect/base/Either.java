package com.artclod.common.collect.base;

import java.util.Collection;
import java.util.function.Function;

/**
 * Represent one of two possible values, either a left or a right.
 * This can be thought of as an expaned {@link Option} where the none can also have a value.
 * By convention the left version is usually considered to be the failure case and the right is success.
 * Either is considered to be right biased. 
 * This means operations like contains, map, and toOption assume a left value is "empty".
 *
 * @param <L> Type of left value
 * @param <R> Type of Right value
 */
public interface Either<L, R> extends Collection<R>, UnsupportMutationCollectionMixIn<R>{

	public static <L, R> Left<L, R> left(L value) {
		return new Left<>(value);
	}
	
	public static <L, R> Right<L, R> right(R value) {
		return new Right<>(value);
	}
	
	/**
	 * Returns true if this is a Left, false otherwise.
	 * 
	 * @return indicates if this is left
	 */
	public boolean isLeft();
	
	/**
	 * Returns true if this is a Right, false otherwise.
	 * 
	 * @return indicates if this is right
	 */
	public boolean isRight();
	
	/**
	 * Returns left value if it exists, otherwise throws
	 * 
	 * @return left value
	 */
	public L left();
	
	/**
	 * Returns right value if it exists, otherwise throws
	 * 
	 * @return right value
	 */
	public R right();
	
	/**
	 * If right returns value as a some, otherwise returns none
	 * 
	 * @return this as an option of right value
	 */
	public Option<R> toOption();
    
	/**
	 * Applies fa if this is a Left or fb if this is a Right.
	 * 
	 * @param fa function that will be applied if this is a left
	 * @param fb function that will be applied if this is a right
	 *  
	 * @param <A> Type of left value after folding
	 * @param <B> Type of Right value after folding
	 * @return transformed either
	 */
	public <A,B> Either<A,B> fold(Function<L, A> fa, Function<R, B> fb);
	
	
	/**
	 * Applies f if this is a right or leaves left values unchanged.
	 * 
	 * @param fb function that will be applied if this is a right
	 * @param <B> Type of Right value after folding 
	 * @return transformed either
	 */
	public <B> Either<L,B> map(Function<R, B> fb);
	
	public <LL extends L, Y> Either<LL, Y> flatMap(Function<R, Either<LL, Y>> f);
	
}

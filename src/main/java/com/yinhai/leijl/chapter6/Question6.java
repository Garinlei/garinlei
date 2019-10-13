package com.yinhai.leijl.chapter6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Question6 {

	//顺序求和数字的平方和
	public static int sequentialSumOfSquares(IntStream range){
		return range.map(x -> x*x).sum();
	}

	//并行处理
	public static int sequentialSumOfSquares2(IntStream range){
		return range.parallel().map(x -> x*x).sum();
	}

	/**
	 * 将列表的数字相乘，在乘5
	 * @param linkedListOfNumbers
	 * @return
	 */
	public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
		return linkedListOfNumbers.stream() .reduce(5, (acc, x) -> x * acc);
	}

	/**
	 * 使用流并行化处理
	 * @param linkedListOfNumbers
	 * @return
	 */
	public static int multiplyThrough2(List<Integer> linkedListOfNumbers) {
		return 5*linkedListOfNumbers.parallelStream().reduce(1, (acc, x) -> x * acc);
	}

	public static void main(String[] args) {
		IntStream range = IntStream.of(1, 2, 3, 3);
		//int i = sequentialSumOfSquares(range);
		//System.out.println(i+"---1");
		int i2 = sequentialSumOfSquares2(range);
		System.out.println(i2+"---2");


		List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
		/*int i3 = multiplyThrough(integerList);
		System.out.println(i3+"---3");*/
		int i4 = multiplyThrough2(integerList);
		System.out.println(i4+"---4");
	}
}

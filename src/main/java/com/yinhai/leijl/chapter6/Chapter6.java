package com.yinhai.leijl.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 数据并行化
 */
public class Chapter6 {


	// 6.7并行化数组操作

	/**
	 * 使用for循环初始化数组
	 * @param size
	 * @return
	 */
	public static double[] initDoubleArray(int size){
		double[] values = new double[size];
		for (int i = 0; i < values.length; i++){
			values[i] = i;
		}
		return values;
	}

	/**
	 * 使用parallelSetAll并行化数组操作
	 * @param size
	 * @return
	 */
	public static double[] parallelInitArray(int size){
		double[] values = new double[size];
		Arrays.parallelSetAll(values,i -> i);
		return values;
	}

	/**
	 * 计算滑动平均数
	 * parallelPrefix 更新数组，将每一个元素替换成与前驱元素的“和”
	 * @return
	 */
	public static double[] countMovingAve(double[] values,int n){
		double[] sums = Arrays.copyOf(values, values.length);
		Arrays.parallelPrefix(sums,Double::sum);
		int start = n -1;
		return IntStream.range(start,sums.length)
						.mapToDouble(i -> {
							double prefix = i == start ? 0 : sums[i - n];
							return (sums[i] - prefix)/n;
						}).toArray();
	}

	public static void main(String[] args) {
		double[] doubles = initDoubleArray(5);
		double[] doubles1 = parallelInitArray(5);
		/*Arrays.stream(doubles).forEach(i -> System.out.println(i));
		Arrays.stream(doubles1).forEach(i -> System.out.println(i));*/

		double[] values = new double[]{0,1,2,3,4,3.5};
		double[] doubles2 = countMovingAve(values, 3);
		for (double v : doubles2) {
			System.out.println(v);
		}
	}
}

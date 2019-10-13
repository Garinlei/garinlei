package com.yinhai.leijl.chapter5;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class Question5 {


	/**
	 * 计算长度最长的名字
	 * 使用收集器maxBy
	 * @param names
	 * @return
	 */
	public static String getLongestName1(Stream<String> names){
		/*Function<Artist,Integer> byNameLength = artist -> artist.getName().length();
		return artists
				.stream().collect(maxBy(Comparator.comparing(byNameLength)));*/

		Function<String,Integer> byNameLenth = name -> name.length();
		return names.collect(maxBy(Comparator.comparing(byNameLenth))).orElseThrow(RuntimeException::new);
	}


	/**
	 * 计算长度最长的名字
	 * 使用Stream的max函数
	 * @param names
	 * @return
	 */
	public static String getLongestName2(Stream<String> names){
		Function<String,Integer> byNameLenth = name -> name.length();
		return names.max(Comparator.comparing(byNameLenth)).orElseThrow(RuntimeException::new);
	}


	public static Map<String, Long> countNameNum(Stream<String> names){
		return names.collect(groupingBy(name -> name,counting()));
	}

	public static void main(String[] args) {
		Stream<String> names = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
		//String longestName1 = getLongestName1(names);
		String longestName2 = getLongestName2(names);
		System.out.println(longestName2+"---2");
		//System.out.println(longestName1+"---1");
		Stream<String> names2 = Stream.of("John", "Paul", "George", "John", "Paul", "John");
		Map<String, Long> map = countNameNum(names2);
		map.forEach((key,value) -> {
			System.out.println(key + "-->"+value+",");
		});
		System.out.println(map);
	}
}

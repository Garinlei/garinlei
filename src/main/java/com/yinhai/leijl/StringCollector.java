package com.yinhai.leijl;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StringCollector implements Collector<String,StringCombiner,String> {

	private static final Set<Characteristics> characteristics = Collections.emptySet();
	private final String delim;

	private final String prefix;

	private final String suffix;

	public StringCollector(String delim, String prefix, String suffix) {
		this.delim = delim;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	/**
	 * Supplier是创建容器的工厂
	 * @return
	 */
	@Override
	public Supplier<StringCombiner> supplier() {
		return () -> new StringCombiner(delim,prefix,suffix);
	}


	/**
	 * 将当前元素叠加到收集器中，相当于reduce操作的第二个参数
	 * @return
	 */
	@Override
	public BiConsumer<StringCombiner, String> accumulator() {
		return StringCombiner::add;
	}

	/**
	 * 合并两个容器
	 * @return
	 */
	@Override
	public BinaryOperator<StringCombiner> combiner() {
		return StringCombiner::merge;
	}

	/**
	 * 返回最终值
	 * @return
	 */
	@Override
	public Function<StringCombiner, String> finisher() {
		return StringCombiner::toString;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return characteristics;
	}
}

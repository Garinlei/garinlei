package com.yinhai.leijl;

public class StringCombiner {

	private final String prefix;

	private final String suffix;

	private final String delim;

	private final StringBuilder builder;

	public StringCombiner(String delim,String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
		this.delim = delim;
		this.builder = new StringBuilder();
	}

	public StringCombiner add(String element){
		if (this.areAtStart()){
			builder.append(prefix);
		}else {
			builder.append(delim);
		}
		builder.append(element);
		return this;
	}

	public StringCombiner merge(StringCombiner other){
		builder.append(other.builder);
		return this;
	}

	private boolean areAtStart() {
		return builder.length() == 0;
	}

	@Override
	public String toString() {
		return builder.toString() + suffix;
	}
}

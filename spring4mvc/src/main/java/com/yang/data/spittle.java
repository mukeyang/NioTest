package com.yang.data;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by CS on 2018/4/7.
 */
public class spittle {
	private final int id;
	private final  String name;

	public static void main(String[] args) {
		//language=JSON
		String name = "{\"home\":\"123\"}";

	}

	public spittle(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		spittle spittle = (spittle) o;

		return new EqualsBuilder()
				.append(id, spittle.id)
				.append(name, spittle.name)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(id)
				.append(name)
				.toHashCode();
	}
}

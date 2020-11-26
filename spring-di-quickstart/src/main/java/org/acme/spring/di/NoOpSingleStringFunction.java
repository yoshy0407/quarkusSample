package org.acme.spring.di;

import org.springframework.stereotype.Component;

@Component("noopFunction")
public class NoOpSingleStringFunction implements StringFunction {

	@Override
	public String apply(String t) {
		return t;
	}

}

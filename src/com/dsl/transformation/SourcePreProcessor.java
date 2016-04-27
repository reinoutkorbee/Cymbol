package com.dsl.transformation;

import org.codehaus.groovy.control.ParserPlugin;
import org.codehaus.groovy.control.ParserPluginFactory;

public class SourcePreProcessor extends ParserPluginFactory {
	
	@Override
	public ParserPlugin createParserPlugin() {
		return new CustomParserPlugin();
	}

}

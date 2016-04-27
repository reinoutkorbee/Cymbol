package com.dsl.transformation;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.ParserPluginFactory;
import org.junit.Test;

public class DslScriptTransformTest {
	String scriptPath = "tests";
	
	@Test
	public void testPreProcessor() throws CompilationFailedException, IOException {
		String testScript = scriptPath + "/test1.cymbol";
		File scriptFile = new File(testScript);
		ParserPluginFactory ppf = new SourcePreProcessor();
		CompilerConfiguration cc = new CompilerConfiguration();
		cc.setPluginFactory(ppf);
		Binding binding = new Binding();
		GroovyShell shell = new GroovyShell(binding, cc);
		shell.evaluate(scriptFile);
	}
}

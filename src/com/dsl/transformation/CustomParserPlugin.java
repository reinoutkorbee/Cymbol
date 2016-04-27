package com.dsl.transformation;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.codehaus.groovy.antlr.AntlrParserPlugin;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.syntax.Reduction;
import org.stringtemplate.v4.ST;

public class CustomParserPlugin extends AntlrParserPlugin {
	
	@Override
	public Reduction parseCST(final SourceUnit sourceUnit, Reader reader) throws CompilationFailedException {
		StringBuffer bfr = new StringBuffer();
		int intValueOfChar;   
		try {
			while ((intValueOfChar = reader.read()) != -1) {        
				bfr.append((char) intValueOfChar);    
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		String text = modifyTextSource(bfr.toString());
		StringReader stringReader = new StringReader(text);
		
		SourceUnit modifiedSource = SourceUnit.create(sourceUnit.getName(), text);
		
		return super.parseCST(modifiedSource, stringReader);
	}
	
	String modifyTextSource(String text) {
		ST textAsStringConstant = new ST("String getScriptText() { return '''<text>''' }");
		textAsStringConstant.add("text", text);
		return textAsStringConstant.render();
	}
	
}

package com.dsl.transformation;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.dsl.cymbol.CymbolLexer;
import com.dsl.cymbol.CymbolParser;

public class DslScriptTransformHelper {
	
	public SemanticModel parse(String scriptText) throws IOException {
		ANTLRInputStream is = new ANTLRInputStream(scriptText);
		CymbolLexer lexer = new CymbolLexer(is);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CymbolParser parser = new CymbolParser(tokens);
		ParseTree tree = parser.file();
		SemanticModel model = initSemanticModel(tree);
		SemanticModelVisitor visitor = initVisitor();
		visitor.visit(model);
		return model;
	}
	
	private SemanticModel initSemanticModel(ParseTree tree) {
		SemanticModel model = new SemanticModel() {

			@Override
			public void init(ParseTree tree) {
				System.out.println("init: " + tree.toStringTree());
			}
			
		};
		
		model.init(tree);
		return model;
	}
	
	private SemanticModelVisitor initVisitor() {
		SemanticModelVisitor visitor = new SemanticModelVisitor() {
			
			@Override
			public void visit(SemanticModel model) {
				System.out.println("visit");
			}
		};
		
		return visitor;
		
	}
	
}

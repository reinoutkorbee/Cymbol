package com.dsl.transformation;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.ModuleNode;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.VariableScope;
import org.codehaus.groovy.ast.expr.ArgumentListExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.ConstructorCallExpression;
import org.codehaus.groovy.ast.expr.DeclarationExpression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.BlockStatement;
import org.codehaus.groovy.ast.stmt.ExpressionStatement;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.syntax.Token;
import org.codehaus.groovy.syntax.Types;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
public class DslScriptTransform implements ASTTransformation {
	private static final String SCRIPT_TEXT_VAR = "scriptText";
	private static final String RUN_METHOD = "run";
	private static final String PARSE_METHOD = "parse";
	private static final String HELPER_VAR = "helper";
	private static final String EXTENSION = ".cymbol";
	private static final String SCRIPT_IMPL_CLASS = "ScriptImpl";
	private static final String GET_SCRIPT_TEXT_METHOD = "getScriptText";

	@Override
	public void visit(ASTNode[] nodes, SourceUnit source) {
		if(!source.getName().endsWith(EXTENSION)) {
			return;
		}
		
		ModuleNode module = source.getAST();
		
		for(ClassNode cn : module.getClasses()) {
			if(cn.getNameWithoutPackage().equals(SCRIPT_IMPL_CLASS)) {
				return;
			}
		}
		
		ClassNode mainClassNode = getMainClass(module);
		addRunMethod(mainClassNode);
	}
	
	private ClassNode getMainClass(ModuleNode moduleNode) {
		for(ClassNode classNode : moduleNode.getClasses()) {
			if(classNode.getNameWithoutPackage().equals(moduleNode.getMainClassName())) {
				return classNode;
			}
		}
		return null;
	}
	
	private void addRunMethod(ClassNode scriptClass) {
		
		List<Statement> statements = new ArrayList<>();
		
		/*
		 * initialise the parser helper:
		 * 
		 * DslScriptTransformHelper helper = new DslScriptTransformHelper()
		 */
		ClassNode helperClassNode = new ClassNode(DslScriptTransformHelper.class);
		ConstructorCallExpression initParserHelper = new ConstructorCallExpression(helperClassNode, new ArgumentListExpression());
		VariableExpression helperVar = new VariableExpression(HELPER_VAR, helperClassNode);
		DeclarationExpression assignHelperExpr = new DeclarationExpression(helperVar, new Token(Types.EQUALS, "=", -1, -1), initParserHelper);
		ExpressionStatement initHelperExpr = new ExpressionStatement(assignHelperExpr);
		statements.add(initHelperExpr);
		
		/*
		 * get the script text and assign it to a variable:
		 * 
		 * String scriptText = this.getScriptText()
		 */
		MethodCallExpression getScriptTextExpr = new MethodCallExpression(new VariableExpression("this"), new ConstantExpression(GET_SCRIPT_TEXT_METHOD), MethodCallExpression.NO_ARGUMENTS);
		VariableExpression scriptTextVar = new VariableExpression(SCRIPT_TEXT_VAR, new ClassNode(String.class));
		DeclarationExpression declareScriptTextExpr = new DeclarationExpression(scriptTextVar, new Token(Types.EQUALS, "=", -1, -1), getScriptTextExpr);
		ExpressionStatement getScriptTextStmt = new ExpressionStatement(declareScriptTextExpr);
		statements.add(getScriptTextStmt);
		
		/*
		 * call the parse method on the helper:
		 * 
		 * helper.parse(scriptText)
		 */
		MethodCallExpression callParserExpr = new MethodCallExpression(helperVar, PARSE_METHOD, new ArgumentListExpression(new VariableExpression(SCRIPT_TEXT_VAR)));
		ExpressionStatement callParserStmt = new ExpressionStatement(callParserExpr);
		statements.add(callParserStmt);
		
		// implement the run method's body
		BlockStatement methodBody = new BlockStatement(statements, new VariableScope());
		MethodNode runMethod = scriptClass.getMethod(RUN_METHOD, new Parameter[0]);
		runMethod.setCode(methodBody);
	}
	
}

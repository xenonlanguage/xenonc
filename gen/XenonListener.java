// Generated from C:/Users/Liam Greenway/RustroverProjects/xenon/xenon_ast/Xenon.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Xenon}.
 */
public interface XenonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Xenon#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Xenon.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Xenon.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#programMember}.
	 * @param ctx the parse tree
	 */
	void enterProgramMember(Xenon.ProgramMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#programMember}.
	 * @param ctx the parse tree
	 */
	void exitProgramMember(Xenon.ProgramMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(Xenon.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(Xenon.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(Xenon.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(Xenon.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(Xenon.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(Xenon.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(Xenon.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(Xenon.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#traitDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTraitDeclaration(Xenon.TraitDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#traitDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTraitDeclaration(Xenon.TraitDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#useDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterUseDeclaration(Xenon.UseDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#useDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitUseDeclaration(Xenon.UseDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModuleDeclaration(Xenon.ModuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModuleDeclaration(Xenon.ModuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(Xenon.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(Xenon.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Xenon.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Xenon.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(Xenon.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(Xenon.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Xenon.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Xenon.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(Xenon.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(Xenon.VariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(Xenon.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(Xenon.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(Xenon.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(Xenon.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(Xenon.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(Xenon.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(Xenon.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(Xenon.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(Xenon.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(Xenon.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#case}.
	 * @param ctx the parse tree
	 */
	void enterCase(Xenon.CaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#case}.
	 * @param ctx the parse tree
	 */
	void exitCase(Xenon.CaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#unsafeBlock}.
	 * @param ctx the parse tree
	 */
	void enterUnsafeBlock(Xenon.UnsafeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#unsafeBlock}.
	 * @param ctx the parse tree
	 */
	void exitUnsafeBlock(Xenon.UnsafeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(Xenon.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(Xenon.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(Xenon.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(Xenon.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(Xenon.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(Xenon.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(Xenon.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(Xenon.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#moduleMember}.
	 * @param ctx the parse tree
	 */
	void enterModuleMember(Xenon.ModuleMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#moduleMember}.
	 * @param ctx the parse tree
	 */
	void exitModuleMember(Xenon.ModuleMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Xenon.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Xenon.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(Xenon.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(Xenon.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#pointerType}.
	 * @param ctx the parse tree
	 */
	void enterPointerType(Xenon.PointerTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#pointerType}.
	 * @param ctx the parse tree
	 */
	void exitPointerType(Xenon.PointerTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(Xenon.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(Xenon.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#tupleType}.
	 * @param ctx the parse tree
	 */
	void enterTupleType(Xenon.TupleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#tupleType}.
	 * @param ctx the parse tree
	 */
	void exitTupleType(Xenon.TupleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#pathType}.
	 * @param ctx the parse tree
	 */
	void enterPathType(Xenon.PathTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#pathType}.
	 * @param ctx the parse tree
	 */
	void exitPathType(Xenon.PathTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#primativeType}.
	 * @param ctx the parse tree
	 */
	void enterPrimativeType(Xenon.PrimativeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#primativeType}.
	 * @param ctx the parse tree
	 */
	void exitPrimativeType(Xenon.PrimativeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Xenon.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Xenon.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Xenon.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Xenon.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(Xenon.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(Xenon.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#charLiteral}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteral(Xenon.CharLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#charLiteral}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteral(Xenon.CharLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(Xenon.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(Xenon.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(Xenon.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(Xenon.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(Xenon.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(Xenon.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTupleLiteral(Xenon.TupleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTupleLiteral(Xenon.TupleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#parentheses}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(Xenon.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#parentheses}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(Xenon.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(Xenon.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(Xenon.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(Xenon.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(Xenon.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#cmpExpr}.
	 * @param ctx the parse tree
	 */
	void enterCmpExpr(Xenon.CmpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#cmpExpr}.
	 * @param ctx the parse tree
	 */
	void exitCmpExpr(Xenon.CmpExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#bitOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterBitOrExpr(Xenon.BitOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#bitOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitBitOrExpr(Xenon.BitOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#bitXorExpr}.
	 * @param ctx the parse tree
	 */
	void enterBitXorExpr(Xenon.BitXorExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#bitXorExpr}.
	 * @param ctx the parse tree
	 */
	void exitBitXorExpr(Xenon.BitXorExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#bitAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterBitAndExpr(Xenon.BitAndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#bitAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitBitAndExpr(Xenon.BitAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpr(Xenon.ShiftExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#shiftExpr}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpr(Xenon.ShiftExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(Xenon.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(Xenon.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#mulExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(Xenon.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#mulExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(Xenon.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#castExpr}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(Xenon.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#castExpr}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(Xenon.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#unaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperation(Xenon.UnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#unaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperation(Xenon.UnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Xenon#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(Xenon.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Xenon#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(Xenon.PrimaryContext ctx);
}
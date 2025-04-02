// Generated from C:/Users/Liam Greenway/RustroverProjects/xenon/xenon_ast/Xenon.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Xenon}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XenonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Xenon#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Xenon.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#programMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramMember(Xenon.ProgramMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(Xenon.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(Xenon.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(Xenon.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(Xenon.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#traitDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraitDeclaration(Xenon.TraitDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#useDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseDeclaration(Xenon.UseDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#moduleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleDeclaration(Xenon.ModuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(Xenon.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Xenon.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(Xenon.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Xenon.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(Xenon.VariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(Xenon.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(Xenon.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(Xenon.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(Xenon.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(Xenon.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase(Xenon.CaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#unsafeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsafeBlock(Xenon.UnsafeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(Xenon.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(Xenon.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(Xenon.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(Xenon.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#moduleMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleMember(Xenon.ModuleMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(Xenon.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(Xenon.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#pointerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerType(Xenon.PointerTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(Xenon.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#tupleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleType(Xenon.TupleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#pathType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathType(Xenon.PathTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#primativeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimativeType(Xenon.PrimativeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Xenon.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(Xenon.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(Xenon.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#charLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(Xenon.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(Xenon.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(Xenon.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(Xenon.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#tupleLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleLiteral(Xenon.TupleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#parentheses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(Xenon.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(Xenon.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(Xenon.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#cmpExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExpr(Xenon.CmpExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#bitOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOrExpr(Xenon.BitOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#bitXorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitXorExpr(Xenon.BitXorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#bitAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitAndExpr(Xenon.BitAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#shiftExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpr(Xenon.ShiftExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(Xenon.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(Xenon.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#castExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpr(Xenon.CastExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#unaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperation(Xenon.UnaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Xenon#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(Xenon.PrimaryContext ctx);
}
package com.ge;

public class Expression implements Operand {

	Expression left;
	Expression right;
	Operator operator;
	
	public Expression(){
		
	}
	
	public Expression(Expression left, Operator operator, Expression right) {
		this.left=left;
		this.right=right;
		this.operator=operator;
	}
	
	@Override
	public Expression solve(){
		return right.solve().first(left.solve(), operator.getOperator());
	}
	
	@Override
	public Expression accept(IntegerOperand rightOperand, IOperator operator) {
		return null;
	}

	@Override
	public Expression accept(StringOperand rightOperand, IOperator operator) {
		return null;
	}

	@Override
	public Expression accept(Expression rightOperand, IOperator operator) {
		return null;
	}
	
	@Override
	public Expression first(IntegerOperand firstOperand, IOperator operator) {
		return firstOperand.accept(this, operator);
	}

	@Override
	public Expression first(StringOperand firstOperand, IOperator operator) {
		return firstOperand.accept(this, operator);
	}

	@Override
	public Expression first(Expression firstOperand, IOperator operator) {
		return firstOperand.accept(this, operator);
	}

}

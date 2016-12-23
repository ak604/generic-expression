package com.ge;

public interface Operand{
	Expression accept(IntegerOperand rightOperand, IOperator operator);
	Expression accept(StringOperand rightOperand, IOperator operator);
	Expression accept(Expression rightOperand, IOperator operator);
	
	Expression first(IntegerOperand firstOperand, IOperator operator);
	Expression first(StringOperand firstOperand, IOperator operator);
	Expression first(Expression firstOperand, IOperator operator);
	
	Expression solve();
	
}

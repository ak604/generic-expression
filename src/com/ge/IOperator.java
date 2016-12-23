package com.ge;

public interface IOperator {
	
	Expression operate(IntegerOperand leftOperand, IntegerOperand rightOperand);
	Expression operate(StringOperand leftOperand, StringOperand rightOperand);
	Expression operate(IntegerOperand leftOperand, StringOperand rightOperand);
	Expression operate(StringOperand leftOperand, IntegerOperand rightOperand);
}

package com.ge;

public class PlusOperator implements IOperator {

	@Override
	public Expression operate(IntegerOperand leftOperand, IntegerOperand rightOperand) {
		return new IntegerOperand(leftOperand.getVal()+rightOperand.getVal());
		
	}

	@Override
	public Expression operate(StringOperand leftOperand, StringOperand rightOperand) {
		return new StringOperand(leftOperand.getVal()+rightOperand.getVal());
	}

	@Override
	public Expression operate(IntegerOperand leftOperand, StringOperand rightOperand) {
		return new StringOperand(leftOperand.getVal()+rightOperand.getVal());
		
	}

	@Override
	public Expression operate(StringOperand leftOperand, IntegerOperand rightOperand) {
		return new StringOperand(leftOperand.getVal()+rightOperand.getVal());
		
	}

}

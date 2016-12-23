package com.ge;

public class MulOperator implements IOperator {

	@Override
	public Expression operate(IntegerOperand leftOperand, IntegerOperand rightOperand) {
		return new IntegerOperand(leftOperand.getVal()*rightOperand.getVal());
		
	}

	@Override
	public Expression operate(StringOperand leftOperand, StringOperand rightOperand) {
		return new StringOperand(leftOperand.getVal()+rightOperand.getVal());
	}

	@Override
	public Expression operate(IntegerOperand leftOperand, StringOperand rightOperand) {
		String str="";
		for(int i=0;i<leftOperand.getVal();i++)
			str=str+rightOperand.getVal();
		return new StringOperand(str);
		
	}

	@Override
	public Expression operate(StringOperand leftOperand, IntegerOperand rightOperand) {
		return operate(rightOperand,leftOperand);
	}
}

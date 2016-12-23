package com.ge;

public class IntegerOperand extends Expression implements Operand{

	private int val;
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public IntegerOperand(int val){
		this.val=val;
	}
	
	@Override
	public String toString(){
		return val+"";
	}
	
	@Override
	public Expression solve(){
		return this;
	}
	
	@Override
	public Expression accept(IntegerOperand rightOperand, IOperator operator) {
		return operator.operate(this, rightOperand);
	}
	@Override
	public Expression accept(StringOperand rightOperand, IOperator operator) {
		return operator.operate(this, rightOperand);
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

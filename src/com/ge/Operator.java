package com.ge;

public enum Operator {
	PLUS('+',2, new PlusOperator()),
	MUL('*',1, new MulOperator());
	
	private char sign;
	private int priority;
	IOperator operator;
	
	public IOperator getOperator() {
		return operator;
	}
	public void setOperator(IOperator operator) {
		this.operator = operator;
	}
	public static Operator get(char sign){
		for(Operator operator : Operator.values()){
			if(sign==operator.sign)
				return operator;
		}
		throw new IllegalArgumentException("Not a operator");
	}
	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	Operator(char sign,int priority, IOperator operator){
		this.sign=sign;
		this.priority=priority;
		this.operator=operator;
	}

}

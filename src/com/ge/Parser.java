package com.ge;

import java.util.*;

public class Parser {
	
	String input;
	String[] tokens;
	
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	private boolean isOperator(String str){
		if(str.length()!=1)
			return false;
		return isOperator(str.charAt(0));
	}
	
	private boolean isOperator(char ch){
		for(Operator op:Operator.values()){
			if(op.getSign() ==ch)
				return true;
		}
		return false;
	}
	
	private boolean isInteger(String str){
		boolean isInt = true;
		for(char ch: str.toCharArray()){
			if(!(ch>='0' && ch<='9')){
				isInt=false;
				break;
			}
		}
		return isInt;
	}
	
	private boolean isString(String str){
		for(char ch: str.toCharArray()){
			for(Operator op : Operator.values()){
				if(ch==op.getSign())
					return false;
			}
		}
		return true;
	}
	
	List<String> populateTokens(){
		String token="";
		List<String> tokens = new ArrayList<String>();
		for(int i=0;i<input.length();i++){
			if(isOperator(input.charAt(i))){
				tokens.add(token);
				token="";
				tokens.add(input.substring(i, i+1));
			}
			else
				token=token+input.charAt(i);
		}
		tokens.add(token);
		return tokens;
	}
	
	Expression evaluateTokens(int start , int end){
	
		if(end-start==1){
			if(isInteger(tokens[start]))
				return new IntegerOperand(Integer.parseInt(tokens[start]));
			else if(isString(tokens[start]))
				return new StringOperand(tokens[start]);
			else
				throw new IllegalArgumentException("Not a valid expression");
		}
		int lar=0, larIndex=0;
		Operator currentOperator=null;
		for(int i=start;i<end;i++){
			if(isOperator(tokens[i])){
				Operator operator = Operator.get(tokens[i].charAt(0));
				if(operator.getPriority()> lar){
					currentOperator=operator;
					lar=operator.getPriority();
					larIndex=i;
				}
			}
		}
		return new Expression(evaluateTokens(start,larIndex),currentOperator, evaluateTokens(larIndex+1,end) );
	}
	
	public Expression parse(String input){
		this.input = new String(input);
		List<String> tokenList = populateTokens();
		tokens = new String[tokenList.size()];
		int i=0;
		for(String token:tokenList){
			tokens[i]=token;
			i++;
		}
		return evaluateTokens(0,i);
	}

}

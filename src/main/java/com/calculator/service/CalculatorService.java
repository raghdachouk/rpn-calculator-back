package com.calculator.service;

import java.util.*;


import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    private Stack<Double> stack = new Stack<>();
    private Map<String, Stack<Double>> stacks = new HashMap<>();
    
    public void pushToStack(double value) {
        stack.push(value);
    }
   
   
    public void pushToStack(String stackId, double value) {
        stacks.computeIfAbsent(stackId, k -> new Stack<>()).push(value);
    }
    public List<Double> getStack() {
        return new ArrayList<>(stack);
    }

    public List<Double> getStackById(String stackId) {
        Stack<Double> stack = stacks.get(stackId);
        if (stack != null) {
            return new ArrayList<>(stack);
        }
        return null;
    }
    public void clearStack(String stackId) {
        stacks.computeIfAbsent(stackId, k -> new Stack<>()).clear();
    }

    public void add(String stackId) {
    	Stack<Double> stack = stacks.get(stackId);
        if (stack.size() >= 2) {
            double secondOperand = stack.pop();
            double firstOperand = stack.pop();
            double result = firstOperand + secondOperand;
            stack.push(result);
        }
    }
    
 public Map<String, Stack<Double>> getAllStacks() {
    	return stacks;
    	
    }

}

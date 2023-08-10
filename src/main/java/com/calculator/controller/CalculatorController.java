package com.calculator.controller;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.calculator.service.CalculatorService;

@RestController
@RequestMapping("/rpn")
public class CalculatorController {


    @Autowired
    private CalculatorService calculatorService;
    
    @PostMapping("/stack/{stackId}")
    public ResponseEntity<String> pushToStack(@PathVariable String stackId, @RequestParam double value) {
        calculatorService.pushToStack(stackId, value);
        return ResponseEntity.ok("Value pushed to the stack.");
    }
    
    @GetMapping("/stack/{stackId}")
    public ResponseEntity<List<Double>> getStackById(@PathVariable String stackId) {
        List<Double> stack = calculatorService.getStackById(stackId);
        if (stack != null) {
            return ResponseEntity.ok(stack);
        } else {
            return null;
        }
    }
    
    @DeleteMapping("/stack/{stackId}")
    public ResponseEntity<String> clearStack(@PathVariable String stackId) {
        calculatorService.clearStack(stackId);
        return ResponseEntity.ok("Stack cleared.");
    }
   
    @GetMapping("/stack")
    public ResponseEntity< Map<String, Stack<Double>>> getAllStacks() {
    	 Map<String, Stack<Double>> stacks = calculatorService.getAllStacks();
        if (stacks != null) {
            return ResponseEntity.ok(stacks);
        } else {
            return null;
        }
    }

   

}

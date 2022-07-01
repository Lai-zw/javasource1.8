package com.laizhw.designPattern.interpreter.model;

import com.laizhw.designPattern.interpreter.Expression;
import com.laizhw.designPattern.interpreter.SymbolExpression;

import java.util.HashMap;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : AddExpression
 */
public class AddExpression extends SymbolExpression {
    public AddExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}

package com.laizhw.designPattern.interpreter.model;

import com.laizhw.designPattern.interpreter.Expression;

import java.util.HashMap;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : VarExpression
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String _key) {
        this.key = _key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}

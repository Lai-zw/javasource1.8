package com.laizhw.designPattern.interpreter;

import java.util.HashMap;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Expression
 */
public abstract class Expression {

    // 解析公式和数值,其中var中的key值是是公式中的参数，value值是具体的数字
    public abstract int interpreter(HashMap<String,Integer> var);
}

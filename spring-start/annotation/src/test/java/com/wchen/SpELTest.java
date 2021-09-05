package com.wchen;

import org.junit.Test;
import org.springframework.beans.propertyeditors.ClassEditor;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELTest {


    @Test
    public void testSpEL() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#{'hello word'}");
        System.out.println(expression.getValue());
    }

}

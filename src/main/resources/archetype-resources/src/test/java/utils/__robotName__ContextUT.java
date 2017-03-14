#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

import ${package}.utils.${robotName}Context;

public class ${robotName}ContextUT {

    @Test
    public void testConstructorIsPrivate() throws Exception {
        Constructor<${robotName}Context> constructor = ${robotName}Context.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}

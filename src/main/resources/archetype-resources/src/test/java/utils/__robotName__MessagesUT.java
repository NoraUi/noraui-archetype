#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

import ${package}.utils.${robotName}Messages;

public class ${robotName}MessagesUT {

    @Test
    public void testConstructorIsPrivate() throws Exception {
        Constructor<${robotName}Messages> constructor = ${robotName}Messages.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}

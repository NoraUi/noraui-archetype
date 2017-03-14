#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.model.${targetApplication};

import java.util.Collections;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import noraui.model.ModelList;
import noraui.utils.Context;

public class WorkPartyUT {

    @Test
    public void checkWorkPartySerializeTest() {
        // prepare mock
        WorkParty zidane = new WorkParty();
        zidane.setName("Zinédine Zidane");
        zidane.setOrder(10);
        zidane.setRole("Attaquant");

        // run test
        Assert.assertEquals("{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Zinédine Zidane${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Attaquant${symbol_escape}",${symbol_escape}"order${symbol_escape}":10}", zidane.serialize());
    }

    @Test
    public void checkWorkPartyDeserializeTest() {
        // run test
        WorkParty workParty = new WorkParty();
        workParty.deserialize("{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Zinédine Zidane${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Attaquant${symbol_escape}",${symbol_escape}"order${symbol_escape}":10}");
        Assert.assertEquals("Zinédine Zidane", workParty.getName());
        Assert.assertEquals(10, workParty.getOrder());
        Assert.assertEquals("Attaquant", workParty.getRole());
    }

    @Test
    public void checkWorkPartyWithApostropheSerializeTest() {
        // prepare mock
        WorkParty hostis = new WorkParty();
        hostis.setName("Hervé L'HOSTIS");
        hostis.setOrder(10);
        hostis.setRole("Attaquant");

        // run test
        Assert.assertEquals("{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Hervé L'HOSTIS${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Attaquant${symbol_escape}",${symbol_escape}"order${symbol_escape}":10}", hostis.serialize());
    }

    @Test
    public void checkWorkPartyWithApostropheDeserializeTest() {
        // run test
        WorkParty workParty = new WorkParty();
        workParty.deserialize("{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Hervé L'HOSTIS${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Attaquant${symbol_escape}",${symbol_escape}"order${symbol_escape}":10}");
        Assert.assertEquals("Hervé L'HOSTIS", workParty.getName());
        Assert.assertEquals(10, workParty.getOrder());
        Assert.assertEquals("Attaquant", workParty.getRole());
    }

    @Test
    public void checkWorkPartySerializeListTest() {
        // prepare mock
        WorkParty zidane = new WorkParty();
        zidane.setName("Zinédine Zidane");
        zidane.setOrder(10);
        zidane.setRole("Attaquant");

        WorkParty barthez = new WorkParty();
        barthez.setName("Fabien Barthez");
        barthez.setOrder(1);
        barthez.setRole("Gardien de but");

        WorkParty hostis = new WorkParty();
        hostis.setName("Hervé L'HOSTIS");
        hostis.setOrder(12);
        hostis.setRole("Attaquant");

        WorkParties fooballers = new WorkParties();
        fooballers.add(zidane);
        fooballers.add(barthez);
        fooballers.add(hostis);

        // run test
        Assert.assertEquals(
                "[{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Zinédine Zidane${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Attaquant${symbol_escape}",${symbol_escape}"order${symbol_escape}":10},{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Fabien Barthez${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Gardien de but${symbol_escape}",${symbol_escape}"order${symbol_escape}":1},{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Hervé L'HOSTIS${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Attaquant${symbol_escape}",${symbol_escape}"order${symbol_escape}":12}]",
                fooballers.serialize());
    }

    @Test
    public void checkWorkPartyDeserializeListTest() {
        // run test
        WorkParties fooballers = new WorkParties();
        fooballers.deserialize(
                "[{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Zinédine Zidane${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Attaquant${symbol_escape}",${symbol_escape}"order${symbol_escape}":10},{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Fabien Barthez${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Gardien de but${symbol_escape}",${symbol_escape}"order${symbol_escape}":1},{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Hervé L'HOSTIS${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Attaquant${symbol_escape}",${symbol_escape}"order${symbol_escape}":12}]");
        Assert.assertEquals("Zinédine Zidane", fooballers.get(0).getName());
        Assert.assertEquals(10, fooballers.get(0).getOrder());
        Assert.assertEquals("Attaquant", fooballers.get(0).getRole());
        Assert.assertEquals("Fabien Barthez", fooballers.get(1).getName());
        Assert.assertEquals(1, fooballers.get(1).getOrder());
        Assert.assertEquals("Gardien de but", fooballers.get(1).getRole());
        Assert.assertEquals("Hervé L'HOSTIS", fooballers.get(2).getName());
        Assert.assertEquals(12, fooballers.get(2).getOrder());
        Assert.assertEquals("Attaquant", fooballers.get(2).getRole());
    }

    @Test
    public void checkgetModelListTest() throws InstantiationException, IllegalAccessException {
        // prepare mock
        WorkParty zidane = new WorkParty();
        zidane.setName("Zinédine Zidane");
        zidane.setOrder(10);
        zidane.setRole("Attaquant");
        WorkParty barthez = new WorkParty();
        barthez.setName("Fabien Barthez");
        barthez.setOrder(1);
        barthez.setRole("Gardien de but");

        Class<? extends ModelList> c = zidane.getModelList();
        ModelList cl = c.newInstance();
        cl.addModel(zidane);
        cl.addModel(barthez);

        // run test
        Assert.assertEquals("[{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Zinédine Zidane${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Attaquant${symbol_escape}",${symbol_escape}"order${symbol_escape}":10},{${symbol_escape}"name${symbol_escape}":${symbol_escape}"Fabien Barthez${symbol_escape}",${symbol_escape}"role${symbol_escape}":${symbol_escape}"Gardien de but${symbol_escape}",${symbol_escape}"order${symbol_escape}":1}]", cl.serialize());
    }

    @Test
    public void checkDeleteWorkPartiesAndAddWorkPartiesTest() {
        // prepare mock
        WorkParty a = new WorkParty();
        a.setName("A");
        a.setOrder(3);
        a.setRole("stub1");
        WorkParty b = new WorkParty();
        b.setName("B");
        b.setOrder(2);
        b.setRole("stub2");
        WorkParty c = new WorkParty();
        c.setName("C");
        c.setOrder(1);
        c.setRole("stub3");
        WorkParty d = new WorkParty();
        d.setName("D");
        d.setOrder(10);
        d.setRole("stub4");

        WorkParties workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)} = new WorkParties();
        workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.add(a);
        workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.add(b);
        workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.add(c);

        WorkParties workParties = new WorkParties();
        workParties.add(b);
        workParties.add(c);
        workParties.add(d);

        // run test
        WorkParties wpIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)} = (WorkParties) workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.clone();
        wpIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.subtract(workParties);
        Assert.assertEquals(1, wpIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.size());
        Assert.assertEquals("A", wpIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.get(0).getName());

        WorkParties wp = (WorkParties) workParties.clone();
        wp.subtract(workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)});
        Assert.assertEquals(1, wp.size());
        Assert.assertEquals("D", wp.get(0).getName());

        Assert.assertEquals(3, workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.get(0).getOrder());
        Assert.assertEquals(2, workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.get(1).getOrder());
        Assert.assertEquals(1, workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.get(2).getOrder());
        Collections.sort(workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)});
        Assert.assertEquals(1, workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.get(0).getOrder());
        Assert.assertEquals(2, workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.get(1).getOrder());
        Assert.assertEquals(3, workPartiesIn${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.get(2).getOrder());

    }

    /**
     * AfterClass clear Context
     */
    @AfterClass
    public static void tearDownClass() {
        Context.clear();
    }

}

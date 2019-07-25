#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * ${robotName} generated free by NoraUi Organization https://github.com/NoraUi
 * ${robotName} is licensed under the license BSD.
 * CAUTION: ${robotName} use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 *
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package ${package}.application.business.logogame;

import java.util.ArrayList;
import java.util.List;

public class ProhibitedBrands {
    private static List<String> tabaco;
    private static List<String> alcool;

    // Tabaco
    private static String MARLBORO = "Marlboro";
    private static String CAMEL = "Camel";
    private static String PHILIPPE_MORRIS = "philippe morris";

    // Alcool
    private static String HEINEKEN = "heineken";
    private static String ZUBROWKA = "zubrowka";
    private static String JACK_DANIELS = "jack daniels";

    public static List<String> getTabaco() {
        tabaco = new ArrayList<>();
        tabaco.add(MARLBORO);
        tabaco.add(CAMEL);
        tabaco.add(PHILIPPE_MORRIS);
        return tabaco;
    }

    public static List<String> getAlcool() {
        alcool = new ArrayList<>();
        alcool.add(HEINEKEN);
        alcool.add(ZUBROWKA);
        alcool.add(JACK_DANIELS);
        return alcool;
    }

}

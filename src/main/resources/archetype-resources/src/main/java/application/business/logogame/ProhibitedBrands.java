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
    private static final String MARLBORO = "Marlboro";
    private static final String CAMEL = "Camel";
    private static final String PHILIPPE_MORRIS = "philippe morris";

    // Alcool
    private static final String HEINEKEN = "heineken";
    private static final String ZUBROWKA = "zubrowka";
    private static final String JACK_DANIELS = "jack daniels";

    public ProhibitedBrands() {
        // Tabaco
        tabaco = new ArrayList<>();
        tabaco.add(MARLBORO);
        tabaco.add(CAMEL);
        tabaco.add(PHILIPPE_MORRIS);

        // Alcool
        alcool = new ArrayList<>();
        alcool.add(HEINEKEN);
        alcool.add(ZUBROWKA);
        alcool.add(JACK_DANIELS);
    }

    public List<String> getTabaco() {
        return tabaco;
    }

    public List<String> getAlcool() {
        return alcool;
    }

}

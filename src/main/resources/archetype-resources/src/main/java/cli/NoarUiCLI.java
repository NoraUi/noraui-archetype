#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * ${robotName} generated free by NoraUi Organization https://github.com/NoraUi
 * ${robotName} is licensed under the license BSD.
 * 
 * CAUTION: ${robotName} use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package ${package}.cli;

import com.github.noraui.cli.NoraUiCommandLineInterface;
import com.github.noraui.exception.TechnicalException;
import ${package}.utils.${robotName}Context;

public class NoarUiCLI {
    
    /**
     * Java sample:
     * > cd target\classes
     * > java -cp . ${package}.cli.NoarUiCLI -h
     * Maven sample:
     * > mvn exec:java -Dexec.mainClass="${package}.cli.NoarUiCLI" -Dexec.args="-h"
     * 
     * @param args
     *            is list of args (-h, --verbose, --interactiveMode, -f, -s, -u, -d, -k, -a, -m, -fi and -re (optional))
     * @throws TechnicalException
     */
    public static void main(String[] args) throws TechnicalException {
        new NoraUiCommandLineInterface().runCli(${robotName}Context.class, args);
    }

}

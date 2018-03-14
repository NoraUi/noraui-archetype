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

import com.github.noraui.cli.Application;
import com.github.noraui.cli.Scenario;

import ${package}.utils.${robotName}Context;

public class NoarUiCLI {

    public static void main(String[] args) {
        boolean verbose = false;
        String feature = null;
        String applicationName = null;
        String scenarioName = null;
        String url = null;
        String description = null;

        System.out.println("");
        System.out.println("  ███╗   ██╗ ██████╗ ██████╗  █████╗ ██╗   ██╗██╗      ██████╗██╗     ██╗ ");
        System.out.println("  ████╗  ██║██╔═══██╗██╔══██╗██╔══██╗██║   ██║██║     ██╔════╝██║     ██║ ");
        System.out.println("  ██╔██╗ ██║██║   ██║██████╔╝███████║██║   ██║██║     ██║     ██║     ██║ ");
        System.out.println("  ██║╚██╗██║██║   ██║██╔══██╗██╔══██║██║   ██║██║     ██║     ██║     ██║ ");
        System.out.println("  ██║ ╚████║╚██████╔╝██║  ██║██║  ██║╚██████╔╝██║     ╚██████╗███████╗██║ ");
        System.out.println("  ╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝      ╚═════╝╚══════╝╚═╝ ");
        System.out.println("");
        System.out.println(" NoraUi Command Line Interface =>");
        System.out.println("");

        if (args.length == 0 || args.length == 1 && args[0].equals("-h")) {
            System.out.println("-h: Display this help");
            System.out.println("--verbose: Add debug informations in console.");
            System.out.println("-f: features 1 => add new application");
            System.out.println(" 2 => add new scenario");
            System.out.println("-s: Scenario Name");
            System.out.println("-u: Url");
            System.out.println("-d: Description");
            System.out.println("-a: Application Name");
        }

        for (int i = 0; i < args.length; i++) {
            if ("--verbose".equals(args[i])) {
                verbose = true;
            } else if ("-f".equals(args[i])) {
                feature = args[i + 1];
            } else if ("-s".equals(args[i])) {
                scenarioName = args[i + 1];
            } else if ("-u".equals(args[i])) {
                url = args[i + 1];
            } else if ("-d".equals(args[i])) {
                description = args[i + 1];
            } else if ("-a".equals(args[i])) {
                applicationName = args[i + 1];
            }
        }

        if (verbose) {
            System.out.print("Command Line: ");
            for (String arg : args) {
                System.out.print(" " + arg);
            }
            System.out.println("");
        }
        
        if ("1".equals(feature)) {
            Application application = new Application();
            application.add(applicationName, url, ${robotName}Context.class, "${robotName}", verbose);
        } else if ("2".equals(feature)) {
            Scenario scenario = new Scenario();
            scenario.add(scenarioName, description, applicationName, "${robotName}", verbose);
        }

    }

}

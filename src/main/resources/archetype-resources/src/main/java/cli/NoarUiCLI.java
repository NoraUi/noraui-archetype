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
import ${package}.utils.NoraRobotContext;

public class NoarUiCLI {

    public static void main(String[] args) {
        boolean verbose = false;
        String feature = null;
        String name = null;
        String url = null;

        System.out.println("");
        System.out.println("  ███╗   ██╗ ██████╗ ██████╗  █████╗ ██╗   ██╗██╗      ██████╗██╗     ██╗ ");
        System.out.println("  ████╗  ██║██╔═══██╗██╔══██╗██╔══██╗██║   ██║██║     ██╔════╝██║     ██║ ");
        System.out.println("  ██╔██╗ ██║██║   ██║██████╔╝███████║██║   ██║██║     ██║     ██║     ██║ ");
        System.out.println("  ██║╚██╗██║██║   ██║██╔══██╗██╔══██║██║   ██║██║     ██║     ██║     ██║ ");
        System.out.println("  ██║ ╚████║╚██████╔╝██║  ██║██║  ██║╚██████╔╝██║     ╚██████╗███████╗██║ ");
        System.out.println("  ╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝      ╚═════╝╚══════╝╚═╝ ");
        System.out.println("");

        if (args.length == 0 || args.length == 1 && args[0].equals("-h")) {
            System.out.println("-h: Display this help");
            System.out.println("--verbose: Add debug informations in console.");
            System.out.println("-f: features 1 => add new application");
            System.out.println(" 2 => add new scenario");
        }

        for (int i = 0; i < args.length; i++) {
            if ("--verbose".equals(args[i])) {
                verbose = true;
            } else if ("-f".equals(args[i])) {
                feature = args[i + 1];
            } else if ("-n".equals(args[i])) {
                name = args[i + 1];
            } else if ("-u".equals(args[i])) {
                url = args[i + 1];
            }
        }

        if ("1".equals(feature)) {
            Application application = new Application();
            application.add(name, url, NoraRobotContext.class, "${robotName}", verbose);
        } else if ("2".equals(feature)) {

        }

    }

}

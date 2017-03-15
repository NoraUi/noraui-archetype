#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.indus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ${package}.utils.${robotName}Context;

import noraui.indus.MavenRunCounter;
import noraui.utils.Context;

public class Counter {

    public static void main(String[] args) {
        List<String> manager = new ArrayList<>();

        List<String> scenarioBlacklist = new ArrayList<>();

        List<String> versionControlSystemsBlacklist = new ArrayList<>();
        versionControlSystemsBlacklist.add(".svn");

        ${robotName}Context.getInstance().initializeEnv("${robotName}.properties");

        MavenRunCounter mavenRunCounter = new MavenRunCounter();
        List<MavenRunCounter.Counter> counters = mavenRunCounter.count(versionControlSystemsBlacklist, scenarioBlacklist, manager, new File(Context.getResourcesPath() + "/steps"));
        mavenRunCounter.print(counters);
    }

}

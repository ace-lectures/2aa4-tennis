package ca.mcscert.se2aa4.demos.tennis;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.;

public class Main {

    public static int PLAYER1_STRENGTH;
    public static int PLAYER2_STRENGTH;
    Logger logger = new LogManager(main.class.getName());
    public static void main(String[] args) {

        Logger.info("** Starting Tennis Counter Assistant");
        System.out.println("**** Reading Command-Line Arguments");
        Options options = new Options();
        options.addOption("p1", true, "Strength of Player 1 in [0,100]");
        options.addOption("p2", true, "Strength of Player 2 in [0,100]");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            PLAYER1_STRENGTH = Integer.parseInt(cmd.getOptionValue("p1","50"));
            System.out.println("****** P1's Strength is " + PLAYER1_STRENGTH+"/100");
            PLAYER2_STRENGTH = Integer.parseInt(cmd.getOptionValue("p2","50"));
            System.out.println("****** P2's Strength is " + PLAYER2_STRENGTH+"/100");
        } catch (ParseException pe) {
            System.err.println("An error has occurred");
        }
        System.out.println("**** Starting game");
        System.out.println("** TODO...");
        System.out.println("** Closing Tennis Counter Assistant");
    }
}

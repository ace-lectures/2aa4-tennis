package ca.mcscert.se2aa4.demos.tennis;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static int PLAYER1_STRENGTH;
    public static int PLAYER2_STRENGTH;

    protected static final Logger logger = LogManager.getLogger();

    private record Configuration(Integer p1Strength, Integer p2Strength) {
        Configuration {
            if (p1Strength < 0 || p1Strength > 100)
                throw new IllegalArgumentException("P1's Strength not in [0,100]: " + p1Strength);
            if (p2Strength < 0 || p2Strength > 100)
                throw new IllegalArgumentException("P2's Strength not in [0,100]: " + p2Strength);
        }
    }

    private static Configuration configure(String[] commandLineArguments) throws ParseException {
        Options options = new Options();
        options.addOption("p1", true, "Strength of Player 1 in [0,100]");
        options.addOption("p2", true, "Strength of Player 2 in [0,100]");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, commandLineArguments);
        Integer p1 = Integer.parseInt(cmd.getOptionValue("p1", "50"));
        Integer p2 = Integer.parseInt(cmd.getOptionValue("p2", "50"));
        return new Configuration(p1, p2);
    }

    public static void main(String[] args) {
        logger.info("** Starting Tennis Counter Assistant");
        logger.info("**** Reading Command-Line Arguments");
        try {
            Configuration config = configure(args);
            System.out.println(config);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            logger.error("An error has occurred: " + e);
            System.exit(1);
        }
        logger.info("**** Starting game");
        logger.debug("** TODO...");
        logger.info("** Closing Tennis Counter Assistant");

    }
}

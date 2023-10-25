package edu.project2;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utility {
    private Utility() {
    }

    public static final Logger LOGGER = LogManager.getLogger();
    public static Scanner input = new Scanner(System.in);

    public enum Cell { PASSAGE, WALL, WAY, DEATH }

    public enum GeneratorType { Kruskal }

    public enum SolverType { RightHand }

    public static final String PASSAGE_STRING = "   ";
    public static final String WALL_STRING = "███";
    public static final String WAY_STRING = " ◈ ";
    public static final String DEATH_STRING = " ☠ ";

    public static final int DEFAULT_MAZE_SIZE = 15;

    public static final String NO_SUCH_TYPE_ERROR = "There is no such type, refer to the help";
    public static final String GRID_IS_EMPTY_ERROR = "Grid is empty!";
}

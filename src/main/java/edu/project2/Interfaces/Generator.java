package edu.project2.Interfaces;

import edu.project2.Utility.Cell;

public interface Generator {
    Cell[][] generate(int width, int height, int seed);
}

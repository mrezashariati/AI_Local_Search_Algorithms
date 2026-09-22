# AI_Local_Search_Algorithms

Local search algorithms for finding the minimum of a 1-D array, written in Java (2019).

**Aim:** implement and visualise classic local search methods on a simple landscape. The array is generated with a linear congruential generator, so it has many local minima.

**How it works:** `Main` asks for the array size and an algorithm, runs the search from a random start, and prints the minimum found next to the true minimum. It then plots the search path and the array with the [GRAL](https://github.com/eseifert/gral) charting library.

**Implemented:** hill climbing and gradient descent. Simulated annealing, local beam search and the genetic algorithm are placeholder classes that are not implemented yet.

**AI use:** none.

## Run

Needs a JDK and the GRAL library (`de.erichseifert.gral`) on the classpath. Open `src/` in an IDE and run `AI_Local_Search.Main`.

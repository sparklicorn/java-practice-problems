# java-practice-problems
Programming challenges for beginner programmers.

### How to use
- Clone this repo somewhere on your machine. `git clone https://github.com/sparklicorn/practice-problems.git`
- Find an interesting problem to solve. See the list below.
- Implement your solutions in the provided method stubs.
- Run the provided JUnit tests to check your solutions.
  - You can use your IDE testing tools or ![Maven](https://maven.apache.org/) for this. There is a Maven wrapper script included in this repo for convenience.
  - `./mvnw test`
  - Or to run a single test file `mvn test -Dtest=classname`, e.g. `mvn test -Dtest=SudokuProblem1Test`
  - Or to run a single test method `mvn test -Dtest=classname#methodname`, e.g.`mvn test -Dtest=SudokuProblem1Test#isRowValid`

### Index
- General
  - ![(code)](https://github.com/sparklicorn/java-practice-problems/blob/master/src/main/java/sparklicorn/general/GeneralProblem1_PrimeNumbers.java) Check if a number is prime.
- Loops
  - ![(code)](https://github.com/sparklicorn/java-practice-problems/blob/master/src/main/java/sparklicorn/loops/LoopsProblem1_Fibonacci.java) Get the nth number of the Fibonacci sequence.
- Arrays
  - ![(code)](https://github.com/sparklicorn/java-practice-problems/blob/master/src/main/java/sparklicorn/arrays/ArraysProblem1_UniqueDigits.java) Check whether an array contains the digits 1 through 9 with no duplicates.
  - ![(code)](https://github.com/sparklicorn/java-practice-problems/blob/master/src/main/java/sparklicorn/arrays/ArraysProblem2_MinAndMax.java) Get the minimum and maximum values in an array.
- Sudoku ![(code)](https://github.com/sparklicorn/java-practice-problems/blob/master/src/main/java/sparklicorn/sudoku/SudokuProblems.java) - (Loops and array heavy)
  - Determine whether a row is valid.
  - Determine whether a column is valid.
  - Determine whether a region is valid.
  - Determine whether a row is full.
  - Determine whether a column is full.
  - Determine whether a region is full.
  - Determine whether the board is valid.
  - Determine whether the board is full.
  - Determine whether the board is complete.

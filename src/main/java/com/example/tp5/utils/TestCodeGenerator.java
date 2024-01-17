package com.example.tp5.utils;

/**
 * Utility for generating test code.
 */
public final class TestCodeGenerator {

    private TestCodeGenerator() {
        throw new AssertionError("This class should not be instantiated.");
    }

    /**
     * Entry point to generate test code for quadratic equation solving.
     *
     * @param args Command-line arguments (not used in this utility).
     */
     public static void main(final String[] args) {

        String testCaseFile = "testCases.txt";
        String filePath = "src/test/java/com/example/tp5/QuadraticEquationSolverTest.java";
        String testPrefixMethod = "testSolve";

        QuadraticEquationTestUtility.generateTestCodeAndWriteToFile(testCaseFile, filePath, testPrefixMethod);

    }

}

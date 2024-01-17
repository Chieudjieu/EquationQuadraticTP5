package com.example.tp5.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility for generating test code for Quadratic Equation Solver.
 */
public final class QuadraticEquationTestUtility {

    private QuadraticEquationTestUtility() {
        // Private constructor to prevent instantiation
    }

    /**
     * Generates test code and writes it to a file.
     *
     * @param testCaseFile      The test case file path.
     * @param filePath          The file path to write the generated test code.
     * @param testPrefixMethod  The prefix for test method names.
     */
    public static void generateTestCodeAndWriteToFile(
        final String testCaseFile,
        final String filePath,
        final String testPrefixMethod) {
        String fileHeader = "package com.example;\n"
        + "import static org.junit.Assert.assertEquals;\n"
        + "import org.junit.Test;\n"
        + "import java.io.FileWriter;\n"
        + "import java.io.IOException;\n"
        + "import java.io.PrintWriter;\n"
        + "import java.lang.reflect.InvocationTargetException;\n\n"
        + "public class QuadraticEquationSolverTest {\n\n"
        + " private static void writeResultToCSV(String testName,String x1,"
        + "String x2, String result, boolean isSuccess) {\n"
        + "    try (PrintWriter writer = new PrintWriter(new FileWriter(\"test_results.csv\", true))) {\n"
        + "        writer.println(testName + \",                                    "
        + "           \" + x1 + \",            \" + x2 + \",        \" + result + \","
        + "      \" + (isSuccess ? \"Passed\" : \"Failed\") );\n"
        + "    } catch (IOException e) {\n"
        + "        e.printStackTrace();\n"
        + "    }\n"
        + " }\n\n";

        String fileFooter = "}\n";

        String fileContent = "";

        try (BufferedReader br = new BufferedReader(new FileReader(testCaseFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");

                 // Add a check to ensure the array has the expected length
                 final int minumunLineLenght = 4;
                if (values.length < minumunLineLenght) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }
                final int indexOfA = 1;
                final int indexOfB = 2;
                final int indexOfC = 3;

                System.out.println("String " + values[1]);
                Map<String, Double> a = equivalentClassesRandomValue(values[indexOfA]);
                Map<String, Double> b = equivalentClassesRandomValue(values[indexOfB]);
                Map<String, Double> c = equivalentClassesRandomValue(values[indexOfC]);
                System.out.println("a " + a + " b " + b + " c " + c);


                String testName = testPrefixMethod;
                String aKey = "";
                String bKey = "";
                String cKey = "";

                for (String key : a.keySet()) {
                    aKey = key;
                }
                 for (String key : b.keySet()) {
                    bKey = key;
                }
                for (String key : c.keySet()) {
                    cKey = key;
                }


                fileContent += generateTestCode(testName + aKey + bKey + cKey, a.get(aKey), b.get(bKey), c.get(cKey));
                System.out.println("fileContent " + fileContent);

            }
        } catch (IOException e) {
            System.out.println("HERE " + e);

            e.printStackTrace();
        }


         try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(fileHeader + fileContent + fileFooter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private  static String generateTestCode(final String testName, final double a,
    final double b, final double c) {

        final double tolerance = 1e-5;
        if (Math.abs(a) < tolerance) {


            return String.format(
                " @Test(expected = InvocationTargetException.class)\n"
                + " public void %s() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException"
                + ", NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {\n"
                + "        double a = %s;\n"
                + "        double b = %s;\n"
                + "        double c = %s;\n\n"
                + "        Class<?> dynamicClass = Class.forName(\"com.example.equation.QuadraticEquationSolver\");\n"
                + "        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();\n"
                + "        try {\n"
                + "          writeResultToCSV(\"(\"+a+\")\"+\"x^2 + \"+\"(\"+b+\")\"+\"x + \"+\"(\"+c+\")\"+\" "
                + "= 0\", \"N/a\", \"N/a\", \"liniear equation\", true);\n"
                + "          dynamicClass.getMethod(\"solve\", double.class, double.class, double.class)."
                + "invoke(dynamicObject, a, b, c);\n"
                + "        } catch (IllegalArgumentException e) {\n"
                + "          System.err.println(e.getMessage());\n"
                + "         }\n"
                + " }\n\n\n",
                testName, a, b, c);
        } else {
            return String.format(
                " @Test\n"
                + " public void %s() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException"
                + ", NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {\n"
                + "        double a = %s;\n"
                + "        double b = %s;\n"
                + "        double c = %s;\n\n"
                + "        Class<?> dynamicClass = Class.forName(\"com.example.equation.QuadraticEquationSolver\");\n"
                + "        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();\n"
                + "        try {\n"
                + "          double[] solutions = (double[]) dynamicClass.getMethod(\"solve\", double.class, "
                + "double.class, double.class).invoke(dynamicObject, a, b, c);\n"
                + "          if (solutions.length > 0) {\n"
                + "              System.out.print(\"Solutions : \");\n"
                + "              double expected = 0;\n"
                + "              for (double solution : solutions) {\n"
                + "                  System.out.print(solution + \" \");\n"
                + "                  // Use assert for each solution\n"
                + "                  expected = a * Math.pow(solution, 2) + (b * solution) + c;\n"
                + "                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));\n"
                + "                  double delta = maxMagnitude * 1e-7; "
                + "// You can adjust this multiplier based on your desired precision\n"
                + "                  assertEquals(0, expected, delta);\n"
                + "              }\n"
                + "              writeResultToCSV(\"(\"+a+\")\"+\"x^2 + \"+\"(\"+b+\")\"+\"x + \"+\"(\"+c+\")\"+\" "
                + "= 0\", \"\" + solutions[0], \"\"+solutions[1], \"\"+expected, true);\n"
                + "          } else {\n"
                + "              System.out.println(\"Pas de solution réelle.\");\n"
                + "              // Use assert for the case with no solution\n"
                + "              assertEquals(0, solutions.length);\n"
                + "              writeResultToCSV(\"(\"+a+\")\"+\"x^2 + \"+\"(\"+b+\")\"+\"x + \"+\"(\"+c+\")\"+\" "
                + "= 0\", \"N/a\", \"N/a\", \" \", true);\n"
                + "          }\n"
                + "        } catch (IllegalArgumentException e) {\n"
                + "          System.err.println(e.getMessage());\n"
                + "         }\n"
                + " }\n\n\n",
                testName, a, b, c);
        }
    }

    /**
     * Provides a random value in the corresponding equivalent class.
     *
     * @param input The input string representing the value.
     * @return A map containing the equivalent class label and its corresponding value.
     */
    static Map<String, Double> equivalentClassesRandomValue(final String input) {
    Map<String, Double> result = new HashMap<>();

    final int caracterIndex = 3;
        System.out.println("input:" + input + "lenght:" + input.length() + "character" + input.charAt(caracterIndex));

        char letter = input.charAt(caracterIndex);

        double value = 0.0;
        String label;
        if (input.contains("1")) {
            label = "A";
        } else if (input.contains("2")) {
            label = "B";
        } else {
            label = "C";
        }

        System.out.println("letter" + letter);

        switch (letter) {
            case 'a':
                value = 0.0;
                label = label + "zero";
                break;
            case 'b':
                final double minimunBoundB = 1e-7;
                final double maximumBoundB = 1e-6;
                value = ThreadLocalRandom.current().nextDouble(minimunBoundB, maximumBoundB);
                label = label + "tresProcheDeZeroPositif";
                break;
            case 'c':
                final double minimunBoundC = -1e-6;
                final double maximumBoundC = -1e-7;
                value = ThreadLocalRandom.current().nextDouble(minimunBoundC, maximumBoundC);
                label = label + "tresProcheDeZeroNegatif";
                break;
            case 'd':
                final double minimunBoundD = 1;
                final double maximumBoundD = 5;
                value = ThreadLocalRandom.current().nextDouble(minimunBoundD, maximumBoundD);
                label = label + "procheDeZeroPositif";
                break;
            case 'e':
                final double minimunBoundE = -5;
                final double maximumBoundE = -1;
                value = ThreadLocalRandom.current().nextDouble(minimunBoundE, maximumBoundE);
                label = label + "procheDeZeroNegatif";
                break;
            case 'f':
                final double minimunBoundF = 10;
                final double maximumBoundF = 500;
                value = ThreadLocalRandom.current().nextDouble(minimunBoundF, maximumBoundF);
                label = label + "positifNormal";
                break;
            case 'g':
                final double minimunBoundG = -500;
                final double maximumBoundG = -10;
                value = ThreadLocalRandom.current().nextDouble(minimunBoundG, maximumBoundG);
                label = label + "negatifNormal";
                break;
            case 'h':
                final double minimunBoundH = 1e6;
                final double maximumBoundH = 1e9;
                value = ThreadLocalRandom.current().nextDouble(minimunBoundH, maximumBoundH);
                label = label + "tresGrandPositif";
                break;
            case 'i':
                final double minimunBoundI = -1e9;
                final double maximumBoundI = -1e6;
                value = ThreadLocalRandom.current().nextDouble(minimunBoundI, maximumBoundI);
                label = label + "tresGrandNegatif";
                break;
            default:
                throw new IllegalArgumentException("Caractère invalide dans la chaîne d'entrée.");
        }

        result.put(label, value);
        return result;
    }

}

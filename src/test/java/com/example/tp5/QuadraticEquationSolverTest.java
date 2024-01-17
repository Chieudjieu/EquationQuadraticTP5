package com.example.tp5;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

public class QuadraticEquationSolverTest {

 private static void writeResultToCSV(String testName,String x1,String x2, String result, boolean isSuccess) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("test_results.csv", true))) {
        writer.println(testName + ",                                               " + x1 + ",            " + x2 + ",        " + result + ",      " + (isSuccess ? "Passed" : "Failed") );
    } catch (IOException e) {
        e.printStackTrace();
    }
 }

 @Test(expected = InvocationTargetException.class)
 public void testSolveAzeroBtresGrandNegatifCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -3.9844698090782166E8;
        double c = 9.497409295194E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBtresProcheDeZeroPositifCtresGrandNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.448858037570602E-7;
        double b = 6.162818740420471E-7;
        double c = -2.92937832708508E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBtresGrandPositifCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.4789625878037005E-7;
        double b = 7.291481434641938E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBtresProcheDeZeroNegatifCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.228108790692284;
        double b = -9.497430670648392E-7;
        double c = -7.508014671821106E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroNegatifBprocheDeZeroNegatifCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.055275323727194;
        double b = -1.1702845319202702;
        double c = 112.942610665898;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBnegatifNormalCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 138.6626497806807;
        double b = -304.27997456592215;
        double c = -1.4026661544369161;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBzeroCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -225.70111811849046;
        double b = 0.0;
        double c = 2.813966533634723E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBprocheDeZeroPositifCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.878515332072644E7;
        double b = 2.7547446410450194;
        double c = 4.1642647552077054;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandNegatifBpositifNormalCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.2259928015677238E8;
        double b = 330.9957299812011;
        double c = -126.39904952863952;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAzeroBzeroCtresGrandNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 0.0;
        double c = -2.9114270702673805E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBzeroCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 9.114847319807725E-7;
        double b = 0.0;
        double c = 2.8486730033559966;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBzeroCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -5.804133115839497E-7;
        double b = 0.0;
        double c = -4.536375765707808;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBzeroCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.423090187549444;
        double b = 0.0;
        double c = 9.074399035006839E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroNegatifBzeroCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.255179554334218;
        double b = 0.0;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBzeroCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 419.44457369306883;
        double b = 0.0;
        double c = 98.45457155918746;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBtresProcheDeZeroPositifCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -115.9905836753889;
        double b = 6.366064117052899E-7;
        double c = -400.8255514720088;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBzeroCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.002817410053134E8;
        double b = 0.0;
        double c = -9.123206702635902E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandNegatifBzeroCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.7599358732189703E8;
        double b = 0.0;
        double c = 148.37689821759955;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAzeroBtresProcheDeZeroNegatifCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -3.384093876447353E-7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAzeroBprocheDeZeroPositifCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 3.9710509443048316;
        double c = -1.0100341356558897;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAzeroBprocheDeZeroNegatifCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -1.421631226566665;
        double c = 4.467134279112804;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAzeroBpositifNormalCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 182.8112333666313;
        double c = -9.894448380700977E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAzeroBnegatifNormalCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -378.35234942064534;
        double c = -28.268991981146257;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAzeroBtresGrandPositifCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 7.898267213764306E8;
        double c = 6.804655506899589E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBtresGrandNegatifCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.3920612749166653E-7;
        double b = -6.7276414173206E8;
        double c = -8.250442812154669E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBprocheDeZeroNegatifCtresGrandNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -5.390385675561289E-7;
        double b = -3.184647225549178;
        double c = -8.066900041223235E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBtresGrandNegatifCtresGrandNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.670803579627695;
        double b = -2.226817252355746E8;
        double c = -6.62067585756794E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroNegatifBtresProcheDeZeroNegatifCtresGrandNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.1866024228977343;
        double b = -9.38447844429401E-7;
        double c = -6.217495103003886E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBtresGrandPositifCtresGrandNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 354.00791590024176;
        double b = 2.0276915045493537E8;
        double c = -3.239016505623269E7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBprocheDeZeroPositifCtresGrandNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -226.69842655019949;
        double b = 1.898331785770123;
        double c = -4.742978044590382E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBpositifNormalCtresGrandNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 9.303725854315501E8;
        double b = 360.903249910013;
        double c = -7.779343087054068E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandNegatifBnegatifNormalCtresGrandNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -9.424159254365957E8;
        double b = -386.37514492826574;
        double c = -7.398423399460528E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAzeroBtresProcheDeZeroPositifCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 4.4052594998527175E-7;
        double c = 348.9723306335179;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBprocheDeZeroPositifCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.464848398659973E-7;
        double b = 3.800293030149838;
        double c = 8.078194419686115E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroNegatifBtresGrandNegatifCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.5446069456769904;
        double b = -9.010911734030446E8;
        double c = 5.721475957088374E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBtresGrandNegatifCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -6.898268720297652E-7;
        double b = -1.4354996292394626E8;
        double c = -300.18078757020965;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBprocheDeZeroPositifCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.5779709685320564;
        double b = 3.3482324633556075;
        double c = -118.70338228265337;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBprocheDeZeroNegatifCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 78.33674260744141;
        double b = -3.3195563893029694;
        double c = -86.3891675758997;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBtresProcheDeZeroNegatifCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -423.1135859641165;
        double b = -6.816695799739804E-7;
        double c = 220.06110783685986;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBtresGrandPositifCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 9.588782481260835E8;
        double b = 8.195182673438836E8;
        double c = -395.4175229781376;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandNegatifBprocheDeZeroPositifCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -9.33325363278295E8;
        double b = 2.089132483964176;
        double c = 2.5582372925129288E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroNegatifBtresProcheDeZeroPositifCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.6454854462125756;
        double b = 6.741724533465925E-7;
        double c = -3.527009541501275;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBpositifNormalCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.9833449753243994E-7;
        double b = 481.37324716981163;
        double c = 89.44486032171122;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBnegatifNormalCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.623976456050006E8;
        double b = -217.67407134628905;
        double c = 4.379837900343996E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBpositifNormalCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 179.08209670676234;
        double b = 342.17081964065517;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBpositifNormalCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -5.246464628467939E-7;
        double b = 186.73561925947348;
        double c = 6.961657078565411E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBnegatifNormalCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.7066757410443272E-7;
        double b = -187.88187410271053;
        double c = 1.8425590764743216;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBtresGrandPositifCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.613167802905851;
        double b = 1.2139375246975297E8;
        double c = -3.6873284053717055;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBtresGrandPositifCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -222.21353285887824;
        double b = 6.318859313965137E8;
        double c = 2.8666288087522194;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandNegatifBtresGrandNegatifCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.824005969739499E8;
        double b = -2.7487697681317186E8;
        double c = 3.207315493510707;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBtresProcheDeZeroPositifCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 144.92728279597043;
        double b = 7.875778649068852E-7;
        double c = 4.480494001516365;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBtresProcheDeZeroNegatifCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.824181495842209E-7;
        double b = -2.59656238239836E-7;
        double c = -410.65665217494427;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBprocheDeZeroNegatifCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.030696158582091E-7;
        double b = -3.780021658831163;
        double c = 7.372265511872588E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBprocheDeZeroPositifCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 52.3016666375562;
        double b = 1.1418906978010894;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandNegatifBprocheDeZeroNegatifCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.152446880784503E8;
        double b = -3.990604230275874;
        double c = 7.337067543212269E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBnegatifNormalCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -440.715001939739;
        double b = -412.326456993955;
        double c = -9.36017120194856E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBtresProcheDeZeroPositifCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.385262914328235;
        double b = 9.286902558426363E-7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroNegatifBpositifNormalCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.0133549169788667;
        double b = 257.96914093541466;
        double c = -121.69696567975762;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBtresGrandNegatifCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.091814089550015E8;
        double b = -7.987392997101855E8;
        double c = -1.4998171643438378;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBtresProcheDeZeroNegatifCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 183.93404174261912;
        double b = -3.8636349337708937E-7;
        double c = 3.8176521868711506E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandNegatifBtresProcheDeZeroPositifCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.1512435907139504E8;
        double b = 1.8824311257381422E-7;
        double c = -1.4673732871101078E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBnegatifNormalCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.695929616984837E-7;
        double b = -403.30593752757795;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBtresGrandPositifCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.138629907234101;
        double b = 3.4804883113111585E8;
        double c = 65.84383108418767;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBtresProcheDeZeroPositifCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -9.391023274812914E-7;
        double b = 6.551673758263153E-7;
        double c = 9.062065363121247E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroNegatifBtresGrandPositifCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.77289744012494;
        double b = 6.625927354574168E8;
        double c = 4.797081128812481;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBprocheDeZeroNegatifCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -300.0707683025451;
        double b = -1.8275902610927788;
        double c = 8.764079353608209E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBprocheDeZeroNegatifCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.1890765037313871E8;
        double b = -4.017705928694692;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandNegatifBtresProcheDeZeroNegatifCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.003273716032073E8;
        double b = -7.443626630987546E-7;
        double c = -4.576238986110175;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBprocheDeZeroPositifCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.444022692918289E-7;
        double b = 1.3876751627103383;
        double c = -4.6772561275211013E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBpositifNormalCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.6982936935668387;
        double b = 118.25924724480869;
        double c = 2.4113066738469857E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBtresProcheDeZeroPositifCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.330281344052917E8;
        double b = 2.897756116902203E-7;
        double c = 2.6487173423400445E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBtresGrandNegatifCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.0547367651065958E8;
        double b = -6.558058791017224E8;
        double c = 200.49758405472406;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroNegatifBnegatifNormalCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.3249801321745744;
        double b = -452.9748689441322;
        double c = 6.828418548998597E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBtresGrandNegatifCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -390.34837101462136;
        double b = -2.0053450801811612E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandPositifBtresProcheDeZeroNegatifCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 7.525359795056026E8;
        double b = -3.386180926778921E-7;
        double c = 3.4095711069433112;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBtresGrandPositifCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 7.664895400811941E-7;
        double b = 6.532867724990045E8;
        double c = -4.88025227938052E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBpositifNormalCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -213.06210442418654;
        double b = 141.91120397495808;
        double c = -2.8797106708273685;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBprocheDeZeroNegatifCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.7368881397688125;
        double b = -4.319689944353771;
        double c = -4.389636579473568;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBtresGrandNegatifCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 274.2313196688011;
        double b = -9.455266155989764E8;
        double c = -6.140812468878827E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBprocheDeZeroPositifCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.415030221562744E-7;
        double b = 3.4475489747220043;
        double c = 496.4701501118908;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBnegatifNormalCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.2771619233490163;
        double b = -70.32283062826974;
        double c = 1.8362456352047043;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroNegatifBprocheDeZeroPositifCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.9031991921183233;
        double b = 3.283830339036784;
        double c = -9.392347395869143E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAtresGrandNegatifBtresGrandPositifCzero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.779811011388378E8;
        double b = 6.854097499658059E7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroNegatifBtresProcheDeZeroNegatifCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -9.016179592627655E-7;
        double b = -7.60203643397496E-7;
        double c = 7.139719996493218E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBtresProcheDeZeroPositifCprocheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.972344790538169E-7;
        double b = 8.231766502872619E-7;
        double c = -1.8239738592996124;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBzeroCtresGrandPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 160.7257095915275;
        double b = 0.0;
        double c = 3.19293036729268E8;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAnegatifNormalBzeroCnegatifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -272.07295500296766;
        double b = 0.0;
        double c = -32.227619629202024;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBprocheDeZeroNegatifCtresProcheDeZeroNegatif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.3793231748110606;
        double b = -4.878514046252487;
        double c = -4.579497908313702E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test(expected = InvocationTargetException.class)
 public void testSolveAtresProcheDeZeroPositifBpositifNormalCprocheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.294102428580963E-7;
        double b = 130.41104478334046;
        double c = 2.013257592533725;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", "liniear equation", true);
          dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveApositifNormalBnegatifNormalCpositifNormal() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 151.82644164285958;
        double b = -434.8731687584935;
        double c = 295.42027000522705;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


 @Test
 public void testSolveAprocheDeZeroPositifBtresGrandPositifCtresProcheDeZeroPositif() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.992451063850482;
        double b = 3.5466976188834414E7;
        double c = 9.695254308554977E-7;

        Class<?> dynamicClass = Class.forName("com.example.equation.QuadraticEquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        try {
          double[] solutions = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
          if (solutions.length > 0) {
              System.out.print("Solutions : ");
              double expected = 0;
              for (double solution : solutions) {
                  System.out.print(solution + " ");
                  // Use assert for each solution
                  expected = a * Math.pow(solution, 2) + (b * solution) + c;
                  double maxMagnitude = Math.max(Math.abs(a), Math.max(Math.abs(b), Math.abs(c)));
                  double delta = maxMagnitude * 1e-7; // You can adjust this multiplier based on your desired precision
                  assertEquals(0, expected, delta);
              }
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "" + solutions[0], ""+solutions[1], ""+expected, true);
          } else {
              System.out.println("Pas de solution r�elle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


}

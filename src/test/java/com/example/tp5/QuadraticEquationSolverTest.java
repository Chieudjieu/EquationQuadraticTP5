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
        double b = -9.786779200740561E8;
        double c = 8.342053569855493E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 1.3594843207850346E-7;
        double b = 9.565517136149687E-7;
        double c = -4.8590169820411545E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = -8.441242305954467E-7;
        double b = 2.232219200712842E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 4.5718484500330945;
        double b = -6.644230818126756E-7;
        double c = -8.410476608909842E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -3.5600345415286254;
        double b = -3.871848114288533;
        double c = 480.16442355830026;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 445.2127429354372;
        double b = -330.53500376930276;
        double c = -1.686620540990019;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -406.9067782131059;
        double b = 0.0;
        double c = 4.3174731739249825E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 6.460995712840837E7;
        double b = 2.8482340317700436;
        double c = 2.223062866269798;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -7.588537735651009E8;
        double b = 388.55678155920896;
        double c = -177.58363388978864;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double c = -5.609385051306559E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 2.1068788034732594E-7;
        double b = 0.0;
        double c = 1.409637519730265;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = -3.6619450748126926E-7;
        double b = 0.0;
        double c = -3.120468475068163;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 1.7763550896629203;
        double b = 0.0;
        double c = 2.0641405990333638E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -1.242083842587618;
        double b = 0.0;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 352.25639267432246;
        double b = 0.0;
        double c = 293.6757152263082;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -107.6914859874638;
        double b = 6.674381618030699E-7;
        double c = -404.20047039971286;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 2.0215235037503824E8;
        double b = 0.0;
        double c = -7.912457112020977E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -7.732296423831909E8;
        double b = 0.0;
        double c = 306.5119792135764;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double b = -1.9408456034866647E-7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double b = 2.0823351392799596;
        double c = -4.556811127870063;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double b = -1.1914360910112092;
        double c = 1.438277900270318;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double b = 131.56948754368221;
        double c = -7.259710477020016E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double b = -357.95948914420126;
        double c = -117.95098737042218;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double b = 5.809196598626559E8;
        double c = 8.602004604877039E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 7.723801079073407E-7;
        double b = -6.785005231242881E8;
        double c = -2.824972723806065E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = -2.1029435313825386E-7;
        double b = -2.0074395181974847;
        double c = -9.627856923831888E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 4.1681295112646435;
        double b = -5.981442449368747E8;
        double c = -4.83115687299513E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -1.3740894870143867;
        double b = -2.2051246498307634E-7;
        double c = -8.293282617866025E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 66.39665002191634;
        double b = 6.765773787962645E8;
        double c = -6.907037659863937E7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -333.9948044046771;
        double b = 1.084763451044037;
        double c = -6.27400652605489E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 2.701993051400593E8;
        double b = 174.52529519610715;
        double c = -4.9544601081790465E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -2.239648252597648E8;
        double b = -454.7043676642444;
        double c = -2.225343649646914E7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double b = 1.9739121457767944E-7;
        double c = 147.56588524375246;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 4.838829864793402E-7;
        double b = 2.7552942184824287;
        double c = 3.2556553251330685E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = -4.518701202186119;
        double b = -9.177256535745286E8;
        double c = 5.706422908221389E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -2.91063766689657E-7;
        double b = -8.773814295742571E7;
        double c = -202.67697517232727;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 1.6695399122799275;
        double b = 1.2591807122213794;
        double c = -480.1780940530556;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 268.5503978327793;
        double b = -4.739373654490719;
        double c = -489.5935752813472;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -292.30272190001506;
        double b = -8.136918049990155E-7;
        double c = 178.3705554272115;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 7.7731364008359E8;
        double b = 7.359577866781672E8;
        double c = -417.80138559146013;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -6.821467406235163E8;
        double b = 1.4455439095732445;
        double c = 1.85037901287876E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -2.1166422955210806;
        double b = 9.371235573360508E-7;
        double c = -1.6942190714737317;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 3.3341934674408323E-7;
        double b = 162.103596634845;
        double c = 50.27142808260045;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 4.08419873643489E8;
        double b = -33.427252277245486;
        double c = 1.981757516779951E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 218.25449004549935;
        double b = 221.56644580322347;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -2.5226030526958836E-7;
        double b = 116.60996798442774;
        double c = 1.7064064592860943E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = -3.092753932211141E-7;
        double b = -325.6947881082698;
        double c = 4.278673880269353;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 1.471605118821587;
        double b = 7.993771412868888E8;
        double c = -2.4703348822965276;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -53.24918386503589;
        double b = 2.8560040896671575E8;
        double c = 1.1754553591880321;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -1.5926336993863654E8;
        double b = -5.992109112594372E8;
        double c = 2.664389983229433;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 79.60184630168122;
        double b = 3.237604251310848E-7;
        double c = 2.4671276099706914;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 6.974656452088377E-7;
        double b = -9.162544777671602E-7;
        double c = -256.5992101457701;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 6.896977450331124E-7;
        double b = -1.0740543718993227;
        double c = 5.254543903210885E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 14.414127244884636;
        double b = 3.707170865401706;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -6.18926625447037E8;
        double b = -2.4567363024037268;
        double c = 5.155396226768877E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -12.92034992625662;
        double b = -247.71267563079542;
        double c = -6.888082213134014E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 4.146438273137688;
        double b = 9.822826814312995E-7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -1.121092321584325;
        double b = 96.91870895689634;
        double c = -274.87352008401933;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 8.812858958588139E8;
        double b = -2.2881161629722023E8;
        double c = -3.1582326277041695;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 98.94321703165762;
        double b = -8.999750097342112E-7;
        double c = 3.351107289384101E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -2.954213061036732E8;
        double b = 1.2768675927145383E-7;
        double c = -3.938215044908899E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 8.313097147449294E-7;
        double b = -58.16940684947457;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 3.0331714923260282;
        double b = 5.536866134141876E8;
        double c = 342.51954981485505;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -3.872416564987095E-7;
        double b = 3.5392207185312886E-7;
        double c = 5.506320459946567E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = -4.79390836099296;
        double b = 9.245364759111081E8;
        double c = 2.5628766110703634;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -131.47513556383808;
        double b = -4.173070202881236;
        double c = 5.052477861416108E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 8.705233634347448E8;
        double b = -3.2074131767273855;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -2.4528422883187425E8;
        double b = -8.874536774871315E-7;
        double c = -2.974319812025382;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -7.645871897956367E-7;
        double b = 2.413287739600684;
        double c = -8.578936064767401E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 3.8438219142221546;
        double b = 176.04921872058677;
        double c = 9.649871791949456E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 4.0669436994088E8;
        double b = 4.359336136111261E-7;
        double c = 1.1200103002676455E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 1.595424676749366E8;
        double b = -2.3336413877585053E8;
        double c = 432.56000275694515;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -1.799014634555562;
        double b = -146.3778642904117;
        double c = 9.779640234622126E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -226.75968480330175;
        double b = -2.780446625084796E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 4.715409294889114E8;
        double b = -6.504449942114267E-7;
        double c = 3.1484321622651867;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 1.637782619242084E-7;
        double b = 7.972874503241031E8;
        double c = -5.341964774380707E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = -80.34610612526825;
        double b = 223.94987744877437;
        double c = -3.923412270736236;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 4.876948284280732;
        double b = -1.298057454625127;
        double c = -1.7575267098207634;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 144.23733357496192;
        double b = -7.088646140152123E8;
        double c = -2.3422891718874487E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -4.535440501548174E-7;
        double b = 1.5018863908739943;
        double c = 276.97147911937697;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 2.0551293266327684;
        double b = -80.69316612503576;
        double c = 1.2775284787161953;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -4.48717788810389;
        double b = 1.014479717929833;
        double c = -9.99643353464107E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -6.291443394361615E8;
        double b = 3.610871190657417E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -4.4664916964662087E-7;
        double b = -1.2610090862460353E-7;
        double c = 6.957527201929893E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 9.90093084065046E-7;
        double b = 1.635153873170037E-7;
        double c = -1.579004824621442;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 349.30638371598906;
        double b = 0.0;
        double c = 7.275617209173155E8;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = -472.4462160013928;
        double b = 0.0;
        double c = -174.52433520999375;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 4.0663721877365635;
        double b = -2.7026759226489108;
        double c = -4.283687003410856E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 6.46567764395006E-7;
        double b = 365.2528197067544;
        double c = 2.473758818122737;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
        double a = 97.1197714014152;
        double b = -422.7097002767844;
        double c = 346.53202751919446;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
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
        double a = 1.3209216916551547;
        double b = 4.410275783418845E8;
        double c = 7.639761970045557E-7;

        Class<?> dynamicClass = Class.forName("com.example.tp5.equation.QuadraticEquationSolver");
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
              System.out.println("Pas de solution reelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


}

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
        double b = -7.439136692757642E8;
        double c = 3.944046722799522E-7;

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
        double a = 2.7539135072526085E-7;
        double b = 2.5303244419782365E-7;
        double c = -8.398726455378053E8;

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
        double a = -7.045025286398017E-7;
        double b = 6.71337106334155E8;
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
        double a = 1.6818797233028668;
        double b = -9.858246169363317E-7;
        double c = -6.560580362529915E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -3.137409073335929;
        double b = -4.450169142767834;
        double c = 45.914225697796574;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 277.10112354237316;
        double b = -133.15772136703663;
        double c = -2.8167823456617658;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -289.01611380603185;
        double b = 0.0;
        double c = 8.438725582284862E7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 9.66685247472912E8;
        double b = 2.7214937910321093;
        double c = 2.5104723436225362;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -8.830076429238402E8;
        double b = 376.47460203975913;
        double c = -204.65427131308098;

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
              System.out.println("Pas de solution réelle.");
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
        double c = -6.003879445507227E8;

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
        double a = 7.095143041202865E-7;
        double b = 0.0;
        double c = 4.600979331167897;

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
        double a = -3.7212731260307473E-7;
        double b = 0.0;
        double c = -4.761416268101572;

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
        double a = 1.4748770862600913;
        double b = 0.0;
        double c = 3.93668994990471E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -4.7376836349258955;
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
              System.out.println("Pas de solution réelle.");
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
        double a = 269.07749317407126;
        double b = 0.0;
        double c = 210.37028990555794;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -95.37125630080203;
        double b = 1.7538056043960803E-7;
        double c = -476.9976824546004;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 4.816791256520511E8;
        double b = 0.0;
        double c = -3.6932861124534185E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -7.827493423474114E8;
        double b = 0.0;
        double c = 201.81560411627316;

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
              System.out.println("Pas de solution réelle.");
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
        double b = -8.919118062159397E-7;
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
        double b = 1.6281826842077236;
        double c = -4.385989974302817;

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
        double b = -1.487045855395845;
        double c = 2.406118288283367;

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
        double b = 450.7753734645508;
        double c = -2.7047866621037694E-7;

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
        double b = -360.1040113889045;
        double c = -69.4393030265872;

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
        double b = 4.32291366782161E8;
        double c = 9.818051149052745E8;

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
        double a = 3.485403527134577E-7;
        double b = -8.639915269329276E8;
        double c = -3.4954887503284524E-7;

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
        double a = -7.400218576428058E-7;
        double b = -4.443678387263153;
        double c = -6.703381147119291E8;

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
        double a = 1.1128081047609415;
        double b = -9.450647879643016E8;
        double c = -9.583013725053651E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -3.5794408049397073;
        double b = -6.135394557163528E-7;
        double c = -9.648277547614257E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 278.02639381829454;
        double b = 7.82260705921174E8;
        double c = -6.13470810556303E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -130.38196768466082;
        double b = 2.808408591123377;
        double c = -7.239362758499795E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 6.587692704819822E8;
        double b = 45.1090351799185;
        double c = -4.838085192583141E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -6617709.378516436;
        double b = -204.69923594923267;
        double c = -2.9924745425098157E8;

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
              System.out.println("Pas de solution réelle.");
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
        double b = 2.6588341166703403E-7;
        double c = 314.41973601457545;

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
        double a = 6.764728469832244E-7;
        double b = 3.547939613190929;
        double c = 6.668050149082844E-7;

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
        double a = -2.2234181077750796;
        double b = -4.6899397534749216E8;
        double c = 3.2481899186037016E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -1.957875915466977E-7;
        double b = -5.2326650981213367E8;
        double c = -173.14140380126446;

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
        double a = 4.007152727980342;
        double b = 1.5212696312729448;
        double c = -316.7503891257868;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 359.1852952964292;
        double b = -3.133439779839288;
        double c = -82.0717966959615;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -81.62319546239894;
        double b = -3.9424323312493216E-7;
        double c = 343.7395816612536;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 3.685944022930237E8;
        double b = 6.64269053797346E8;
        double c = -372.7162772855485;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -4.222093405204716E8;
        double b = 4.574355916877781;
        double c = 7.341196698905153E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -4.198004973354909;
        double b = 2.340894400668738E-7;
        double c = -2.1575951971762297;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 9.989157301795311E-7;
        double b = 312.8257745875331;
        double c = 411.96948278060796;

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
        double a = 8.855417087548089E8;
        double b = -491.34525324049736;
        double c = 6.234655846160527E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 445.4370329463422;
        double b = 29.673746134163054;
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
              System.out.println("Pas de solution réelle.");
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
        double a = -6.903653596349212E-7;
        double b = 150.8511547947536;
        double c = 5.163536364565099E-7;

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
        double a = -1.2299471991181968E-7;
        double b = -313.8563100982358;
        double c = 2.9082844939099317;

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
        double a = 3.8500938191359313;
        double b = 4.9829629123372895E8;
        double c = -2.3594805685925944;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -308.4293441648;
        double b = 3.854580983243169E8;
        double c = 1.742009081596796;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -3.571159577317897E8;
        double b = -5.599377194126859E8;
        double c = 3.171994907357245;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 251.5462196178606;
        double b = 7.216463465847208E-7;
        double c = 4.484190445972333;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 6.4143239863917E-7;
        double b = -1.5737547559523689E-7;
        double c = -156.80007679102567;

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
        double a = 7.825452992717387E-7;
        double b = -1.544655194165482;
        double c = 7.43676219116074E8;

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
        double a = 438.5415163913412;
        double b = 4.776819922051613;
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
              System.out.println("Pas de solution réelle.");
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
        double a = -1.1217763097652972E8;
        double b = -3.7078781097135742;
        double c = 6.061323762329161E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -135.2368652863824;
        double b = -386.14754360640893;
        double c = -6.557010740872343E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 4.915742538111331;
        double b = 6.004376907195642E-7;
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
              System.out.println("Pas de solution réelle.");
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
        double a = -1.9038274276186593;
        double b = 346.3982115596392;
        double c = -338.8650447905044;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 6.343106475926211E8;
        double b = -7.551797243752048E8;
        double c = -4.008943848675416;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 329.9309792618922;
        double b = -9.746562736428638E-7;
        double c = 6.276471925821668E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -9.52898995947296E8;
        double b = 4.890235083043146E-7;
        double c = -6.675626710081565E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 4.400436416011708E-7;
        double b = -252.0553088025345;
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
        double a = 4.039067133774216;
        double b = 2.5456283613528523E8;
        double c = 289.978441873994;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -4.305312109621829E-7;
        double b = 8.653637156031484E-7;
        double c = 9.186946991932462E8;

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
        double a = -3.676809490040232;
        double b = 3.564821336143359E7;
        double c = 2.7897786309047;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -26.129401111859977;
        double b = -3.416214913004226;
        double c = 6.376288497872627E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 8.293378019464902E8;
        double b = -2.284572186192549;
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
              System.out.println("Pas de solution réelle.");
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
        double a = -2.1959463127034628E8;
        double b = -5.766798485065677E-7;
        double c = -2.624150635602379;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -1.1366711776240155E-7;
        double b = 2.4238568308944264;
        double c = -4.656364313582104E-7;

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
        double a = 3.8138803706236835;
        double b = 388.1693646829858;
        double c = 9.658586880657372E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 9.344687245874081E8;
        double b = 6.447425649261389E-7;
        double c = 4.008553972595143E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 8.216414311778182E8;
        double b = -9.651506498609585E8;
        double c = 441.60500095429103;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -1.0906972731481508;
        double b = -264.8169859468727;
        double c = 4.2943989522767314E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -36.697558846479694;
        double b = -3.254472122821741E8;
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
              System.out.println("Pas de solution réelle.");
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
        double a = 5.255156301515439E8;
        double b = -6.889697733543987E-7;
        double c = 3.6908033676656604;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 8.134483882057885E-7;
        double b = 5.0322453111990976E8;
        double c = -3.638856599627711E-7;

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
        double a = -42.545615147024535;
        double b = 138.55332959278084;
        double c = -3.715021423033901;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 2.5290762327394227;
        double b = -1.5565736300241615;
        double c = -4.952500584258104;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 488.1107154360754;
        double b = -3.64006015899528E8;
        double c = -1.8513492155785556E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -8.135387783275093E-7;
        double b = 1.3017368413444865;
        double c = 242.72179677405052;

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
        double a = 2.583170803654698;
        double b = -429.06230571348345;
        double c = 3.9097294231846744;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -3.3824404879440957;
        double b = 1.9715895161430472;
        double c = -6.540040977298619E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -1.827316072020688E8;
        double b = 4.0469532390789104E8;
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
              System.out.println("Pas de solution réelle.");
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
        double a = -5.052744702643464E-7;
        double b = -4.6270548831998516E-7;
        double c = 8.132458944249786E8;

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
        double a = 1.8220287952366774E-7;
        double b = 6.751769080829874E-7;
        double c = -3.5335513264119283;

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
        double a = 425.42619024736695;
        double b = 0.0;
        double c = 9.841194360445403E8;

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
              System.out.println("Pas de solution réelle.");
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
        double a = -356.78769821979375;
        double b = 0.0;
        double c = -484.4618212064588;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 2.2125554478964875;
        double b = -1.5844515526841891;
        double c = -6.67171130704841E-7;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 6.207107156154399E-7;
        double b = 85.7289750402996;
        double c = 2.885466629788046;

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
        double a = 335.89296562058973;
        double b = -455.10908524934723;
        double c = 384.1891634642978;

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
              System.out.println("Pas de solution réelle.");
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
        double a = 1.0337897898450361;
        double b = 9.522879834672705E8;
        double c = 1.2896071819612065E-7;

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
              System.out.println("Pas de solution réelle.");
              // Use assert for the case with no solution
              assertEquals(0, solutions.length);
              writeResultToCSV("("+a+")"+"x^2 + "+"("+b+")"+"x + "+"("+c+")"+" = 0", "N/a", "N/a", " ", true);
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
         }
 }


}

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
        double b = -7.217266444947171E7;
        double c = 3.547139471267882E-7;

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
        double a = 2.3383508807279412E-7;
        double b = 1.543822923033089E-7;
        double c = -2.3797478388129234E8;

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
        double a = -1.1524176649433856E-7;
        double b = 9.5152798220945E8;
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
        double a = 3.971521497670618;
        double b = -4.272544218730978E-7;
        double c = -5.250149981741785E-7;

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
        double a = -3.9005616911121903;
        double b = -3.6174401746320313;
        double c = 82.21575753749381;

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
        double a = 388.6531825006032;
        double b = -130.5814263762726;
        double c = -4.363167139927521;

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
        double a = -23.11985010433682;
        double b = 0.0;
        double c = 8.760018400047649E8;

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
        double a = 5.477649689192047E7;
        double b = 2.055879874572593;
        double c = 2.9964705137919845;

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
        double a = -9.341865541925197E8;
        double b = 271.90009594093993;
        double c = -340.26055636080406;

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
        double c = -2.336733348969984E7;

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
        double a = 3.5475135720190737E-7;
        double b = 0.0;
        double c = 3.003318604818967;

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
        double a = -1.4616588843046543E-7;
        double b = 0.0;
        double c = -1.4791700613197771;

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
        double a = 4.561096699531078;
        double b = 0.0;
        double c = 2.1958318043353624E-7;

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
        double a = -2.5520865981892005;
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
        double a = 319.3994344609899;
        double b = 0.0;
        double c = 52.85578711905439;

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
        double a = -45.90434423652766;
        double b = 1.9587112083457622E-7;
        double c = -36.45908525123798;

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
        double a = 5.3354318329843754E8;
        double b = 0.0;
        double c = -3.055154839396794E-7;

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
        double a = -1.0741625627981377E8;
        double b = 0.0;
        double c = 189.5368804327226;

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
        double b = -5.992960933495989E-7;
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
        double b = 4.159703639172518;
        double c = -4.8784473722022055;

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
        double b = -3.766787036668134;
        double c = 3.5605910478465534;

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
        double b = 496.8358389577599;
        double c = -9.260626575430274E-7;

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
        double b = -288.86982028873945;
        double c = -10.423023660822025;

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
        double b = 5.665528588964244E8;
        double c = 8.425693728399615E7;

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
        double a = 6.628740906255639E-7;
        double b = -2.460478652574365E8;
        double c = -4.183096978788206E-7;

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
        double a = -5.317212721329234E-7;
        double b = -3.968124896712072;
        double c = -8.959893113962516E8;

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
        double a = 1.6194173048290468;
        double b = -9.171211795253108E8;
        double c = -7.663751247272975E8;

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
        double a = -1.6724354902146872;
        double b = -4.892553947487241E-7;
        double c = -9.480693802708882E8;

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
        double a = 171.53172827742034;
        double b = 1.6262253629827005E8;
        double c = -9.25983007195249E8;

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
        double a = -31.518878109808213;
        double b = 1.115721716680262;
        double c = -6.769954922814302E8;

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
        double a = 5.789819308109642E8;
        double b = 18.083601187715672;
        double c = -5.483957711720028E8;

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
        double a = -1.9439094825696814E8;
        double b = -499.5132542751544;
        double c = -2.7645330608748186E8;

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
        double b = 3.8542199384221756E-7;
        double c = 45.30915245654284;

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
        double a = 5.185184952092798E-7;
        double b = 4.893310316234716;
        double c = 5.121489045385098E-7;

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
        double a = -4.868761367263661;
        double b = -3.4519099813658106E8;
        double c = 2.7141774807536113E8;

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
        double a = -3.562444874710813E-7;
        double b = -8.387848264894844E8;
        double c = -99.96793070439065;

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
        double a = 1.0866848512140743;
        double b = 3.169307998967215;
        double c = -443.0281226698548;

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
        double a = 276.6293139137922;
        double b = -3.8414801446331683;
        double c = -42.037428594502046;

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
        double a = -392.43137697895963;
        double b = -6.532783104230311E-7;
        double c = 455.7349152437906;

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
        double a = 5.68478105438046E8;
        double b = 8.701471883332154E8;
        double c = -10.524338706891115;

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
        double a = -4.1527804935486054E8;
        double b = 1.1225897422806952;
        double c = 5.964119631432215E8;

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
        double a = -3.2811257923159753;
        double b = 8.904820030786423E-7;
        double c = -1.0061093436820507;

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
        double a = 1.8146300775660804E-7;
        double b = 390.1009033316282;
        double c = 311.40972779517324;

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
        double a = 4.7144434754546726E8;
        double b = -20.678428700487927;
        double c = 1.0488407965859164E8;

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
        double a = 415.0049432196539;
        double b = 205.53314077943168;
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
        double a = -7.561552038794531E-7;
        double b = 158.65780531871653;
        double c = 9.149173584444406E-7;

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
        double a = -4.87309782588353E-7;
        double b = -37.23854388140012;
        double c = 4.2032191055118995;

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
        double a = 2.2547128966056706;
        double b = 4.986907516837413E7;
        double c = -3.4494013904492355;

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
        double a = -406.7703629163234;
        double b = 7.013567961001779E8;
        double c = 1.9395990932417995;

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
        double a = -2.288981472805432E8;
        double b = -5.2930212739468E8;
        double c = 2.653927718912933;

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
        double a = 178.04723412485114;
        double b = 8.565740640428305E-7;
        double c = 3.45956789451288;

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
        double a = 4.955373616852787E-7;
        double b = -7.228264954425774E-7;
        double c = -397.0662849287749;

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
        double a = 3.4839288004073003E-7;
        double b = -4.348483797305102;
        double c = 4.8872260463968056E8;

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
        double a = 226.88956568912116;
        double b = 1.4183562700218872;
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
        double a = -6.798013615151916E8;
        double b = -1.387119156978979;
        double c = 5.494202335235725E-7;

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
        double a = -483.60536916803045;
        double b = -279.475549787689;
        double c = -6.490501740226916E-7;

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
        double a = 3.424518708574717;
        double b = 8.455077381779606E-7;
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
        double a = -2.1848526751462654;
        double b = 85.4419089121381;
        double c = -66.18357984077255;

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
        double a = 2.262679526129938E8;
        double b = -8.720865143254933E8;
        double c = -2.2978455623779412;

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
        double a = 71.56463014845271;
        double b = -4.597128863765837E-7;
        double c = 4.485066229668145E-7;

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
        double a = -2.903653265247092E8;
        double b = 7.046492422819997E-7;
        double c = -6.969078028966053E-7;

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
        double a = 1.844941146089482E-7;
        double b = -344.79302115447;
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
        double a = 1.4248594806572186;
        double b = 8.44389815362611E8;
        double c = 18.737267783577458;

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
        double a = -5.665117690294681E-7;
        double b = 6.388913567277299E-7;
        double c = 2.4791424223879952E7;

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
        double a = -4.572925554621176;
        double b = 7.263018360784413E8;
        double c = 3.801842706828846;

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
        double a = -186.13443876596102;
        double b = -2.301036836606198;
        double c = 7.0167343368131E-7;

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
        double a = 3.8091880065360284E8;
        double b = -1.5306408555062783;
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
        double a = -7.138338232516079E8;
        double b = -3.2223657527894433E-7;
        double c = -1.4473523101966537;

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
        double a = -5.804693370152818E-7;
        double b = 1.385214574410345;
        double c = -8.015910637311379E-7;

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
        double a = 2.061310338310282;
        double b = 359.2126708119507;
        double c = 3.9975280929436684E8;

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
        double a = 4.431236819686656E7;
        double b = 6.281084808497468E-7;
        double c = 7.582615110202023E-7;

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
        double a = 4.1646686424804854E8;
        double b = -3.489389103983084E8;
        double c = 146.79293473160013;

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
        double a = -3.121666722224951;
        double b = -448.85822438901846;
        double c = 9.53963967369377E-7;

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
        double a = -267.0030161130191;
        double b = -1.6301151960421455E8;
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
        double a = 3.4446024087201625E8;
        double b = -5.137530882435154E-7;
        double c = 3.7656342492784693;

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
        double a = 1.1925840925521208E-7;
        double b = 2.968252627640371E8;
        double c = -7.258415278230586E-7;

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
        double a = -432.1910301209348;
        double b = 325.2692834313466;
        double c = -1.4376721316712695;

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
        double a = 2.99387271149865;
        double b = -3.823038024862689;
        double c = -3.4495003090978336;

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
        double a = 141.38327645229782;
        double b = -3.387405812815269E8;
        double c = -1.536109915931496E-7;

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
        double a = -1.0988219832868468E-7;
        double b = 1.7467863824046082;
        double c = 229.57288036140145;

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
        double a = 2.5894939158003236;
        double b = -454.2725949015969;
        double c = 3.7110540331582573;

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
        double a = -2.8412919985600213;
        double b = 2.0767800356288486;
        double c = -8.794212619508607E-7;

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
        double a = -9.55534835304935E7;
        double b = 7.606139240905259E8;
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
        double a = -8.56922330060469E-7;
        double b = -5.852779530009066E-7;
        double c = 5.975317450600986E8;

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
        double a = 1.74589140709734E-7;
        double b = 8.108695568143861E-7;
        double c = -3.1119956805192115;

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
        double a = 175.72912912015065;
        double b = 0.0;
        double c = 7.988397802351627E8;

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
        double a = -280.42797571363167;
        double b = 0.0;
        double c = -166.27907259066455;

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
        double a = 2.805143331298698;
        double b = -1.0223304148643715;
        double c = -5.662446950218668E-7;

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
        double a = 2.6895406069094806E-7;
        double b = 150.41292856491137;
        double c = 4.457542775157686;

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
        double a = 252.72282432821785;
        double b = -403.83419861956804;
        double c = 420.89125026187685;

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
        double a = 2.6295655513924476;
        double b = 9.158430613012519E8;
        double c = 6.905718007419459E-7;

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

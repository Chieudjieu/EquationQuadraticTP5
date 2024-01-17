package com.example.tp5.equation;

// Class QuadraticEquationSolver implementing the EquationSolver interface
public final class QuadraticEquationSolver implements IEquationSolver {

    /**
     * Solves the quadratic equation given its coefficients.
     *
     * @param coefficientA The coefficient of x^2.
     * @param coefficientB The coefficient of x.
     * @param coefficientC The constant term.
     * @return An array containing the solutions of the equation.
     * @throws IllegalArgumentException if the coefficient 'a' is zero.
     */
    @Override
    public double[] solve(final double coefficientA, final double coefficientB, final double coefficientC) {
        final double tolerance = 1e-5;
        if (Math.abs(coefficientA) < tolerance) {
            throw new IllegalArgumentException("Coefficient 'a' must be non-zero for a quadratic equation.");
        }

        // Calculation of the discriminant
        final double discriminant = coefficientB * coefficientB - 4 * coefficientA * coefficientC;
        double[] solutions;

        if (discriminant > 0) {
            // Two distinct real solutions
            final double x1 = (-coefficientB + Math.sqrt(discriminant)) / (2 * coefficientA);
            final double x2 = (-coefficientB - Math.sqrt(discriminant)) / (2 * coefficientA);
            solutions = new double[]{x1, x2};
        } else if (discriminant == 0) {
            // Single real solution
            final double x = -coefficientB / (2 * coefficientA);
            solutions = new double[]{x, x};
        } else {
            // No real solutions
            solutions = new double[0]; // Empty array to indicate no solution
        }

        return solutions;
    }

    /**
     * Entry point to solve quadratic equations using this solver.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(final String[] args) {
        final IEquationSolver solver = new QuadraticEquationSolver();

        // Example usage
        final double a = -1.5171410532737735;
        final double b = 9.95893810519504E8;
        final double c = 1.1416180209259617;

        try {
            final double[] solutions = solver.solve(a, b, c);

            if (solutions.length > 0) {
                System.out.print("Solutions: ");
                for (final double solution : solutions) {
                    System.out.print(solution + " ");
                }
            } else {
                System.out.println("No real solution.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

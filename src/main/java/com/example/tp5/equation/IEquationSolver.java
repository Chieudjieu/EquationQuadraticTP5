package com.example.tp5.equation;

/**
 * Interface for solving equations.
 */
public interface IEquationSolver {
    /**
     * Solves the equation given its coefficients.
     *
     * @param coefficientA The coefficient of x^2.
     * @param coefficientB The coefficient of x.
     * @param coefficientC The constant term.
     * @return An array containing the solutions of the equation.
     */
    double[] solve(
            double coefficientA,
            double coefficientB,
            double coefficientC
    );
}

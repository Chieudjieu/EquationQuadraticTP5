package com.example.tp5;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp5.equation.QuadraticEquationSolver;
import com.example.tp5.equation.IEquationSolver;

import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
public class EquationController {

    private final IEquationSolver equationSolver = new QuadraticEquationSolver();

    @PostMapping("/calculer")
    public ResponseEntity<?> calculer(@RequestBody Map<String, Double> coefficients) {
        double a = coefficients.get("a");
        double b = coefficients.get("b");
        double c = coefficients.get("c");

        double[] solutions;
        try {
            solutions = equationSolver.solve(a, b, c);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }

        // Formattez le résultat selon vos besoins
        return ResponseEntity.ok(Map.of("solutions", solutions));
    }
}
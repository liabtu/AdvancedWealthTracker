package com.example.advancedwealthtracker

/**
 * WealthManager კლასი პასუხისმგებელია მათემატიკურ გამოთვლებზე.
 * K = (ლია(3) + გელაშვილი(9)) / 24 = 0.5
 */
class WealthManager {

    // ინდივიდუალური კოეფიციენტი
    private val kCoefficient: Double = 0.5

    fun calculateFinalSavings(income: Double, expenses: Double): Double {
        // ფორმულა: (შემოსავალი - ხარჯი) * K
        return (income - expenses) * kCoefficient
    }
}
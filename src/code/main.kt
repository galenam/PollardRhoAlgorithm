package PollardsRhoAlgoritm

fun main() {
    val value = 8051;
    val results = RhoCalculation.Calculation(value)
    for (res in results) {
        print("$res ")
    }
}
package PollardsRhoAlgoritm

import kotlin.math.abs

class RhoCalculation {
    companion object Calculate {
        fun Calculation(value: Int): List<Int> {
            var result = mutableListOf<Int>()
            var a = 2
            var b = 2
            var data = value

            while (data > 1) {
                a = Fx(a, value)
                b = Fx(Fx(b, value), value)
                val diff = abs(a - b);
                val divisor = GCD(diff, data)

                if (divisor > 1) {
                    result.add(divisor)
                    data /= divisor
                }
            }
            return result;
        }

        fun GCD(x: Int, y: Int): Int {
            if (x == 0) return y;
            if (y == 0) return x;
            var max = x
            var min = y

            var rem: Int
            if (x == y) {
                return x
            } else if (x < y) {
                max = y
                min = x
            }
            do {
                rem = max % min
                max = min
                min = rem
            } while (rem > 0)
            return max
        }

        private fun Fx(x: Int, value: Int): Int = (x * x -1) % value
    }

}
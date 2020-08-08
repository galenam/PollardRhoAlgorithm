package PollardsRhoAlgoritm.test

import PollardsRhoAlgoritm.RhoCalculation
import org.junit.jupiter.api.Test
import PollardsRhoAlgoritm.temp
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.Console
import java.util.stream.Stream
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class MainKtTest {
	@ParameterizedTest
	@MethodSource("provideTestArguments")
	fun `calculation factorization`(value : Int, expected : List<Int>){
        var factorization = RhoCalculation.Calculation(value)
		var compare = compareContentListAnyOrder(expected, factorization)
		Assertions.assertEquals(true, compare)
	}

	fun provideTestArguments(): Stream<Arguments> {
		var list = listOf<Arguments>(
                Arguments.of(5506763, listOf(139,229,173)),
                Arguments.of(11189627, listOf(131,373,229)),
                Arguments.of(207413, listOf(211,983)),
                Arguments.of(230267, listOf(563,409)),
                Arguments.of(8051, listOf<Int>(83, 97))
		)
		return list.stream();
	}

	fun compareContentListAnyOrder(list1 : List<Int>, list2: List<Int>): Boolean
	{
		if (list1.size != list2.size) return  false
		for (value in list1)
		{
			if (!list2.contains(value)) return false
		}
		return true
	}
}
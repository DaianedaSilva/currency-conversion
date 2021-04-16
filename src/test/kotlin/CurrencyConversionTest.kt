import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.experimental.theories.suppliers.TestedOn
import java.math.BigDecimal
class CurrencyConversionTest {

    @Test
    fun `Get taxa BRL to AUD`(){

      val result = CurrencyConversion().conversion(CurrencyConversion().splitCurrency("BRL100 AUD"))
        assertEquals("0.2324", result)

    }

    @Test
    fun `Get taxa BRL to BRL`(){

        val result = CurrencyConversion().conversion(CurrencyConversion().splitCurrency("BRL100 BRL"))


        assertEquals("1.0", result)
    }

    @Test
    fun `Get taxa BRL to EUR`(){

        val result = CurrencyConversion().conversion(CurrencyConversion().splitCurrency("BRL100 EUR"))


        assertEquals("0.1488", result)
    }

    @Test
    fun `Get taxa BRL to IRR`(){

        val result = CurrencyConversion().conversion(CurrencyConversion().splitCurrency("BRL100 IRR"))


        assertEquals("0.0001", result)
    }
    @Test
    fun `Get taxa BRL to USD`(){

        val result = CurrencyConversion().conversion(CurrencyConversion().splitCurrency("BRL100 USD"))

       assertEquals("0.1774", result)
    }
}
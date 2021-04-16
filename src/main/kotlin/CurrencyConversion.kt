import java.text.NumberFormat
import java.util.*

class CurrencyConversion {
    public fun currencyConverse(userInput: String): String {
        val infosInput = splitCurrency(userInput);

        if (!codeIsValid(infosInput.target.name) && !codeIsValid(infosInput.source.name)) {
            return "ERRO! Taxas invalidas"
        }
        if (!amountIsValid(infosInput.amountToConversion)) {
            return "ERRO! Valor Negativo"
        }
        val result = conversion(infosInput);
        return ShowResult(result)
    }

    //matriz com as taxas de cambio
    private val currencyExchengeRate = arrayOf(//AUD    BRL      EUR       IRR          USD
        arrayOf(1.0, 4.3009, 0.6403, 32631.3775, 0.7630),   //AUD
        arrayOf(0.2324, 1.0, 0.1491, 7493.7254, 0.1774),   //BRL
        arrayOf(1.5616, 6.7170, 1.0, 50403.8615, 1.5615),   //EUR
        arrayOf(0.0000, 0.0001, 0.0000, 1.0, 0.0000),   //IRR
        arrayOf(1.31021, 5.6360, 0.8380, 42105.0068, 1.0)
    )    //USD

    private enum class CurrencyCode { AUD, BRL, EUR, IRR, USD }

    private data class Conversion(
        val source: CurrencyCode,
        val target: CurrencyCode,
        val amountToConversion: Double,
        var rate: Double = 0.0,
        var amountConverted: Double = 0.0
    )

    private fun codeIsValid(code: String): Boolean = code in CurrencyCode.values().map(CurrencyCode::name)

    private fun amountIsValid(amount: Double): Boolean = amount >= 0

    private fun splitCurrency(userInput: String): Conversion {

        val delimiter = " ";
        val splitValues = userInput.split(delimiter);// exemplo -> ["BRL100", "EUR"]

        val source = splitSource(splitValues[0])    // -> BRL
        val amount = splitAmount(splitValues[0])    // -> 100
        val target = splitValues[1]                 // -> EUR

        val valuesToConversion = Conversion(CurrencyCode.valueOf(source), CurrencyCode.valueOf(target), amount)

        return valuesToConversion;
    }

    private fun splitSource(userInput: String): String {
        val source = userInput.slice(0 until 3);
        return source;
    }

    private fun splitAmount(userInput: String): Double {
        val amount = userInput.slice(3 until userInput.length).toDouble();
        return amount;
    }

    private fun conversion(valuesToConversion: Conversion): Conversion {
        val line = valuesToConversion.source.ordinal;
        val column = valuesToConversion.target.ordinal;

        val rate = currencyExchengeRate[line][column];
        val newAmount = valuesToConversion.amountToConversion * rate;

        valuesToConversion.rate = rate;
        valuesToConversion.amountConverted = newAmount;

        return valuesToConversion;
    }

    private fun formatAmount(amount: Double, codeCurrent: String): String {
        val format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        format.setCurrency(Currency.getInstance(codeCurrent));

        return format.format(amount);

    }

    private fun ShowResult(result: Conversion): String {
        val amountSourceFormateted = formatAmount(result.amountToConversion, result.source.name)
        val amountTargetFormateted = formatAmount(result.amountConverted, result.target.name)

        return "*** Conversion of ${result.source} to ${result.target} ***\n  ${amountSourceFormateted}  ->  ${amountTargetFormateted}\n\n  Exchange Rate: ${result.rate}\n"

    }


}
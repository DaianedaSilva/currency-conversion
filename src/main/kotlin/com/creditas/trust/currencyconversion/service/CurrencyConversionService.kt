package com.creditas.trust.currencyconversion.service

import org.springframework.stereotype.Service
import java.lang.Exception
import java.text.NumberFormat
import java.util.*

@Service
class CurrencyConversionService(val exchangeRageService: ExchangeRageService){
    public fun currencyConverse(userInput: String) :String {
        val infosInput = splitCurrency(userInput)

        val result = conversion(infosInput)
        return showResult(result)
    }

    //possiveis moedas de conversão
    private enum class CurrencyCode (val tagCodelanguage:String){
        AUD("en-AUD"),
        BRL("pt-BR"),
        EUR("en-GB"),
        IRR("prs-IR"),
        USD("en-US")
    }

    //Classe que contém os valores para conversão
    private data class Conversion(
        val source: CurrencyCode,
        val target: CurrencyCode,
        val amountToConversion: Double,
        var rate: Double = 0.0,
        var amountConverted: Double = 0.0
    )

    // verificar se os codes estão listados no sistema
    private fun codeIsValid(code: String): Boolean = code in CurrencyCode.values().map(CurrencyCode::name)

    // verificar se o valor para conversão é valido
    private fun amountIsPositive(amount: Double): Boolean = amount >= 0

    //formatar a entrada do usuário
    private fun splitCurrency(userInput: String): Conversion {
        //BRL100 USD
        val delimiter = " "
        val splitValues = userInput.split(delimiter)// exemplo -> ["BRL100", "EUR"]

        val source = splitSource(splitValues[0])    // -> BRL
        val amount = splitAmount(splitValues[0])    // -> 100
        val target = splitValues[1]                 // -> EUR

        if (!codeIsValid(target) || !codeIsValid(source)) {
            throw Exception( "ERRO! Taxas invalidas")
        }
        if (!amountIsPositive(amount)) {
            throw Exception( "ERRO! Valor Negativo")
        }

        val valuesToConversion = Conversion(CurrencyCode.valueOf(source), CurrencyCode.valueOf(target), amount)

        return valuesToConversion
    }

    //Separar do input apenas o source
    private fun splitSource(userInput: String): String {
        val source = userInput.slice(0 until 3)
        return source
    }

    //Separar do input apenas o amount
    private fun splitAmount(userInput: String): Double {
        val amount = userInput.slice(3 until userInput.length).toDouble()
        return amount
    }

    //realizar a conversão
    private fun conversion(valuesToConversion: Conversion): Conversion {
        val source = valuesToConversion.source.name
        val target = valuesToConversion.target.name

        val rate = exchangeRageService.getRate(source,target)
        val newAmount = valuesToConversion.amountToConversion * rate

        valuesToConversion.amountConverted = newAmount
        valuesToConversion.rate = rate
        return valuesToConversion
    }

    //mostrar o resultado final para o suário
    private fun showResult(result: Conversion): String {
        val amountSourceFormatted = formatAmount(result.amountToConversion, result.source.name)
        val amountTargetFormatted = formatAmount(result.amountConverted, result.target.name)


        return """
            <div style="text-align: center;">
           
                <h1> *** Conversion of ${result.source} to ${result.target} *** </h1> <br>         
                  <h3> ${amountSourceFormatted}     ->      ${amountTargetFormatted} </h3> <br>
                
                <h3>Exchange Rate: ${result.rate} </h3>
            </div>
            
        """

    }

    //formatando a saída do amount
    private fun formatAmount(amount: Double, codeCurrent: String): String {
        val format = NumberFormat.getCurrencyInstance(Locale.forLanguageTag((CurrencyCode.valueOf(codeCurrent).tagCodelanguage)))
        format.setMaximumFractionDigits(2)
        return format.format(amount)

    }

}
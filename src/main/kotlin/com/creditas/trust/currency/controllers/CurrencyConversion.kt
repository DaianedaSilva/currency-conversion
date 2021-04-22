package com.creditas.trust.currency.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import java.text.NumberFormat
import java.util.*

@RestController
@RequestMapping("/CurrencyConversion")
class CurrencyConversion {

    @GetMapping("/conversion")
    public fun currencyConverse(userInput: String) :String {
        val infosInput = splitCurrency(userInput)

        val result = conversion(infosInput)
        return showResult(result)
    }


    //matriz com as taxas de cambio
    private val currencyExchengeRate = arrayOf(    //AUD       BRL      EUR       IRR         USD
                                            arrayOf(1.0,     4.3009,  0.6403,  32631.3775,  0.7630),   //AUD
                                            arrayOf(0.2324,  1.0,     0.1491,  7493.7254,   0.1774),   //BRL
                                            arrayOf(1.5616,  6.7170,  1.0,     50403.8615,  1.5615),   //EUR
                                            arrayOf(0.0000,  0.0001,  0.0000,  1.0,         0.0000),   //IRR
                                            arrayOf(1.31021, 5.6360,  0.8380,  42105.0068,    1.0))    //USD

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
        val line = valuesToConversion.source.ordinal
        val column = valuesToConversion.target.ordinal

        val rate = currencyExchengeRate[line][column]
        val newAmount = valuesToConversion.amountToConversion * rate

        valuesToConversion.rate = rate
        valuesToConversion.amountConverted = newAmount

        return valuesToConversion
    }

    //mostrar o resultado final para o suário
    private fun showResult(result: Conversion): String {
        val amountSourceFormatted = formatAmount(result.amountToConversion, result.source.name)
        val amountTargetFormatted = formatAmount(result.amountConverted, result.target.name)

        return """
            | *** Conversion of ${result.source} to ${result.target} ***            
            |${amountSourceFormatted}  ->  ${amountTargetFormatted}
            |
            |Exchange Rate: ${result.rate}
            | 
        """.trimMargin("|")
    }

    private fun testResult (result: Conversion): String{
        val sourceTest = formatAmount(result.amountToConversion, result.source.name)
        val targetTest = formatAmount(result.amountConverted, result.target.name)
        return "${sourceTest} -> ${targetTest}"
    }

    //formatando a saída do amount
    private fun formatAmount(amount: Double, codeCurrent: String): String {

        val format = NumberFormat.getCurrencyInstance(Locale.forLanguageTag((CurrencyCode.valueOf(codeCurrent).tagCodelanguage)))
        format.setMaximumFractionDigits(2)

        return format.format(amount)

    }

}
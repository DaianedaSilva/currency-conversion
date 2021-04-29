import com.creditas.trust.currency.CurrencyConversion

fun main(){

    val currencyConversion = CurrencyConversion();

    print("\n\n Entrada: ")
    val userInput: String = readLine().toString();

    println(currencyConversion.currencyConverse(userInput));

}


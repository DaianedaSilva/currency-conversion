fun main(){
    val currencyConversion = CurrencyConversion();

    //teste - Entrada em conversionValue apenas positiva
    val value = -2.0;
    currencyConversion.conversionValue = value;

    //teste - veririficar se o cod esta listado
    val code = "EUR"
    println(currencyConversion.codeIsValid(code));

    //teste - pegar entrada do usuário
    print("\n\n Entrada: ")
    val userInput: String = readLine().toString();

    //Teste - dividindo as entradas
    var inputSplit =  currencyConversion.splitCurrency(userInput);

    println("\n VALORES SEPARADOS ")
    println("* currentCurrency: ${inputSplit[0]} ")
    println("* conversionValue: ${inputSplit[1]} ")
    println("* currentDestiny:  ${inputSplit[2]} ")
}


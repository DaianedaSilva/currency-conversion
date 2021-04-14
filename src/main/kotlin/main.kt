class CurrencyConversion{
    //matriz com as taxas de cambio
    val currencyExchengeRate = arrayOf(        //AUD        BRL     EUR     IRR       USD
                                        arrayOf(1.0,     4.3009,  0.6403,  0.0000,  0.7630),  //AUD
                                        arrayOf(0.2324,  1.0,     0.1488,  0.0001,  0.1774),  //BRL
                                        arrayOf(1.5616,  6.7170,  1.0,     0.0000,  1.5615),  //EUR
                                        arrayOf(0.0000,  0.0001,  0.0000,  1.0,     0.0000),  //IRR
                                        arrayOf(1.31021, 5.6360,  0.8380,  0.0000,  1.0) )    //USD

    //possiveis moedas de conversão
    enum class curencyCode {AUD,BRL, EUR,IRR, USD }

    //atributo que recebe a moeda atual para a conversão
    var currentCurrency: String = ""
        set(value){
                field = value;
        };

    //atributo que recebe a moeda para qual ira ser feita a conversão
    var currencyDestiny:String = ""
        set(value){
            field = value;
        };

    //atributo que recebe o valor a ser convertido
    var conversionValue: Double = 0.0
        set(value){
            if (value > 0.0){
                field = value;
            }else{
                println("ENTRADA INVALIDA, NUMERO NEGATIVO")
            }
        };

    //verificar se os codes estão listados no sistema
    fun codeIsValid( code: String):Boolean{
        for (codes in curencyCode.values()){
            if( code == codes.name){
                return true;
            }
        }
        return false;
    }


    //dividir as variáveis ao encontrar um " "
    fun splitCorrency(userInput:String): Array<String>{
        val delimiter = " ";

        val splitValues = userInput.split(delimiter);

        val currentCurrencySplit = splitValues[0].slice(0 until 2)

        val conversionValueSplit = splitValues[0].slice(3 until splitValues[0].length)

        val currentDestinySplit = splitValues[1]

        val values = arrayOf(currentCurrencySplit,conversionValueSplit,currentDestinySplit)

        return values;

    }

}

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
    var inputSplit =  currencyConversion.splitCorrency(userInput);


    println("\n VALORES SEPARADOS ")
    println("* currentCurrency: ${inputSplit[0]} ")
    println("* conversionValue: ${inputSplit[1]} ")
    println("* currentDestiny: ${inputSplit[2]}  ")
}
class CurrencyConversion{
    //matriz com as taxas de cambio
    val currencyExchengeRate = arrayOf(        //AUD        BRL     EUR     IRR       USD
                                        arrayOf(1.0,     4.3009,  0.6403,  0.0000,  0.7630),  //AUD
                                        arrayOf(0.2324,  1.0,     0.1488,  0.0001,  0.1774),  //BRL
                                        arrayOf(1.5616,  6.7170,  1.0,     0.0000,  1.5615),  //EUR
                                        arrayOf(0.0000,  0.0001,  0.0000,  1.0,     0.0000),  //IRR
                                        arrayOf(1.31021, 5.6360,  0.8380,  0.0000,  1.0) )    //USD

    //possiveis moedas de conversão
    enum class CurencyCode {AUD,BRL, EUR,IRR, USD }

    //atributo que recebe a moeda atual para a conversão
    var currentCurrency: String = ""

    //atributo que recebe a moeda para qual ira ser feita a conversão
    var currencyDestiny:String = ""


    //atributo que recebe o valor a ser convertido
    var conversionValue: Double = 0.0
        set(value){
            if (value > 0.0){
                field = value;
            }else{
                println("ENTRADA INVALIDA, NUMERO NEGATIVO")
            }
        };

//    verificar se os codes estão listados no sistema
    fun codeIsValid( code: String):Boolean{
        for (codes in CurencyCode.values()){
            if( code == codes.name){
                return true;
            }
        }
        return false;
    }

    //dividir as variáveis ao encontrar um " "
    fun splitCurrency(userInput:String): Array<String>{
        val delimiter = " ";

        val splitValues = userInput.split(delimiter);

        val currentCurrencySplit = splitValues[0].slice(0 until 2)

        val conversionValueSplit = splitValues[0].slice(3 until splitValues[0].length)

        val currentDestinySplit = splitValues[1]

        val values = arrayOf(currentCurrencySplit,conversionValueSplit,currentDestinySplit)

        return values;
    }

}
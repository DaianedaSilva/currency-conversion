package com.creditas.trust.currencyconversion.data.models

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson

data class Post2(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
) {

    class Deserializer : ResponseDeserializable<Array<Post2>> {
        override fun deserialize(content: String): Array<Post2>
                = Gson().fromJson(content, Array<Post2>::class.java)
    }

}

fun main() {
    val URL = "https://jsonplaceholder.typicode.com/posts";

    val (request, response, result) = URL.httpGet().responseObject <Array<Post2>> (Post2.Deserializer())
//    val (request, response, result) = URL.httpGet().responseString()

//    println("... Request:")
//    println(request)
//    println("... Response:")
//    println(response)
//    println("... Result: ")
//    println(result)

    when (result) {
        is Result.Failure -> {
            val ex = result.getException()
            println(ex)
        }
        is Result.Success -> {
            val post = result.get()

            println(post[0].title)
        }
    }
}






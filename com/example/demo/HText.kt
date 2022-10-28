package com.example.demo

class HText() {

   var messageText = ""
        set(value) { field = value }

    var chatID = ""
        set(value) { field = value }

    fun selectText(chatID: Long, messageText:String) :String{
        var messageText = messageText.uppercase()
        println(messageText)
    var outText = ""
        when (messageText){
            "СЛАВА" -> outText = "Украјне"
            "КЕЙС" -> outText = "Работает"
            else -> outText="Кейс не прописан"
        }

        return outText
    }
}
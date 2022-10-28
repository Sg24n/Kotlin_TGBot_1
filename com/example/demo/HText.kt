package com.example.demo

class HText() {

   var messageText = ""
        set(value) { field = value }

    var chatID = ""
        set(value) { field = value }

    fun selectText(chatID: Long, messageText:String) :String{
    var outText = ""
        when (messageText){
            "Слава" -> outText = "Украјне"
            "кейс" -> outText = "Работает"
            else -> outText="Кейс не прописан"
        }

        return outText
    }
}
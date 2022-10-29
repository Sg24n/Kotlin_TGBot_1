package com.example.demo

class HText(var chatId: Long, var text: String) {

    //   private val admin_ID : Long =
    fun selectText(): String {
        var mtext = text.uppercase()
        var outText: String = "\nInput: '$mtext'\n"
        when (mtext) {
            "СЛАВА" -> outText += "Украјне"
            "КЕЙС" -> outText += "Работает"
            "РЕП" -> autoSend()
            else -> outText += "Кейс не прописан"
        }
        outText += " \nchatID: ${this.chatId}"
        println(outText)
        return outText
    }

    private fun autoSend() {
        println("Запрос\n")
        //BHook().sendNotification(this.chatId, text)
        lol()
    }
}

fun HText.lol(){
    println("Lol")
}
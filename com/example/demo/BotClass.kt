package com.example.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

//Main Class__________________________________________________________________________________________________________________________
@Component
class BotClass : TelegramLongPollingBot() {
    //БрАнИе приватной инфы из application.yml и присваивание переменным, передача их в функции класса
    @Value("\${telegram.botName}")
    private val botName: String = ""

    @Value("\${telegram.token}")
    private val token: String = ""
    override fun getBotUsername(): String = botName
    override fun getBotToken(): String = token

    //Приход________________________________________________________________________________________________________________
//O-o_ПОВЕЗЛО_ПОВЕЗЛО
    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            //Сохранение ID чата, и присланного текста
            val message = update.message
            val chatId = message.chatId

            //если пришлёл Текст_____________________________________________
            //Проверка на наличие текста в сообщении
            if (message.hasText()) {
                val responseText = selectText(chatId, message.text)
                sendNotification(chatId, responseText)
            } else {
                println("Текст отсутсвует")
            }
            //_______________________________________________________________!


            //если пришло фото_______________________________________________
            val responsePhoto = if (message.hasPhoto()) {
                val messagePhoto = message.photo

                println("File" + messagePhoto)

            } else {
                println("Фото отсутсвует\n")

            }
            //если пришло фото_______________________________________________!
        }


    }
//Приход________________________________________________________________________________________________________________!


    //Отправка сообщения_____________________________________________________
    private fun sendNotification(chatId: Long, responseText: String) {
        //for (i in 1..10) {
        val responseMessage = SendMessage(chatId.toString(), responseText)
        responseMessage.enableMarkdownV2(true)
        execute(responseMessage)
        //  }
    }
    //Отправка сообщения_____________________________________________________!

    //Обработка входящего текста_____________________________________________
    fun selectText(chatId: Long, text: String): String {
        val inText = text.uppercase()
        var outText: String = "\nInput: '$inText'\n"
        when (inText) {
            "СЛАВА" -> outText += "Украјне"
            "КЕЙС" -> outText += "Работает"
            "РЕП" -> outText += "Затычка"
            else -> outText += "Кейс не прописан"
        }
        outText += " \nchatID: ${chatId}"
        println(outText)
        return outText
    }
    //Обработка входящего текста_____________________________________________!


}
//Main Class__________________________________________________________________________________________________________________________!




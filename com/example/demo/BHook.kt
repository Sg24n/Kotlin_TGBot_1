package com.example.demo

import org.jvnet.hk2.annotations.Service
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.facilities.filedownloader.TelegramFileDownloader
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.objects.Update


@Component
class BHook : TelegramLongPollingBot() {
    //БрАнИе приватной инфы из application.yml и присваивание переменным, передача их в функции класса
    @Value("\${telegram.botName}")
    private val botName: String = ""

    @Value("\${telegram.token}")
    private val token: String = ""
    override fun getBotUsername(): String = botName
    override fun getBotToken(): String = token


    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            //Сохранение ID чата, и присланного текста
            val message = update.message
            val chatId = message.chatId

            //Проверка на наличие текста в сообщении
            val responseText = if (message.hasText()) {

                val messageText = message.text
                when {
                    messageText == "А" -> "Glory"
                    else -> "Вы написали: *$messageText*"
                }
            } else {
                "Я понимаю только текст"
            }
            sendNotification(chatId, responseText)

            println("Imput: '" + update.message.text + "'. Output: '" + responseText + "'")



            //если пришло фото----------------------------
            val responsePhoto = if (message.hasPhoto()) {
                val messagePhoto = message.photo



                println("File" + messagePhoto)

            } else {
                println("Фото отсутсвует")


            }
            //_____________________________________________
        }

    }


    private fun sendNotification(chatId: Long, responseText: String) {
        val responseMessage = SendMessage(chatId.toString(), responseText)
        responseMessage.enableMarkdownV2(true)
        execute(responseMessage)
    }
}




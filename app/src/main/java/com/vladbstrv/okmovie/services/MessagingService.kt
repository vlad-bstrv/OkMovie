package com.vladbstrv.okmovie.services

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        //Здесь можно отправить токен на сервер

        //получить токен еще раз
        FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
            //получили токен...
        }
    }

    //получение сообщения от сервера
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

    }
}
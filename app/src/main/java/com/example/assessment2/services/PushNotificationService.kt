package com.example.assessment2.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class PushNotificationService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.i("inside", "MESSAGE RECEIVED!!")
        if (remoteMessage.notification!!.body != null) {
            Log.i("inside", "RECEIVED MESSAGE: " + remoteMessage.notification!!.body)
        } else {
            Log.i("inside", "RECEIVED MESSAGE: " + remoteMessage.data["message"])
        }
    }
}
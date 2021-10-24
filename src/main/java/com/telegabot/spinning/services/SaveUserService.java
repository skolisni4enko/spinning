package com.telegabot.spinning.services;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveUserService {
    public SaveUserService(Message message) {
        String date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date(message.getDate() * 1000L));
        String user = "User name: " + message.getFrom().getUserName() +
                ", userID: " + message.getFrom().getId() +
                ", FirstName:" + message.getFrom().getFirstName() +
                ", LastName:" + message.getFrom().getLastName() +
                ", time: " + date;
        new FileWorker().setStringToFile(user);
    }


}

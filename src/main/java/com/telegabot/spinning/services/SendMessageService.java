package com.telegabot.spinning.services;

import com.telegabot.spinning.messagesender.MessageSender;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

@Service
public class SendMessageService {
    private final MessageSender messageSender;

    public SendMessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void method1(Message message) {
        var ms1 = SendMessage.builder()
                .text("You write: "+message.getText())
                .chatId(String.valueOf(message.getChatId()))
                .build();
        messageSender.sendMessage(ms1);
    }

//    public void method2(Message message) {
//        var markup = new ReplyKeyboardMarkup();
//        var keyboardRows = new ArrayList<KeyboardRow>();
//        var sendMessage = new SendMessage();
//
//
//
//        KeyboardRow row1 = new KeyboardRow();
//        KeyboardRow row2 = new KeyboardRow();
//        KeyboardRow row3 = new KeyboardRow();
//
//        row1.add("Button 1");
//        row1.add("Button 2");
//        row1.add("Button 3");
//
//        row2.add(KeyboardButton.builder().
//                text("Phone num send").
//                requestContact(true).
//                build());
//
//        row3.add(KeyboardButton.builder()
//                .requestLocation(true)
//                .text("Location")
//                .build());
//
//        keyboardRows.add(row1);
//        keyboardRows.add(row2);
//        keyboardRows.add(row3);
//
//
//        markup.setKeyboard(keyboardRows);
//        markup.setResizeKeyboard(true);
//
//        if (message.getText().equals("/start")) {
//            sendMessage.setText("Привет. Я - бот, что запущен в тестовом виде. Надеюсь, что скоро я буду уметь больше... А пока развлекайся! )");
//        } else {
//            FileWorker fileWorker = new FileWorker();
//
//            sendMessage.setText(fileWorker.getString());
//        }
//
//        sendMessage.setChatId(String.valueOf(message.getChatId()));
//        sendMessage.setReplyMarkup(markup);
//        messageSender.sendMessage(sendMessage);
//    }
}

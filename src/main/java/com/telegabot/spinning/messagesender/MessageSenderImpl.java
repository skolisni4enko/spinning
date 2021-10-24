package com.telegabot.spinning.messagesender;

import com.telegabot.spinning.SpinningBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSenderImpl implements MessageSender {

    private SpinningBot spinningBot;
    @Autowired
    public void setSpinningBot(SpinningBot spinningBot) {
        this.spinningBot = spinningBot;
    }

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            spinningBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

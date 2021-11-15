package com.telegabot.spinning.handlers;

import com.telegabot.spinning.ReadingExcel;
import com.telegabot.spinning.Solution;
import com.telegabot.spinning.messagesender.MessageSender;
import com.telegabot.spinning.objects.Person;
import com.telegabot.spinning.services.FileWorker;
import com.telegabot.spinning.services.SaveUserService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MessageHandler implements Handler<Message> {

    private final MessageSender messageSender;

    public MessageHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void choose(Message message) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> keyboard = new ArrayList<>();
        var readingFromExcel = new ReadingExcel();
        FileWorker fileWorker = new FileWorker();
        String result;
        if (message.hasText()) {
            System.out.println();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setParseMode("HTML");
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            String text = message.getText();

            if (!text.equals("ТУР1") && !text.equals("ТУР2") && !text.equals("ТУР3")) {
                List<Person> list;
                List<Person> list2;
                StringBuilder str2;
                StringBuilder str;
                switch (text) {
                    case "/start":
                        new SaveUserService(message);// USER SAVE
                        sendMessage.setReplyMarkup(setReplyKeyboardMarkup());
                        sendMessage.setParseMode("HTML");
                        sendMessage.setText(Solution.START_TEXT);
                        break;
                    case "Жеребьёвка":
                        list = readingFromExcel.readTossFromXlsx(Solution.EXCEL_TOSS);
                        if (list.isEmpty()) {
                            sendMessage.setText("Такого файла нет. Или результаты еще обрабатываются.");
                        } else {
                            str = new StringBuilder("<b><u>Жеребьёвка: </u></b>\n\n");
                            for (Person person:list) {
                                str.append(person.toStringToss()).append("\n");
                            }
                            sendMessage.setText(str.toString());
                        }

                        break;
                    case "Личка ТУР1":
                        list = readingFromExcel.readPersonalFromXlsx(Solution.EXCEL_PERSONAL, 0);
                        if (list.isEmpty()) {
                            sendMessage.setText("Такого файла нет. Или результаты еще обрабатываются.");
                        } else {
                            System.out.println(list.size());
                            //Чтобы не превышать символы в сообщении
                            if (list.size() > 50) {
                                list2 = list.subList(50, list.size());
                                list = list.subList(0, 50);

                                str = new StringBuilder("<b><u>Личный ТУР1:</u></b>\n\n");
                                for (Person person:list) {
                                    str.append(person.toStringPersonalCredit()).append("\n");
                                }
                                str2 = new StringBuilder();
                                for (Person person:list2) {
                                    str2.append(person.toStringPersonalCredit()).append("\n");
                                }

                                sendMessage.setText(str.toString());
                                messageSender.sendMessage(sendMessage);
                                sendMessage.setText(str2.toString());
                            } else {
                                str = new StringBuilder("<b><u>Личный ТУР1:</u></b>\n\n");
                                for (Person person:list) {
                                    str.append(person.toStringPersonalCredit()).append("\n");
                                }
                                sendMessage.setText(str.toString());

                            }
                           //TODO
                        }

                        break;
                    case "Личка ТУР1+2" :
                        list = readingFromExcel.readPersonalFromXlsx(Solution.EXCEL_PERSONAL, 1);
                        if (list.isEmpty()) {
                            sendMessage.setText("Такого файла нет. Или результаты еще обрабатываются.");
                        } else {
                            if (list.size() > 50) {
                                list2 = list.subList(50, list.size());
                                list = list.subList(0, 50);

                                str = new StringBuilder("<b><u>Личный ТУР1+2:</u></b>\n\n");
                                for (Person person : list) {
                                    str.append(person.toStringPersonalCredit()).append("\n");
                                }
                                str2 = new StringBuilder();
                                for (Person person : list2) {
                                    str2.append(person.toStringPersonalCredit()).append("\n");
                                }

                                sendMessage.setText(str.toString());
                                messageSender.sendMessage(sendMessage);
                                sendMessage.setText(str2.toString());
                            } else {
                                str = new StringBuilder("<b><u>Личный ТУР1+2:</u></b>\n\n");
                                 for (Person person : list) {
                                    str.append(person.toStringPersonalCredit()).append("\n");
                                 }
                                sendMessage.setText(str.toString());
                            }
                        }
                        break;
                    case Solution.BUTTON_PERSONAL_FINISH:
                        list = readingFromExcel.readPersonalFromXlsx(Solution.EXCEL_PERSONAL, 2);
                        if (list.isEmpty()) {
                            sendMessage.setText("Такого файла нет. Или результаты еще обрабатываются.");
                        } else {
                            if (list.size() > 50) {
                                list2 = list.subList(50, list.size());
                                list = list.subList(0, 50);

                                str = new StringBuilder("<b><u>Личка ИТОГ:</u></b>\n\n");
                                for (Person person : list) {
                                    str.append(person.toStringPersonalCredit()).append("\n");
                                }
                                str2 = new StringBuilder();
                                for (Person person : list2) {
                                    str2.append(person.toStringPersonalCredit()).append("\n");
                                }

                                sendMessage.setText(str.toString());
                                messageSender.sendMessage(sendMessage);
                                sendMessage.setText(str2.toString());
                            } else {
                                str = new StringBuilder("<b><u>Личка ИТОГ:</u></b>\n\n");
                                for (Person person : list) {
                                    str.append(person.toStringPersonalCredit()).append("\n");
                                }
                                sendMessage.setText(str.toString());
                            }
                        }
                        break;

                    case "Коман.Тур1":
                        list = readingFromExcel.readTeamFromXlsx(Solution.EXCEL_TEAM, 0);
                        if (list.isEmpty()) {
                            sendMessage.setText("Такого файла нет. Или результаты еще обрабатываются.");
                        } else {
                            str = new StringBuilder("<b><u>Командный ТУР1:</u></b>\n\n");
                            for (Person person:list) {
                                str.append(person.toStringTeamResult()).append("\n");
                            }
                            sendMessage.setText(str.toString());
                        }
                        break;
                    case "Коман.Тур1+2" :
                        list = readingFromExcel.readTeamFromXlsx(Solution.EXCEL_TEAM, 1);
                        if (list.isEmpty()) {
                            sendMessage.setText("Такого файла нет. Или результаты еще обрабатываются.");
                        } else {
                            str = new StringBuilder("<b><u>Командный ТУР1+2:</u></b>\n\n");
                            for (Person person:list) {
                                str.append(person.toStringTeamResult()).append("\n");
                            }
                            sendMessage.setText(str.toString());
                        }
                        break;
                    case Solution.BUTTON_TEAM_FINISH:
                        list = readingFromExcel.readTeamFromXlsx(Solution.EXCEL_TEAM, 2);
                        if (list.isEmpty()) {
                            sendMessage.setText("Такого файла нет. Или результаты еще обрабатываются.");
                        } else {
                            str = new StringBuilder("<b><u>Командный ИТОГ:</u></b>\n\n");
                            for (Person person:list) {
                                str.append(person.toStringTeamResult()).append("\n");
                            }
                            sendMessage.setText(str.toString());
                        }
                        break;
                    default:
                        str = new StringBuilder(fileWorker.getStringFromFile());
                        sendMessage.setText(str.toString());
                }
            } else {
                result = "Выберите зону";
                switch (text) {
                    case "ТУР1":
                        keyboard.add(InlineKeyboardButton.builder().text("ТУР_1 Зона-А").callbackData("tour1zoneA").build());
                        keyboard.add(InlineKeyboardButton.builder().text("ТУР_1 Зона-B").callbackData("tour1zoneB").build());
                        keyboard.add(InlineKeyboardButton.builder().text("ТУР_1 Зона-C").callbackData("tour1zoneC").build());
                        inlineKeyboardMarkup.setKeyboard(Collections.singletonList(keyboard));
                        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                        break;

                    case "ТУР2":
                        keyboard.add(InlineKeyboardButton.builder().text("ТУР_2 Зона-А").callbackData("tour2zoneA").build());
                        keyboard.add(InlineKeyboardButton.builder().text("ТУР_2 Зона-B").callbackData("tour2zoneB").build());
                        keyboard.add(InlineKeyboardButton.builder().text("ТУР_2 Зона-C").callbackData("tour2zoneC").build());
                        inlineKeyboardMarkup.setKeyboard(Collections.singletonList(keyboard));
                        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                        break;

                    case "ТУР3":
                        keyboard.add(InlineKeyboardButton.builder().text("ТУР_3 Зона-А").callbackData("tour3zoneA").build());
                        keyboard.add(InlineKeyboardButton.builder().text("ТУР_3 Зона-B").callbackData("tour3zoneB").build());
                        keyboard.add(InlineKeyboardButton.builder().text("ТУР_3 Зона-C").callbackData("tour3zoneC").build());
                        inlineKeyboardMarkup.setKeyboard(Collections.singletonList(keyboard));
                        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                        break;

                    default:
                        result = fileWorker.getStringFromFile();
                }
                sendMessage.setText(result);
            }
            sendMessage.setParseMode("HTML");
            messageSender.sendMessage(sendMessage);
        }
    }
// create keyboard on start
    public ReplyKeyboardMarkup setReplyKeyboardMarkup() {
        var markup = new ReplyKeyboardMarkup();
        var keyboardRows = new ArrayList<KeyboardRow>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        KeyboardRow row4 = new KeyboardRow();

        row1.add("ТУР1");
        row1.add("ТУР2");
        row1.add("ТУР3");

        row2.add("Личка ТУР1");
        row2.add("Личка ТУР1+2");
        row2.add(Solution.BUTTON_PERSONAL_FINISH);

        row3.add("Коман.Тур1");
        row3.add("Коман.Тур1+2");
        row3.add(Solution.BUTTON_TEAM_FINISH);

        row4.add("Жеребьёвка");
        row4.add(Solution.BUTTON_STATISTIC);

        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);
        keyboardRows.add(row4);

        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);

        return markup;
    }
}

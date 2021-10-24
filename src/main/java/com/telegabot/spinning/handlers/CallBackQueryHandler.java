package com.telegabot.spinning.handlers;

import com.telegabot.spinning.ReadingExcel;
import com.telegabot.spinning.Solution;
import com.telegabot.spinning.messagesender.MessageSender;
import com.telegabot.spinning.objects.Person;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.List;

@Component
public class CallBackQueryHandler implements Handler<CallbackQuery> {

    private final MessageSender messageSender;

    public CallBackQueryHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void choose(CallbackQuery callbackQuery) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(callbackQuery.getMessage().getChatId()));

        String callbackQueryData = callbackQuery.getData();
        String result="";

        switch (callbackQueryData) {
            //ТУР1 - ЗОНЫ
            case "tour1zoneA":
                result = getDataTourAndZone(Solution.EXCEL_TOUR1, 0);
                break;
            case "tour1zoneB":
                result = getDataTourAndZone(Solution.EXCEL_TOUR1, 1);
                break;
            case "tour1zoneC":
                result = getDataTourAndZone(Solution.EXCEL_TOUR1, 2);
                break;
            //ТУР2 - ЗОНЫ
            case "tour2zoneA":
                result = getDataTourAndZone(Solution.EXCEL_TOUR2, 0);
                break;
            case "tour2zoneB":
                result = getDataTourAndZone(Solution.EXCEL_TOUR2, 1);
                break;
            case "tour2zoneC":
                result = getDataTourAndZone(Solution.EXCEL_TOUR2, 2);
                break;
            //ТУР3 - ЗОНЫ
            case "tour3zoneA":
                result = getDataTourAndZone(Solution.EXCEL_TOUR3, 0);
                break;
            case "tour3zoneB":
                result = getDataTourAndZone(Solution.EXCEL_TOUR3, 1);
                break;
            case "tour3zoneC":
                result = getDataTourAndZone(Solution.EXCEL_TOUR3, 2);
                break;

            default:result = "Ой, ошибка...";
        }

        sendMessage.setReplyToMessageId(callbackQuery.getMessage().getMessageId());
        sendMessage.setParseMode("HTML");
        sendMessage.setText(result);
        messageSender.sendMessage(sendMessage);
    }

    String getDataTourAndZone(String pathToExcelFile, int sheetIndex) {
        List<Person> personList;
        String result;
        if (pathToExcelFile.contains("ТУР1.xlsx")){
            if (sheetIndex == 0)
                result = "<b><u>ТУР - 1, Зона - А</u></b>";
            else if (sheetIndex ==1)
                result = "<b><u>ТУР - 1, Зона - B</u></b>";
            else if (sheetIndex == 2)
                result = "<b><u>ТУР - 1, Зона - C</u></b>";
            else result = "Что-то пошло не так...";

        } else if (pathToExcelFile.contains("ТУР2.xlsx")) {
            if (sheetIndex == 0)
                result = "<b><u>ТУР - 2, Зона - А</u></b>";
            else if (sheetIndex == 1)
                result = "<b><u>ТУР - 2, Зона - B</u></b>";
            else if (sheetIndex == 2)
                result = "<b><u>ТУР - 2, Зона - C</u></b>";
            else result = "Что-то пошло не так...";
        } else if (pathToExcelFile.contains("ТУР3.xlsx")) {
            if (sheetIndex == 0)
                result = "<b><u>ТУР - 3, Зона - А</u></b>";
            else if (sheetIndex == 1)
                result = "<b><u>ТУР - 3, Зона - B</u></b>";
            else if (sheetIndex == 2)
                result = "<b><u>ТУР - 3, Зона - C</u></b>";
            else result = "Что-то пошло не так...";
        } else
            result = "Наверное, результаты еще не готовы...";

        personList = new ReadingExcel().readZoneFromXlsx(pathToExcelFile, sheetIndex);
        if (!personList.isEmpty()) {
            for (Person person : personList) {
                result = result + "\n\n" + person.toStringZone();
            }
        }
        else  result = "Наверное, результаты еще не готовы...";

        return result;
    }
}

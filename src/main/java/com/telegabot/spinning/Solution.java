package com.telegabot.spinning;

import org.springframework.stereotype.Component;

@Component
public class Solution {

    //Стартовый текст бота
    public static final String START_TEXT = "Привет. Я - бот, что запущен в тестовом режиме. " +
            "Надеюсь, что скоро я буду уметь больше... А пока развлекайся!\n\n\n" +
            "<a href='https://www.ligaspining.com.ua'>Наш сайт:</a>";

    //Пути к файлам туров соревнований. Внутри туров лежат зоны (A, B, C)
    public static final String EXCEL_TOUR1 = "..\\spinning\\src\\docsexcel\\По зонам ТУР1.xlsx";
    public static final String EXCEL_TOUR2 = "..\\spinning\\src\\docsexcel\\По зонам ТУР2.xlsx";
    public static final String EXCEL_TOUR3 = "..\\spinning\\src\\docsexcel\\По зонам ТУР3.xlsx";

    public static final String EXCEL_TOSS = "..\\spinning\\src\\docsexcel\\ЖЕРЕБ.xlsx";

    public static final String EXCEL_PERSONAL = "..\\spinning\\src\\docsexcel\\Особистий залік.xlsx";
    public static final String EXCEL_TEAM = "..\\spinning\\src\\docsexcel\\Командний залік.xlsx";

    //для кнопок
    public static final String BUTTON_STATISTIC = "Статистика";
    public static final String BUTTON_PERSONAL_FINISH = "Личка ИТОГ";
    public static final String BUTTON_TEAM_FINISH = "Команд.ИТОГ";
}

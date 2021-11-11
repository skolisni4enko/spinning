package com.telegabot.spinning;

import com.telegabot.spinning.objects.Person;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ReadingExcel {
    private FileInputStream inputStream;

    public List<Person> readZoneFromXlsx(String pathToFile, int sheetIndex) {
        List<Person> result = new ArrayList<>();
        try {
            inputStream = new FileInputStream(pathToFile);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
            int rows = sheet.getLastRowNum();

            for (int r = 6; r <= rows; r++) {
                XSSFRow row = sheet.getRow(r);
                var person = new Person();

                person.setPlacePerson((int) row.getCell(0).getNumericCellValue());
                person.setNamePerson(row.getCell(1).getStringCellValue());
                person.setTeamPerson(row.getCell(2).getStringCellValue());
                person.setHomePerson(row.getCell(3).getStringCellValue());
                person.setTakeFish((int) row.getCell(4).getNumericCellValue());
                person.setScore((int) row.getCell(5).getNumericCellValue());

                result.add(person);
            }

            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("бля.. файла С ЗОНАМИ нет... :(");

        }
        return result;
    }

    public List<Person> readTossFromXlsx (String pathToFile) {
        List<Person> result = new ArrayList<>();

        try {
            inputStream = new FileInputStream(pathToFile);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getLastRowNum();

            for (int r = 5; r <= rows; r++) {
                XSSFRow row = sheet.getRow(r);
                var person = new Person();
                String zone = "";
                person.setIdPerson((int) row.getCell(0).getNumericCellValue());
                person.setNamePerson(row.getCell(1).getStringCellValue());
                zone = zone + row.getCell(3);
                zone = zone + " - " + row.getCell(4);
                zone = zone + " - " + row.getCell(5);
                person.setZones(zone);

                result.add(person);
            }

            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("бля.. файла ЖЕРЕБЬЕВКИ нет... :(");
        }

        return result;
    }

    public List<Person> readPersonalFromXlsx(String pathToFile, int sheetIndex) {
        List<Person> result = new ArrayList<>();

        try {
            inputStream = new FileInputStream(pathToFile);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

            int rows = sheet.getLastRowNum();

            for (int r = 6; r <= rows; r++) {
                XSSFRow row = sheet.getRow(r);
                var person = new Person();

                person.setPlacePerson((int) row.getCell(0).getNumericCellValue());
                person.setNamePerson(row.getCell(2).getStringCellValue());
                person.setTeamPerson(row.getCell(3).getStringCellValue());
                person.setSumPlace((int) row.getCell(1).getNumericCellValue());
                person.setScore((int) row.getCell(5).getNumericCellValue());
                person.setTakeFish((int) row.getCell(6).getNumericCellValue());

                result.add(person);
            }

            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("бля.. файла ЛИЧКИ нет... :(");
        }

        return result;
    }

    public List<Person> readTeamFromXlsx(String pathToFile, int sheetIndex) {
        List<Person> result = new ArrayList<>();

        try {
            inputStream = new FileInputStream(pathToFile);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

            int rows = sheet.getLastRowNum();

            for (int r = 6; r <= rows; r++) {
                XSSFRow row = sheet.getRow(r);
                var person = new Person();

                person.setPlacePerson((int) row.getCell(0).getNumericCellValue());
                person.setNamePerson(row.getCell(2).getStringCellValue());
                person.setSumPlace((int) row.getCell(1).getNumericCellValue());
                person.setScore((int) row.getCell(5).getNumericCellValue());
                person.setTakeFish((int) row.getCell(4).getNumericCellValue());

                result.add(person);
            }

            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("бля.. файла КОМАНД нет... :(");
        }

        return result;
    }
}

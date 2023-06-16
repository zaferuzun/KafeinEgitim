package com.kafein;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class Genisbant {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Kafein\\Desktop\\gb-iyileştirme\\GB-SON.xlsx");
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        ArrayList<Hatalar> hatalarArrayList=new ArrayList<>();
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
            Hatalar hatalar = new Hatalar();
            int i=0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String value ="";
                switch (cell.getCellType())
                {
                    case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                        value = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                        value = Integer.valueOf((int) cell.getNumericCellValue())+"";
                        break;
                    default:
                }
                if (i==0){
                    hatalar.setMessage_code(value);
                }else if (i==1){
                    hatalar.setMessage(value);
                }else if (i==2){
                    hatalar.setPage_map(value);
                }
                i++;
            }
            hatalarArrayList.add(hatalar);
        }
//        String str="deneme ";
//        String str2= null;

        for (Hatalar hata:hatalarArrayList
        ) {

            String msg_id= "MESSAGE_PROPERTIES_SEQ.NEXTVAL";
            String message_code = hata.getMessage_code().trim();
            String message = hata.getMessage().trim();
            String page_map = hata.getPage_map().trim();

            String insert = "INSERT INTO WSC_TT_R.MESSAGE_PROPERTIES (MSG_PROP_ID, MESSAGE_CODE, MESSAGE, PAGE_MAP) Values("+msg_id
                    +", '"+message_code+"','"+message+"', '"+page_map+"');";
            System.out.println(insert);

//            String select = "DELETE From WSC_TT_R.MESSAGE_PROPERTIES where MESSAGE_CODE= '"+message_code+"' AND PAGE_MAP='"+page_map+"';";
//            System.out.println(select);
        }
//        String s1 = "tan\\u0131mlan\\u0131r.";
////        System.out.println(s1);
////        byte[] bytes = s1.getBytes("UTF-8"); // Charset to encode into
////        String str = new String(bytes, StandardCharsets.UTF_8);
////        System.out.println(str);
//        ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(s1);
//
//        String utf8String = new String(byteBuffer.array(), StandardCharsets.UTF_8);
//        System.out.println(utf8String);
    }

    static class Hatalar{
        String message_code;
        String message;
        String page_map;

        public String getMessage_code() {
            return message_code;
        }

        public void setMessage_code(String message_code) {
            this.message_code = message_code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getPage_map() {
            return page_map;
        }

        public void setPage_map(String page_map) {
            this.page_map = page_map;
        }

        @Override
        public String toString() {
            return "Hatalar{" +
                    "message_code='" + message_code + '\'' +
                    ", message='" + message + '\'' +
                    ", page_map='" + page_map + '\'' +
                    '}';
        }
    }
}

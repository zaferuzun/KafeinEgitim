//package com.kafein;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Locale;
//
//public class EmreMain {
//
//    public static void main(String[] args) throws IOException {
////        String str = "INSERT INTO ZUZUN.HATA_MESAJLARI (CEVAP_KODU , BOHM_CODE , KULLANICI_MESAJI , CLASS_NAME , METHOD_NAME )VALUES ('null', 'FATC002', 'Lütfen girdiğiniz irtibat gsm numaranızı kontrol ediniz.','FaturaController', ' faturaGonderimSekliDegistir');";
////        for (int i=0;i<str.length();i++){
////            System.out.println(i+ " " + str.charAt(i));
////        }
//        File file = new File("C:\\Users\\Kafein\\Desktop\\bohm_islem_tipi.xlsx");
//        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//        XSSFWorkbook wb = new XSSFWorkbook(fis);
//        ArrayList<Deneme> hatalarArrayList=new ArrayList<>();
//        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
//        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
//        while (itr.hasNext()) {
//            Row row = itr.next();
//            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
//            Deneme hatalar = new Deneme();
//            int i=0;
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                String value ="";
//                switch (cell.getCellType())
//                {
//                    case Cell.CELL_TYPE_STRING:    //field that represents string cell type
//                        value = cell.getStringCellValue();
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
//                        value = Integer.valueOf((int) cell.getNumericCellValue())+"";
//                        break;
//                    default:
//                }
//                if (i==0){
//                    hatalar.setId(value);
//                }else if (i==1){
//                    hatalar.setId2(value);
//                }
//                i++;
//            }
//            hatalarArrayList.add(hatalar);
//        }
//        String str="deneme ";
//        String str2= null;
//
//        for (Deneme hata:hatalarArrayList) {
//            String id= hata.getId();
//            String id2= hata.getId2();
//
//            String insert = "INSERT INTO ECETIN.BOHM_LOG_ISLEM_TIPI (ID, KISA_ACIKLAMA, ADI, LEGACY_ACIKLAMA, ACIKLAMA)VALUES ('"+id2+"', '"+id+"', '"+id+"', '"+id+"', '"+id+"')";
//            System.out.println(insert);
//        }
//    }
//    static class Deneme{
//        String id;
//        String id2;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getId2() {
//            return id2;
//        }
//
//        public void setId2(String id2) {
//            this.id2 = id2;
//        }
//    }
//}

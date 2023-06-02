//package com.kafein;
//
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.FormulaEvaluator;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Locale;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
////        String str = "INSERT INTO ZUZUN.HATA_MESAJLARI (CEVAP_KODU , BOHM_CODE , KULLANICI_MESAJI , CLASS_NAME , METHOD_NAME )VALUES ('null', 'FATC002', 'Lütfen girdiğiniz irtibat gsm numaranızı kontrol ediniz.','FaturaController', ' faturaGonderimSekliDegistir');";
////        for (int i=0;i<str.length();i++){
////            System.out.println(i+ " " + str.charAt(i));
////        }
////        File file = new File("C:\\Users\\Kafein\\Desktop\\kurumsal-iyilestirmeler - Kopya.xlsx");
////        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
////        XSSFWorkbook wb = new XSSF/Workbook(fis);
//        ArrayList<Hatalar> hatalarArrayList=new ArrayList<>();
//        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
//        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
//        while (itr.hasNext()) {
//            Row row = itr.next();
//            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
//            Hatalar hatalar = new Hatalar();
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
//                    hatalar.setCevap_kodu(value);
//                }else if (i==1){
//                    hatalar.setBohm_kodu(value);
//                }else if (i==2){
//                    hatalar.setMesaj(value);
//                }else if (i==3){
//                    hatalar.setClassname(value);
//                }else if (i==4){
//                    hatalar.setMethotname(value);
//                }
//                i++;
//            }
//            hatalarArrayList.add(hatalar);
//        }
//        String str="deneme ";
//        String str2= null;
//
//        for (Hatalar hata:hatalarArrayList
//             ) {
//            String cevapkodu= hata.getCevap_kodu().toLowerCase(Locale.ROOT).equals("null")?"":hata.getCevap_kodu().trim();
//            String bohmkodu= hata.getBohm_kodu().toLowerCase(Locale.ROOT).equals("null")?"":hata.getBohm_kodu().trim();
//            cevapkodu= cevapkodu.equals("\"00\"")?"00":cevapkodu;
//            bohmkodu= bohmkodu.equals("\"00\"")?"00":bohmkodu;
//            String classname = hata.getClassname().trim();
//            String methotname = hata.getMethotname().trim();
//
//            String insert = "INSERT INTO ZUZUN.HATA_MESAJLARI (CEVAP_KODU , BOHM_CODE , KULLANICI_MESAJI , CLASS_NAME , METHOD_NAME )VALUES ('"+cevapkodu
//                    +"', '"+bohmkodu+"', '"+hata.getMesaj()+"','"+classname+"', '"+methotname+"');";
//            System.out.println(insert);
//        }
//    }
//    static class Hatalar{
//        String cevap_kodu;
//        String bohm_kodu;
//        String classname;
//        String mesaj;
//        String methotname;
//
//        public String getCevap_kodu() {
//            return cevap_kodu;
//        }
//
//        public void setCevap_kodu(String cevap_kodu) {
//            this.cevap_kodu = cevap_kodu;
//        }
//
//        public String getBohm_kodu() {
//            return bohm_kodu;
//        }
//
//        public void setBohm_kodu(String bohm_kodu) {
//            this.bohm_kodu = bohm_kodu;
//        }
//
//        public String getClassname() {
//            return classname;
//        }
//
//        public void setClassname(String classname) {
//            this.classname = classname;
//        }
//
//        public String getMesaj() {
//            return mesaj;
//        }
//
//        public void setMesaj(String mesaj) {
//            this.mesaj = mesaj;
//        }
//
//        public String getMethotname() {
//            return methotname;
//        }
//
//        public void setMethotname(String methotname) {
//            this.methotname = methotname;
//        }
//
//        @Override
//        public String toString() {
//            return "Hatalar{" +
//                    "cevap_kodu='" + cevap_kodu + '\'' +
//                    ", bohm_kodu='" + bohm_kodu + '\'' +
//                    ", classname='" + classname + '\'' +
//                    ", mesaj='" + mesaj + '\'' +
//                    ", methotname='" + methotname + '\'' +
//                    '}';
//        }
//    }
//
//}
//
//
//

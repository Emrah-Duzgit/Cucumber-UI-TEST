package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    /**
     * Bir önceki yapılan soruda, Kullanıcıya 1.sütundaki tüm değer bir liste halinde kullanıcıya
     * yanlarında bi numara olarak sunalım. Kullanıcı hangi numararyı girerese o satırın
     * yanındaki tüm bilgiler gösterilsin.
     * Username için 1
     * Password için 2
     * ....
     * ...
     * giririniz = 2
     */
    public static void main(String[] args) {

        System.out.println("Satir numarası = ");
        Scanner oku = new Scanner(System.in);
        int satirNumarasi = oku.nextInt();

        String donenSonuc = bul(satirNumarasi);
        System.out.println("donen sonuc = " + donenSonuc);
    }

    public static String bul(int satirNumarasi) {
        String donecek = "";

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);

                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                        donecek +=  row.getCell(j)+" ";

                }


        }
        return donecek;
    }
}


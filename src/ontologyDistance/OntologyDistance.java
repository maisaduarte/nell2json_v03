/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ontologyDistance;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class OntologyDistance {

    public static void main(String[] args) {

        //String sfileNameInput = "C:\\Users\\Maisa\\Desktop\\Temp para NELL\\categories.xls";
        String sfileNameInput = "D:\\Dropbox\\Doutorado\\Seeds - Planillhas - To SVN\\Files updated\\ARQUIVOS CONF - OKAY PARA SUBSTITUIR\\ambiente pt - 07042017\\categories_pt_noaccents.xls";
        String sfileNameOutput = "C:\\Users\\Maisa\\Desktop\\Temp para NELL\\OntologyDistance_v01_Portuguese";
        Map<String, List<String>> mColumnsInList = readCSV(sfileNameInput);

        Map<String, Integer> mOntologyDistance = new HashMap<>();
        mOntologyDistance = calcOntologyDistance(mColumnsInList);
        // printMap(mOntologyDistance);
        printMap2File(mOntologyDistance, sfileNameOutput);
    }

    public static Map<String, Integer> calcOntologyDistance(Map<String, List<String>> mColumnsInList) {
        Map<String, Integer> mOntologyDistance = new HashMap<>();
        Map<String, List<String>> mColumnsInListTEMP = new HashMap<>();
        mColumnsInListTEMP.putAll(mColumnsInList);

        Iterator it = mColumnsInList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            //System.out.println(pair.getKey() + " = " + pair.getValue());

            if (pair.getValue().toString().equals("")) {
                mOntologyDistance.put(pair.getKey().toString(), 1);
            } else {
                mOntologyDistance.put(pair.getKey().toString(),
                        getOntologyLevel(pair.getKey().toString(), mColumnsInListTEMP));
            }
            it.remove(); // avoids a ConcurrentModificationException
        }

        return mOntologyDistance;
    }

    public static int getOntologyLevel(String sWord, Map<String, List<String>> mColumnsInList) {
        int iCountLevel = 1;
        //sWord is EverythingPromoted, the first one in the ontology level
        try {
            if (sWord.equals("everypromotedthing")) {
                return 1;
            } else if (mColumnsInList.get(sWord).contains("everypromotedthing")) {
                return 1;
            } else {
                List<String> lTemp = mColumnsInList.get(sWord);
                for (String sCategory : lTemp) {
                    iCountLevel += getOntologyLevel(sCategory, mColumnsInList);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("teste " + sWord);
        }
        return iCountLevel;
    }

    public static Map<String, List<String>> readCSV(String sfileName) {

        Map<String, List<String>> columnsInList = new HashMap<>();

        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(sfileName));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cName;
            HSSFCell cGeneralizations;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for (int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if (tmp > cols) {
                        cols = tmp;
                    }
                }
            }

            for (int r = 1; r < rows; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    cName = row.getCell((short) 0);
                    cGeneralizations = row.getCell((short) 5);
                    List<String> lTemp = new ArrayList<>();
                    lTemp = Arrays.asList(cleanString(cGeneralizations.toString()).split(" "));
                    columnsInList.put(cleanString(cName.toString()), lTemp);
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return columnsInList;
    }

    public static String cleanString(String stemp) {
        return stemp.replace(",", " ").replaceAll("\\s+", " ").toLowerCase();
    }

    public static void printMap(Map<String, Integer> mOntologyDistance) {
        SortedSet<String> keys = new TreeSet<>(mOntologyDistance.keySet());
        for (String key : keys) {
            int value = mOntologyDistance.get(key);
            System.out.println(key + " = " + value);
        }
    }

    public static void printMap2File(Map<String, Integer> mOntologyDistance, String sFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sFileName, false))) {

            String content = "CategoryName\tOntologyDistance\n";
            bw.write(content);

            ValueComparator bvc = new ValueComparator(mOntologyDistance);
            TreeMap<String, Integer> sorted_map = new TreeMap<>(bvc);
            sorted_map.putAll(mOntologyDistance);

            for (Map.Entry<String, Integer> entry : sorted_map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                bw.write(key + "\t" + value + "\n");
            }

            //Ordem alfabética
            /*   SortedSet<String> keys = new TreeSet<>(mOntologyDistance.keySet());
            for (String key : keys) {
                int value = mOntologyDistance.get(key);
                bw.write(key + "\t" + value + "\n");
            }*/
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ValueComparator implements Comparator<String> {

        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with
        // equals.
        @Override
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }
}

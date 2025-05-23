package utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.apache.poi.ss.usermodel.TableStyleType.totalRow;

public class ExelReader {

        FileInputStream fi;
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;

    public List<Map<String,String>> getData(String filepath, String sheetname) throws IOException {
        fi=new FileInputStream(filepath);
        workbook=new XSSFWorkbook(fi);
        sheet= workbook.getSheet(sheetname);
       workbook.close();
       //XSSFSheet st= wk.getSheet(sheetname);
        return readSheet(sheet);
    }

    private List<Map<String, String>> readSheet(XSSFSheet sheet)
    {
       int totalRow= sheet.getLastRowNum();
        List<Map<String, String>> exelRows=new ArrayList<Map<String,String>>();
        for(int i=1;i<=totalRow;i++)
        {
            row=sheet.getRow(i);
           int totalColumn=row.getLastCellNum();
            LinkedHashMap<String, String> columnMapdata=new LinkedHashMap<String,String>();

            for(int currentColumn=1;currentColumn<totalColumn;currentColumn++)
            {
                cell=row.getCell(currentColumn);
                String columnHeaderName= String.valueOf(sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn));
                columnMapdata.put(columnHeaderName, cell.getStringCellValue());
            }
            exelRows.add(columnMapdata);
        }
        return exelRows;
    }

    public int countRow(){
        return totalRow.ordinal();
    }

}

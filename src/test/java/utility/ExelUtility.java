package utility;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExelUtility {


    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    String path;

    public ExelUtility(String path)
    {
        this.path=path;
    }


    public int getRowCount(String sheetName) throws IOException, IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        int rowcount=sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowcount;
    }

    public int getCellCount(String sheetName,int rownum) throws IOException
    {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);

        row=sheet.getRow(rownum);
        int cellcount=row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellcount;
    }

    public String getCellData(String sheetName, int rownum, int column) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);

        row=sheet.getRow(rownum);
        cell=row.getCell(column);

        DataFormatter formatter=new DataFormatter();
        String Data;
        try
        {
            Data=formatter.formatCellValue(cell);
        }
        catch(Exception e)
        {
            Data="";
        }

        workbook.close();
        fi.close();
        return Data;
    }

    public List<Map<String,String>>storeData(String filePath, String sheetName) throws IOException
    {
        fi=new FileInputStream(filePath);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        int lastRowNo =sheet.getLastRowNum();
        List<Map<String,String>> exelData=new ArrayList<>();

        for(int i = 0; i<= lastRowNo; i++)
        {
            row = sheet.getRow(i);
            int totalColumn = row.getLastCellNum();
            LinkedHashMap<String, String> columnMapdata=new LinkedHashMap<String,String>();
            String Data1 = null;
            for (int colmn = 0; colmn <= totalColumn; colmn++)
            {
               cell = row.getCell(colmn);
                DataFormatter formatter = new DataFormatter();
                try
                {
                    Data1=formatter.formatCellValue(cell);
                }
                catch (Exception e)
                {
                    Data1 = "";
                }
                String columnHeaderName=String.valueOf(sheet.getRow(sheet.getFirstRowNum()).getCell(colmn));
                columnMapdata.put(columnHeaderName,Data1);
            }
            exelData.add(columnMapdata);
        }
        return exelData;
    }



    public void setCellData(String sheetName,int rownum,int column,String data) throws IOException
    {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.createCell(column);
        cell.setCellValue(data);
        fo=new FileOutputStream(path);
        workbook.close();
        fi.close();
        fo.close();
    }

    public static void CellToAnyData()
    {
        String user;
        String pss;
        if(cell!=null&&cell.getCellType()== CellType.STRING)
        {
            user=cell.getStringCellValue();
            System.out.println(user);
        }

        if(cell!=null&&cell.getCellType()== CellType.STRING)
        {
            pss=cell.getStringCellValue();
            System.out.println(pss);
        }
    }


}

package utility;
import factory.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
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
    static Logger logger = LogManager.getLogger(ExelUtility.class);
    public ExelUtility(String path)
    {
        this.path=path;
    }

    public List<Map<String,String>> storeData001(String filePath, String sheetName) throws IOException {
        logger.info("Starting to read Excel data from file: " + filePath + ", sheet: " + sheetName);

        fi = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            logger.error("Sheet with name '" + sheetName + "' not found.");
            throw new IllegalArgumentException("Sheet with name '" + sheetName + "' not found.");
        }

        int lastRowNo = sheet.getLastRowNum();
        logger.info("Total rows found (excluding header): " + lastRowNo);

        List<Map<String,String>> excelData = new ArrayList<>();
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            throw new IllegalArgumentException("Header row is missing in sheet: " + sheetName);
        }

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i <= lastRowNo; i++) {
            row = sheet.getRow(i);
            if (row == null || row.getLastCellNum() == -1) {
                logger.warn("Skipping empty/null row at index: " + i);
                continue;
            }

            LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();
            for (int col = 0; col < headerRow.getLastCellNum(); col++) {
                String header = formatter.formatCellValue(headerRow.getCell(col));
                String value = formatter.formatCellValue(row.getCell(col));
                columnMapdata.put(header, value);
            }

            excelData.add(columnMapdata);
            logger.info("Row " + i + " processed and added to data list.");
        }

        workbook.close();
        fi.close();
        logger.info("Excel data extraction completed successfully.");
        return excelData;
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

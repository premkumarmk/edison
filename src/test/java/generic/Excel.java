package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static String getData(String path,String sheet,int r,int c)
	{
		String v="";
		try 
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return v;
	}
	
	public static int getRowCount(String path,String sheet)
	{
		int rowCount=0;
		
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rowCount=wb.getSheet(sheet).getLastRowNum();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	//add a method to count columns
	public static int getColCount(String path,String sheet)
	{
		
		int colCount=0;
		
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			
			colCount=wb.getSheet(sheet).getRow(0).getLastCellNum();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return colCount;
	}
	
    public Object[][] to2DArray(String path,String sheet) throws Exception {
        int noOfRows = getRowCount(path, sheet);
        int noOfCells = getColCount(path, sheet);
        Object obj[][] = new Object[noOfRows][noOfCells];

        for(int i=0; i<noOfRows; i++){ //i = 0 1 2
            //row = sh.getRow(i);
            for(int j=0; j<noOfCells; j++){
            	
                obj[i][j] = getData( path, sheet, i+1, j); //i = 1 2 3
                System.out.println("Row num:"+i+"  ,  Coulmn Num:"+j+"  ,  "+obj[i][j]);
            }
        }
        return obj;
    }
	
	//method to write the data
	
}

package com.lenovo.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Excel导出（导入）工具类
 * @author Administrator
 *
 */
public class ExcelUtil {

	/**
	 * 数据导出
	 * @param list
	 * @param path
	 */
	public static void exportData(List<HashMap<String, Object>> list,String path){
		String[] title = {"No","PN","Description","BorrowDate"};
		
		//1.创建一个工作薄对象
		WritableWorkbook wb = null;
		
		File file = new File(path);
		
		try {
			wb = Workbook.createWorkbook(file);
			
			//2.创建工作表
			WritableSheet sheet = wb.createSheet("2017物流统计总表", 0);
			
			//3.生成表头
			Label label = null;
			for(int i=0;i<title.length;i++){
				label = new Label(i,0,title[i]);
				sheet.addCell(label);
			}
			//4.追加数据
			Label label2 = null;
			HashMap<String, Object> map = null;
			for(int i=0;i<list.size();i++){
				map = list.get(i);
				//向i+1行的第一列格子里追加数据
				label2 = new Label(0,i+1,String.valueOf(map.get("No")));
				sheet.addCell(label2);
				//向i+1行的第二列格子里追加数据
				label2 = new Label(1,i+1,String.valueOf(map.get("PN")));
				sheet.addCell(label2);
				//向i+1行的第三列格子里追加数据
				label2 = new Label(2,i+1,String.valueOf(map.get("Description")));
				sheet.addCell(label2);
				//向i+1行的第四列格子里追加数据
				label2 = new Label(3,i+1,String.valueOf(map.get("BorrowDate")));
				sheet.addCell(label2);
			}
			wb.write();
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
//	public static void main (String[] args){
//		List<HashMap<String, Object>> list = DataDownUtil.getJobInfo("file:///F:/Noname1--ANSI.html","gbk");
//		ExcelUtil eu = new ExcelUtil();
//		String path = "C:\\lenovo_mmweb.xls";
//		eu.exportData(list, path);
//	}

}

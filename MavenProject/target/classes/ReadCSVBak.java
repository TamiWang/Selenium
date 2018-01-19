package resources;

/**
 * 参�?虫师    �?.3.3 读取csv 文件�?
 */
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;

public class ReadCSVBak {
	
	public void readCSVFile(String filePath) throws IOException{
		// ArrayList 用来保存数据
		ArrayList<String[]> csvList = new ArrayList<String[]>();
		// �?��用这编码读就可以�?
		CsvReader reader = new CsvReader(filePath, ',', Charset.forName("SJIS"));
		// 跳过表头，如果需要表头，不要写这�?
		reader.readHeaders();
		
		while(reader.readRecord()){  // 逐行读入除表头的数据
			csvList.add(reader.getValues());
		}
		
		reader.close();
		
		for(int row=0; row<csvList.size(); row++){
			System.out.println(csvList.get(row)[0]);
			System.out.println(csvList.get(row)[1]);
			System.out.println(csvList.get(row)[2]);
			System.out.println(csvList.get(row)[3]);
			System.out.println(csvList.get(row)[4]);
			System.out.println(csvList.get(row)[5]);
			System.out.println(csvList.get(row)[6]);
			System.out.println(csvList.get(row)[7]);
			System.out.println(csvList.get(row)[8]);
			System.out.println("---------------------------");
		}
	
	}

}

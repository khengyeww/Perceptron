import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadInputData {

	private static BufferedReader reader = null;
	private static double[][] data1 = new double[50][5];
	private static double[][] data2 = new double[50][5];
	private static double[][] data3 = new double[50][5];
	
	/* データの読み込み */
	public static void run(String fileName) throws IOException {
		reader = new BufferedReader(new FileReader(fileName));
		
		String read;
		int i = 0;
		double input = 0.0;
	    while ((read = reader.readLine()) != null && read.length() != 0) {
	        String[] splited = read.split(",");
	        for (String part : splited) {

	            if(part.equals("Iris-setosa"))
	            	part = "1";
	            else if(part.equals("Iris-versicolor"))
            		part = "2";
	            else if(part.equals("Iris-virginica"))
	            	part = "3";
	            else
	            	;
	            
	            input = Double.parseDouble(part);
	            loadToTable(input, i);
	            i++;

	            // System.out.println(input);
	        }
	    }
	    
		reader.close();
		
		/*
		 * 確認のために、クラスごとの表示
		 * 
		for(int a = 0; a<50; a++){
			for(int b = 0; b<5; b++){
				System.out.print(data1[a][b] + " ");
			}
			System.out.println();
		}
		for(int a = 0; a<50; a++){
			for(int b = 0; b<5; b++){
				System.out.print(data2[a][b] + " ");
			}
			System.out.println();
		}
		for(int a = 0; a<50; a++){
			for(int b = 0; b<5; b++){
				System.out.print(data3[a][b] + " ");
			}
			System.out.println();
		}
		//*/
	}
	
	/* 読み込んだデータを配列に入れる */
	public static void loadToTable(double inputData, int g) {
		
		int classDivider = g / 5;
		int row = (g / 5) % 50;
		int column = g % 5;
		
		if(classDivider < 50)
			data1[row][column] = inputData;
		else if(classDivider < 100)
			data2[row][column] = inputData;
		else
			data3[row][column] = inputData;
	}
	
	/*
	 * 新しいデータの学習用の配列を作る
	 * 行ごとに：
	 *  最初：　x0 (常に 1) を設定する
	 *  中間：　元のデータをコピーする
	 *  最後：　クラスを区別るために 1 か 0 を設定する
	 */
	public static double[][] makeNewDataTable(int okay) {
		
		double[][] rearrangedData = new double[100][6];
		int currentRow = 0;
		
		while(okay == 1 && currentRow < 100){
			// 前半のデータ
			if(currentRow < 50){
				for(double[] eachCharacteristic : data1) {
					for(int index = 0; index < eachCharacteristic.length - 1; index++)
						rearrangedData[currentRow][index + 1] = eachCharacteristic[index];

					rearrangedData[currentRow][0] = 1;
					rearrangedData[currentRow][eachCharacteristic.length] = 1;

					currentRow++;
				}
			}
			// 後半のデータ
			else{
				for(double[] eachCharacteristic : data2) {
					for(int index = 0; index < eachCharacteristic.length - 1; index++)
						rearrangedData[currentRow][index + 1] = eachCharacteristic[index];
					
					rearrangedData[currentRow][0] = 1;
					rearrangedData[currentRow][eachCharacteristic.length] = 0;

					currentRow++;
				}
			}
		}
		
		while(okay == 2 && currentRow < 100){
			if(currentRow < 50){
				for(double[] eachCharacteristic : data1) {
					for(int index = 0; index < eachCharacteristic.length - 1; index++)
						rearrangedData[currentRow][index + 1] = eachCharacteristic[index];

					rearrangedData[currentRow][0] = 1;
					rearrangedData[currentRow][eachCharacteristic.length] = 1;

					currentRow++;
				}
			}
			else{
				for(double[] eachCharacteristic : data3) {
					for(int index = 0; index < eachCharacteristic.length - 1; index++)
						rearrangedData[currentRow][index + 1] = eachCharacteristic[index];
					
					rearrangedData[currentRow][0] = 1;
					rearrangedData[currentRow][eachCharacteristic.length] = 0;

					currentRow++;
				}
			}
		}
		
		while(okay == 3 && currentRow < 100){
			if(currentRow < 50){
				for(double[] eachCharacteristic : data2) {
					for(int index = 0; index < eachCharacteristic.length - 1; index++)
						rearrangedData[currentRow][index + 1] = eachCharacteristic[index];

					rearrangedData[currentRow][0] = 1;
					rearrangedData[currentRow][eachCharacteristic.length] = 1;

					currentRow++;
				}
			}
			else{
				for(double[] eachCharacteristic : data3) {
					for(int index = 0; index < eachCharacteristic.length - 1; index++)
						rearrangedData[currentRow][index + 1] = eachCharacteristic[index];
					
					rearrangedData[currentRow][0] = 1;
					rearrangedData[currentRow][eachCharacteristic.length] = 0;

					currentRow++;
				}
			}
		}
		
		/*
		 * 確認のために、データの表示
		 * 
		System.out.println("\n*** New arranged data " + okay + " ***");
		for(int a = 0; a<100; a++){
			for(int b = 0; b<6; b++){
				System.out.print(rearrangedData[a][b] + " ");
			}
			System.out.println();
		}
		//*/
		
		return rearrangedData;
	}
	
}
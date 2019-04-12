import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// データを読み込む
		ReadInputData.run("bezdekIris.data");
		
		// 学習させたいデータの指定
		double[][] trainingData1 = ReadInputData.makeNewDataTable(1);
		double[][] trainingData2 = ReadInputData.makeNewDataTable(2);
		double[][] trainingData3 = ReadInputData.makeNewDataTable(3);

		Perceptron perceptron1 = new Perceptron(0.5, 10000, trainingData1);
		Perceptron perceptron2 = new Perceptron(0.5, 10000, trainingData2);
		Perceptron perceptron3 = new Perceptron(0.05, 10000, trainingData3);

		System.out.println("========================================");
		System.out.print("Setosa vs Versicolor:");
		perceptron1.train();
		perceptron1.getWeights();

		System.out.print("Setosa vs Virginica:");
		perceptron2.train();
		perceptron2.getWeights();

		System.out.print("Versicolor vs Virginica:");
		perceptron3.train();
		perceptron3.getWeights();
	}

}

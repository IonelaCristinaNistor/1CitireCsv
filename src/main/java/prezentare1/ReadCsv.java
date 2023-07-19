package prezentare1;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class ReadCsv {
    public static void main(String csv[]) {
        SparkSession sparkSession = SparkSession.builder().master("local").appName("Read_CSV").getOrCreate();

        Dataset<Row> dataset = sparkSession.read().option("header","true")
                .csv("C:\\Users\\nisto\\IdeaProjects\\untitled1\\src\\main\\resources\\Erasmus.csv");

        dataset.show(10);
    }
}

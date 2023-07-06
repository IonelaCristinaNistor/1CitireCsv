package incercare_inainte;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class ReadCsv {
    public static void main(String csv[]) {
        SparkSession sparkSession= SparkSession.builder().master("local").appName("Read_CSV").getOrCreate();

        //String filePath=ReadCsv.class.getResource("erasmus.csv").getPath(); de ce nu merge??

        Dataset<Row> dataset = sparkSession.sqlContext().read().format("com.databricks.spark.csv")
                .load("C:\\Users\\nisto\\IdeaProjects\\untitled1\\src\\main\\resources\\Erasmus.csv");

        dataset.show(5);
}
}

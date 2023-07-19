package tema2;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.col;

public class Tema2 {
    public static void main(String csv[]) {
        SparkSession sparkSession = SparkSession.builder().master("local").appName("Count_Students").getOrCreate();

        Dataset<Row> dataset = sparkSession.read().option("header", "true")
                .csv("C:\\Users\\nisto\\IdeaProjects\\untitled1\\src\\main\\resources\\Erasmus.csv");
        dataset.filter(col("Receiving Country Code").isin("LV", "MT", "RO"))
                .groupBy("Receiving Country Code", "Sending Country Code")
                .count().orderBy("Receiving Country Code", "Sending Country Code")
                .show(30, false);

        // varianta 1
        /*
         dataset.groupBy("Receiving Country Code","Sending Country Code")
                .count().sort("Receiving Country Code","Sending Country Code")
                .show(20,false);

         */
    }
}
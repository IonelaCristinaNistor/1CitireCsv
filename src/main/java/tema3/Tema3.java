package tema3;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.col;

public class Tema3 {
    public static void main(String[] csv) {
        SparkSession sparkSession = SparkSession.builder().master("local").appName("Count_Students").getOrCreate();

        Dataset<Row> dataset = sparkSession.read().option("header", "true")
                .csv("C:\\Users\\nisto\\IdeaProjects\\untitled1\\src\\main\\resources\\Erasmus.csv");
        saveData(dataset, "LV", "letonia");
        saveData(dataset, "MT", "malta");
        saveData(dataset, "RO", "romania");
    }

    public static void saveData(Dataset<Row> dataset, String countryCode, String tableName) {
        dataset
                .filter(col("Receiving Country Code").isin(countryCode))
                .groupBy("Receiving Country Code", "Sending Country Code")
                .count().orderBy("Receiving Country Code", "Sending Country Code")
                .write()
                .format("jdbc")
                .option("driver", "com.mysql.cj.jdbc.Driver")
                .option("url", "jdbc:mysql://localhost:3306/tema3?serverTimezone=UTC")
                .option("dbtable", tableName)
                .option("user", "root")
                .option("password", "root")
                .save(tableName + ".tema3");
    }
}
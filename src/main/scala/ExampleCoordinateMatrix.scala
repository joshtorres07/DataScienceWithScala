
import org.apache.hadoop.shaded.org.checkerframework.checker.units.qual.C
import org.apache.spark.mllib.linalg.{Matrices, Matrix}
//a simple rowMatrix
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix
import org.apache.spark.mllib.linalg.distributed.MatrixEntry
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.rdd.RDD
object ExampleCoordinateMatrix{
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("My Spark Application").setMaster("local[*]")
    val sc = new SparkContext(conf)

    //A simple IndexedRowMatrix
    val entries: RDD[MatrixEntry]  = sc.parallelize(Array(
      MatrixEntry(0,0,9.0),
      MatrixEntry(1,1,8.0),
      MatrixEntry(2,1,6.0)
      )
    )
    //in the next line code can be converted from IndexedRowMatrix
    val coordmat : CoordinateMatrix = new CoordinateMatrix(entries)
    val m = coordmat.numRows() // variable with the number of rows of our matrix
    val n = coordmat.numCols() // variable with the number of columns of our matrix
    println("Rows: ", m)
    println("Columns: ", n)

    sc.stop()
  }
}

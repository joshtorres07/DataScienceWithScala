
import org.apache.spark.mllib.linalg.{Matrices, Matrix}
//a simple rowMatrix
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.mllib.linalg.distributed.{IndexedRow,IndexedRowMatrix, RowMatrix}
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.rdd.RDD
object MatrixIndexed {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("My Spark Application").setMaster("local[*]")
    val sc = new SparkContext(conf)

    //A simple IndexedRowMatrix
    val rows: RDD[IndexedRow]  = sc.parallelize(Array(
      IndexedRow(0,Vectors.dense(1.0,2.0)),
      IndexedRow(1,Vectors.dense(1.0,2.0)),
      IndexedRow(2,Vectors.dense(1.0,2.0))
    )
    )
    //in the next line code can be converted from IndexedRowMatrix
    val idxmat : IndexedRowMatrix = new IndexedRowMatrix(rows)
    val m = idxmat.numRows() // variable with the number of rows of our matrix
    val n = idxmat.numCols() // variable with the number of columns of our matrix
    println("Rows: ", m)
    println("Columns: ", n)

    sc.stop()
  }
}

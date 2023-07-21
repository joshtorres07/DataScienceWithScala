
import org.apache.spark.mllib.linalg.{Matrices, Matrix}
//a simple rowMatrix
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.mllib.linalg.{Vector, Vectors}
object MAtrixExample {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("My Spark Application").setMaster("local[*]")
    val sc = new SparkContext(conf)

    //in the next var the parameters are: numRows, numColumns and the last is the number of elements
    var a = Matrices.dense(3, 2, Array(1, 2, 3, 4, 5, 6))
    println(a)
      //Note: the array is an array of integers and it returned a matrix of doubles
    val ar =  Matrices.sparse(5,4, Array(0,0,1,2,2), Array(1,3), Array(34,55))
    println(ar)

    //A simple RowMatrix
    val rows: RDD[Vector]  = sc.parallelize(Array(
      Vectors.dense(1.0,2.0),
      Vectors.dense(4.0,5.0),
      Vectors.dense(7.0,8.0)
      )
    )
    val mat: RowMatrix =  new RowMatrix(rows)
    val m = mat.numRows() // variable with the number of rows of our matrix
    val n = mat.numCols() // variable with the number of columns of our matrix
    println(n, " ", m)

    sc.stop()
  }
}

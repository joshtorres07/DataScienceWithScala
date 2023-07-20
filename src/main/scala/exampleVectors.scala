package scala
import org.apache.spark.mllib.linalg.{Vector, Vectors}
object exampleVectors {
  def main(args: Array[String]): Unit = {
    println("Helllo World")
    val vector  = Vectors.dense(44.0,0.0,55.00)
    println(vector)
    val  sumita  =  5+5
    println(sumita)
    val anotherVector =  Vectors.sparse(3,Array(0,2), Array(44,55))
    println(anotherVector)
  }
}

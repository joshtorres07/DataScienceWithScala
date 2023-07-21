package scala
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint


object exampleVectors {
  def main(args: Array[String]): Unit = {
    println("Helllo World")
    val vector  = Vectors.dense(44.0,0.0,55.00)
    println(vector)
    val  sumita  =  5+5
    println(sumita)
    val anotherVector =  Vectors.sparse(3,Array(0,2), Array(44,55))
    println(anotherVector)
    val lblpoint = LabeledPoint(1.0, Vectors.sparse(3, Array(0,2), Array(44.0,55.0)))
    println(lblpoint)
  }
}

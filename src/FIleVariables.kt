import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.util.*

object FIleVariables {
    val client= mutableMapOf<String, Client>()
    val path="clientInfo.txt"
    var systemscanner= Scanner(System.`in`)
    var filescanner= Scanner(File(path))
   // val file= File(path)
    var fileReader= FileReader(path)

    fun isClient(id:String):Boolean=if(client[id]!=null)true else false
    fun resetFileIOvars(){
        filescanner= Scanner(File(path))
        fileReader= FileReader(path)
    }
}
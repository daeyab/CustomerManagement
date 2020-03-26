import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.util.*

object FIleVariables {
    val client= mutableMapOf<String, Client>()
    val path="clientInfo.txt"
    var systemscanner= Scanner(System.`in`)
    var filescanner= Scanner(File(path))
   // val file= File(path)
 //   var fileReader= FileReader(path)

    fun isClient(id:String):Boolean=if(client[id]!=null)true else false

    fun resetFileIOvars()={filescanner= Scanner(File(path))}

    fun syncMapAndTxt(){
        resetFileIOvars()
        var txt:String=""
        for(c in client)
            txt+=c.value.id+" "+c.value.pw+" "+c.value.name+" "+c.value.tel+" "+c.value.point+"\n"

        try {
            FileWriter(path,false).use { it.write(txt) }
            //FileWriter(경로, 추가여부).
        }
        catch (e: IOException) {}
    }

    fun readNumber(): Int? {
        try {
            val line = systemscanner.next()
            return Integer.parseInt(line)
        }
        catch (e: NumberFormatException) {
            println("잘못된 입력입니다.")
            return null
        }
    }
}
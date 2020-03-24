import java.io.File
import java.util.*

open class ClientManager():ClientManagerMethods() {
    //저장구조

    init {
        while(filescanner.hasNext()){
            val str=filescanner.nextLine()
            val line=str.split(" ") //공백을 기준으로 분리
            println(line)
            //data class Client(val id:String,val pw:String,val nickname:String, val name:String, val tel:String, var point:Int) {
            client[line[0]]=Client(line[0],line[1],line[2],line[3],line[4].toInt())
        }
    }

}
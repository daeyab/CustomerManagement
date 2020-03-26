import FIleVariables.client
import FIleVariables.filescanner
import FIleVariables.path
import FIleVariables.resetFileIOvars
import FIleVariables.syncMapAndTxt
import FIleVariables.systemscanner
import java.io.FileWriter
import java.io.IOException

class DeleteClient {
    init {
        println("[ 계정 삭제 ]")
    }
    lateinit var id:String
    lateinit var pw:String
    lateinit var c:Client
    fun checkUser():Boolean{
        print("* ID를 입력하세요 : ")
        id=systemscanner.next()
        if(!FIleVariables.isClient(id)){
            println("해당 ID는 존재하지 않습니다")
            return false
        }
        print("* 비밀번호를 입력하세요 : ")
        pw=systemscanner.next()
        if(!client[id]!!.pw.equals(pw)){
            println("비밀번호가 일치하지 않습니다")
            return false
        }
        return true
    }
    fun deleteAndSync(){
        c=client[id]!!
        var ch="c"
        while(ch!="y" && ch!="n"){
            print("* 정말 계정을 삭제 하시겠습니까? [삭제:y] [취소:n] : ")
            ch = systemscanner.next() //ch 한글자 읽기
        }
        when(ch) {
            "y" -> {
                println("* 삭제가 정상적으로 성공하였습니다.")
                client.remove(id)
                syncMapAndTxt()
            }
            "n"->{ println("* 삭제가 정상적으로 취소되었습니다.") }
        }
    }
}
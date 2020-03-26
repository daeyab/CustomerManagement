import FIleVariables.client
import FIleVariables.filescanner
import FIleVariables.path
import FIleVariables.resetFileIOvars
import FIleVariables.systemscanner
import java.io.File
import java.util.*

class PrintClients() {
    init {
        if(checkAdmin())
            PrintAllInfo()
        else
            println("* 관리자 비밀번호가 일치하지 않습니다. ")
    }

    fun checkAdmin():Boolean{
        print("* 관리자 권한이 필요합니다.\n* 관리자 비밀번호 : ")
        val pw= systemscanner.next()
        if (pw=="admin")
            return true
        else
            return false
    }
    fun PrintAllInfo(){
        println("[ 계정 목록 ]")
        println("ID\t\t비밀번호\t\t이름\t\t연락처\t\t\t\t점수")
        for( c in client)
            println(c.value.id+"\t\t"+c.value.pw+"\t\t"+c.value.name+"\t\t"+c.value.tel+"\t\t\t"+c.value.point)
    }
}

import FIleVariables.client
import FIleVariables.filescanner
import FIleVariables.isClient
import FIleVariables.path
import FIleVariables.readNumber
import FIleVariables.resetFileIOvars
import FIleVariables.systemscanner
import java.awt.SystemColor.info
import java.io.*
import java.nio.file.*
import java.util.*

class ClientManager {

    init {
        while(filescanner.hasNext()){
            val str=filescanner.nextLine()
            val line=str.split(" ") //공백을 기준으로 분리
            //data class Client(val id:String,val pw:String,val nickname:String, val name:String, val tel:String, var point:Int) {
            client[line[0]]=Client(line[0],line[1],line[2],line[3],line[4].toInt())
         //   println("???"+client)
        }

    }

    fun searchClient() {
        val s=SearchClient()
        print(" * 메뉴를 선택해주세요. (검색 수단 :1.ID 2.이름 3.연락처) :")
        val menu = readNumber()
        when (menu) {
            1 -> s.searchByID()
            2 -> s.searchByName()
            3-> s.searchByTel()
        }
    }


    fun addClient(){
        println("[ ID 추가 ]")
        val add=AddClient()
        add.getClientID()
        add.getClientPW()
        add.getClientName()
        add.getClientTel()
        add.addAndSync()
    }

    fun editClient(){
        println("[ 고객 변경 ]")
        val edit=EditClient()
        if(edit.checkUser()){
            edit.pickMenu()
            edit.editAndSync()
        }
    }
    fun deleteClient(){
        val delete=DeleteClient()
        if(delete.checkUser())
            delete.deleteAndSync()

    }

    fun showRank(){
        PointManager().SortClientsByPoints()
    }

    fun givePoints(){
        val p=PointManager()
        if(p.checkAdmin())
           p.givePoints()
        else
            println("* 관리자 비밀번호가 일치하지 않습니다. ")
    }

    fun printClients(){
        PrintClients()
    }

}
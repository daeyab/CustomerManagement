import FIleVariables.client
import FIleVariables.fileReader
import FIleVariables.filescanner
import FIleVariables.isClient
import FIleVariables.path
import FIleVariables.resetFileIOvars
import FIleVariables.systemscanner
import java.awt.SystemColor.info
import java.io.*
import java.nio.file.*
import java.util.*

open class ClientManager {

    init {
        while(filescanner.hasNext()){
            val str=filescanner.nextLine()
            val line=str.split(" ") //공백을 기준으로 분리
            println(line)
            //data class Client(val id:String,val pw:String,val nickname:String, val name:String, val tel:String, var point:Int) {
            client[line[0]]=Client(line[0],line[1],line[2],line[3],line[4].toInt())
         //   println("???"+client)
        }
    }
    fun printInfo(id:String){
        println("["+id+"] 님에 대한 정보입니다.")
        println("이름 : "+client[id]!!.name)
        println("번호 : "+client[id]!!.tel)
        println("점수 : "+client[id]!!.point)
    }

    fun searchClient()
    {
        println("[ 고객 검색 ]")
        print("*ID를 입력하세요 : ")
        val id=systemscanner.next()
        if(isClient(id))
            printInfo(id)
        else
            println("존재하지 않는 ID 입니다.")
    }

    fun getClient(id:String)=client[id]


    fun addClient(){
        println("[ ID 추가 ]")
        val add=AddClient()
        add.getClientID()
        add.getClientPW()
        add.getClientName()
        add.getClientTel()
        add.writeInTxtAndMap()
    }

    fun editClient(){
        val edit=EditClient()
        if(edit.checkUser()){
            edit.pickMenu()
            edit.writeInTxt()
        }
    }
    fun deleteClient(){

    }

    fun showRank(){

    }

    fun givePoints(){
        filescanner
    }

    fun printClient(){
        PrintClient()
    }

}
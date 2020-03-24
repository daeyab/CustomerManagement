import java.awt.SystemColor.info
import java.io.File
import java.io.IOException
import java.io.PrintWriter
import java.nio.file.*
import java.util.*

open class ClientManagerMethods {

    val client= mutableMapOf<String, Client>()

    val path="clientInfo.txt"
    val systemscanner= Scanner(System.`in`)
    val filescanner= Scanner(File(path))
    val file=File(path)

    fun isClient(id:String):Boolean=if(client[id]==null) false else true
    fun getPoint(c:Client)=c.point

    fun printInfo(id:String){
        println("["+id+"] 님에 대한 정보입니다.")
        println("이름 : "+client[id]!!.name)
        println("번호 : "+client[id]!!.tel)
        println("점수 : "+client[id]!!.point)
    }

    fun searchClient(){
        println("[ 고객 검색 ]")
        print("*ID를 입력하세요 : ")
        val id=systemscanner.next()
        if(isClient(id))
            printInfo(id)
        else
            println("존재하지 않는 ID 입니다.")
    }

    fun addClient(){
        println("[ ID 추가 ]")
        print("* ID를 입력하세요 : ")
        
        val id=systemscanner.next()
        var pw:String?=null

        if(isClient(id)){
            println("* 해당 ID가 존재 합니다.")
            return
        }
        while(true){
            print("* 비밀번호를 입력하세요 : ")
            pw=systemscanner.next()
            print("* 비밀번호를 중복 입력하세요 : ")
            val pwcheck=systemscanner.next()
            if(pw.equals(pwcheck)) break;
            else println("비밀번호가 일치하지 않습니다.")
        }
        print("* 이름을 입력하세요 : ")
        var name:String=""
        while(name!!.length==0 || name!!.length>20)
            name=systemscanner.next()

        var tel:String?=null
       tel@ while (true){
            print("* 번호를 입력하세요 (ex. xxx-xxxx-xxxx) *없으면 no를 입력하세요* : ")
            tel=systemscanner.next()
           if(tel.equals("no")){
               tel="NOPHONE"
               break;
           }
           if(tel.length!=13 ){
               println("다시 입력하여 주시기 바랍니다. 길이 13자")
                continue
            }
               if(tel[3]=='-' && tel[8]=='-'){
                for(i in 0..tel.length){
                    if(i==3 || i==8)
                        continue
                    if('0'>tel[i] || '9'<tel[i]){
                        println("다시 입력하여 주시기 바랍니다. (ex. xxx-xxxx-xxxx)")
                        break;
                    }

                    if(i==12)
                        break@tel
                }
            }

        }
        val point:Int=0
        val txtInfo=id+" "+pw+" "+name+" "+tel+" "+point+"\n"
//        File(path).printWriter().use { it.println(info) } 이거 다 삭제해줌
       try {
           Files.write(Paths.get(path),txtInfo.toByteArray(),StandardOpenOption.APPEND)
       }
       catch (e:IOException){}

        client[id]=Client(id,pw!!,name,tel!!,point)

    }

    fun editClient(){

    }
    fun deleteClient(){

    }

    fun showRank(){

    }

    fun givePoints(){

    }

}
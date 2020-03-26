import FIleVariables.client
import FIleVariables.filescanner
import FIleVariables.path
import FIleVariables.resetFileIOvars
import FIleVariables.syncMapAndTxt
import FIleVariables.systemscanner
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.*

class EditClient() {
    init {
    }

    lateinit var id:String
    lateinit var pw:String
    var menu:Int=0
    lateinit var after:String
    lateinit var c:Client
    lateinit var tochange:String

    fun checkUser():Boolean{
        print("* ID를 입력하세요 : ")
        id=systemscanner.next()
        if(!FIleVariables.isClient(id)){
            println("해당 ID는 존재하지 않습니다")
            return false
        }
        print("*비밀번호를 입력하세요 : ")
        pw=systemscanner.next()
        if(!client[id]!!.pw.equals(pw)){
            println("비밀번호가 일치하지 않습니다")
            return false
        }
        return true
    }
    fun pickMenu(){
        while(true){
            print("* 수정하고 싶은 항목을 선택하세요 [1.비밀번호  2.이름  3.연락처]: ")
            menu=systemscanner.nextInt()
            if(menu>=1 && menu<=3)
                break;
        }
        c= client[id]!!

        val a=AddClient()

         when(menu){
            1->{
                val before=c!!.pw
                after=a.getClientPW()
                println("* 비밀번호가  "+before+"에서 "+after+"로 변경 되었습니다.")
                client[id]!!.pw=after
            }
            2->{
                val before=c!!.name
                after=a.getClientName()
                println("* 이름이  "+before+"에서 "+after+"로 변경 되었습니다.")
                client[id]!!.name=after
            }
            3->{
                val before=c!!.tel
                after=a.getClientTel()
                println("* 전화번호가  "+before+"에서 "+after+"로 변경 되었습니다.")
                client[id]!!.tel=after
            }
            else-> ""
        }
    }

    fun editAndSync(){
        when(menu){
            1-> {client[id]!!.pw=after}
            2->{client[id]!!.name=after}
            3->{client[id]!!.tel=after}
        }
        syncMapAndTxt()
    }

}
import FIleVariables.client
import FIleVariables.isClient
import FIleVariables.path
import FIleVariables.resetFileIOvars
import FIleVariables.syncMapAndTxt
import FIleVariables.systemscanner
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.*

class AddClient() {

    init {}

    lateinit var id:String
    lateinit var pw:String
    var name:String=""
    lateinit var tel:String
    val point:Int=0


    fun getClientID(){
        while(true){
            print("* ID를 입력하세요 (4~15자): ")
            id = systemscanner.next()
            if(id.length<4 || id.length>15){
                println("길이가 부적합합니다. (4~15자) ")
                return;
            }

            if(!isClient(id))
                break
            println("해당 ID가 존재 합니다.")

        }
    }
    fun getClientPW():String{
        while(true)
        {
            print("* 비밀번호를 입력하세요 (4~15자) : ")
           pw = systemscanner.next()
            print("* 비밀번호를 중복 입력하세요 (4~15자) : ")
            val pwcheck = systemscanner.next()
            if (pw.equals(pwcheck) && pw.length>=4 && pw.length<=15)
                break
            else println("비밀번호가 일치하지 않습니다.")
        }
        return pw
    }
    fun getClientName():String {
        while (name!!.length < 4 || name!!.length > 20) {
            print("* 이름을 입력하세요 (4~20자) : ")
            name = systemscanner.next()
        }
        return name
    }
    fun getClientTel():String{
        tel@ while (true)
        {
            print("* 번호를 입력하세요 (ex. xxx-xxxx-xxxx) [없으면 no를 입력하세요] : ")

            tel = systemscanner.next()
            if (tel.equals("no")) {
                tel = "NO_PHONENUMBER"
                break;
            }
            if (tel.length != 13) {
                println("다시 입력하여 주시기 바랍니다. 길이 13자")
                continue
            }
            if (tel[3] == '-' && tel[8] == '-') {
                for (i in 0..tel.length) {
                    if (i == 3 || i == 8)
                        continue
                    if ('0' > tel[i] || '9' < tel[i]) {
                        println("다시 입력하여 주시기 바랍니다. (ex. xxx-xxxx-xxxx)")
                        break;
                    }

                    if (i == 12)
                        break@tel
                }
            }

        }
        return tel
    }
    fun addAndSync(){
        client[id]=Client(id,pw!!,name,tel!!,point)
        println("* 계정이 정상적으로 추가되었습니다.")
        //추가하는 과정
        syncMapAndTxt()
    }

}

import FIleVariables.client
import FIleVariables.isClient
import FIleVariables.systemscanner

class SearchClient {
    init{
        println("[ 계정 검색 ]")
       }

    fun searchByID() {
        print("*ID를 입력하세요 : ")
        val id = systemscanner.next()

        if (isClient(id)) {
            printInfo(id)
        }
        else
            println("존재하지 않는 ID입니다.")
    }

        fun searchByName() {
            print("* 이름을 입력하세요 : ")
            val name = systemscanner.next()
            var userExists=false
            for (c in client) {
                if (c.value.name == name){
                    printInfo(c.value.id)
                    userExists=true
                }
            }
            if(userExists==false)
                println("존재하지 않는 이름입니다.")
        }


    fun searchByTel() {
        print("* 연락처를 입력하세요 : ")
        val tel = AddClient().getClientTel()
        var userExists=false
        for (c in client) {
            if (c.value.tel == tel && (tel!="NO_PHONENUMBER")){
                printInfo(c.value.id)
                userExists=true
            }
        }
        if(userExists==false)
            println("존재하지 않는 연락처입니다.")
    }

    fun printInfo(id:String)= println("""
            ----------------------------------
            ["$id"] 님에 대한 정보입니다.
            이름 : ${client[id]!!.name}
            번호 : ${client[id]!!.tel}
            점수 : ${client[id]!!.point}
            ----------------------------------
        """.trimIndent())

}
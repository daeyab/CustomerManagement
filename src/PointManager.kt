import FIleVariables.client
import FIleVariables.readNumber
import FIleVariables.syncMapAndTxt
import FIleVariables.systemscanner

class PointManager(var c:Client?=null) {
     fun givePoints(){
         println("[ 점수 추가 ]")
         print("* ID를 입력하세요 : ")
         val id=systemscanner.next()
         if(!FIleVariables.isClient(id)){
             println("$id 해당 ID는 존재하지 않습니다")
             return
         }
         print("* 부여할 점수를 입력하세요 : ")

         val score= readNumber()
         if(score is Int){
             client[id]!!.point+=score
             println("* $id 님에게 $score 점수를 부여하였습니다. (현재 점수:${client[id]!!.point})")

         }
         else{
             println("* 잘못된 입력입니다.")
         }
         syncMapAndTxt()
     }

    fun checkAdmin():Boolean{
        print("* 관리자 권한이 필요합니다.\n* 관리자 비밀번호 : ")
        val pw= systemscanner.next()
        if (pw=="admin")
            return true
        else
            return false
    }

    fun SortClientsByPoints(){
        println("[ 점수 순위 ]")
        val list= client.toList().sortedWith(compareByDescending({it.second.point})).toMap()
        println("순번\t\tID\t\t이름\t\t연락처\t\t\t\t점수")
        var idx=1
        for( c in list)
            println(idx++.toString()+"\t\t"+c.value.id+"\t\t"+c.value.name+"\t\t"+c.value.tel+"\t\t\t"+c.value.point)
    }
}
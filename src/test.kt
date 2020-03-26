import FIleVariables.client
import FIleVariables.readNumber
import java.util.*

fun main(){

    val clientmanager=ClientManager()
    var menu:Int?=null

    while(menu!=0){
        println("\n\n\n" +
                "---------------------------------------------------------------------------------------------\n" +
                "1.[계정 검색]             2.[계정 추가]             3.[계정 변경]             4.[계정 삭제]\n" +
                "5.[점수 순위]             6.[점수 부여]             7.[계정 목록]             0.[종료]\n" +
                "---------------------------------------------------------------------------------------------")
        print("* 메뉴를 선택해주세요 : ")
        menu=readNumber()
        when(menu){
            1->{clientmanager.searchClient()}
            2->{clientmanager.addClient()}
            3->{clientmanager.editClient()}
            4->{clientmanager.deleteClient()}
            5->{clientmanager.showRank()}
            6->{clientmanager.givePoints()}
            7->{clientmanager.printClients()}
            else ->{ println("다시 입력하여 주시기 바랍니다")}
        }
    }
}

    /*
   기능 추가
   - 별도 -
       1) 비밀번호 기능 부여 ok

   - 추가 -
       1) 계정 추가
       2) 비밀번호 일치 확인
       3) 아이디와 닉네임 중복 불가

   - 삭제 -
       1) 아이디와 비밀번호를 입력하면 삭제 기능
           - 아이디&비밀번호가 모두 일치하면 'y' 버튼을 눌러서 삭제시키기

   - 검색 -
       1) 아이디 검색 기능
               1개다? -> 공개
               여러개다? -> 전원 공개
               계속 추가적으로 검색할 수 있는지 확인
       2) 포인트에 따라 내림차순 검색

   - 수정 -
       1) ID 와 PW 일치하면 변경하고 싶은 거 변경
       2) 점수 변경하기 n점씩 올릴 수 있는지 입력
    */

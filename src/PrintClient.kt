import FIleVariables.filescanner
import FIleVariables.path
import FIleVariables.resetFileIOvars
import java.io.File
import java.util.*

class PrintClient() {
    init {
        resetFileIOvars()
        filescanner = Scanner(File(path))
        println(filescanner.hasNext())
        //   println(filescanner)
        while (filescanner.hasNext()) {
            val str = filescanner.nextLine()
            val line = str.split(" ") //공백을 기준으로 분리
            println(line)
        }
    }
}
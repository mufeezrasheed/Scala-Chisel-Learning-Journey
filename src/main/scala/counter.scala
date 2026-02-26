import chisel3._

class counter (counterbit :UInt) extends Module {
    val io = IO(new Bundle{
        val pin=Output(Bool())
    
    
    })
val max = (1.U << counterbit) -1.U
val count = RegInit (0. U (16. W ) )
when ( count === max ) {
    count := 0. U
} .otherwise {
    count := count + 1. U
}
io.pin:=count(3)
println ( s" counter created with max value $max " )
}
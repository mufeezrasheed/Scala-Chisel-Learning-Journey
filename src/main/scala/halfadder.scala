import chisel3._
class halfadder extends Module {
    val io = IO(new Bundle{
        val a = Input(Bool())
        val b = Input(Bool())
        val s = Output(Bool())

    })
io.s:=io.a^io.b
}
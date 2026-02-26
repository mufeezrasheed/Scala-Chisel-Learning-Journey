import chisel3._
class Fulladder extends Module {
    val io = IO(new Bundle{
        val a = Input(Bool())
        val b = Input(Bool())
        val cin = Input(Bool())
        val p = Output(Bool())
        val g = Output(Bool())
        val cout = Output(Bool())
        val s = Output(Bool())

    })
    io.g := io.a & io.b
    io.p := io.a ^ io.b
    io.s := io.p ^ io.cin
    io.cout:= io.g | (io.p & io.cin)
}
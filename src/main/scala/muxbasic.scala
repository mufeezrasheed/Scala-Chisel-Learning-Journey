import chisel3 . _
// Mux IO interface class
class muxbasic_IO extends Bundle {
val in_A= Input ( UInt (32. W ) )
val in_B= Input ( UInt (32. W ) )
val select = Input ( Bool () )
val out= Output ( UInt () )
}
// 2 to 1 Mux implementation
class muxbasic extends Module {
val io = IO ( new muxbasic_IO )
// update the output
io . out := Mux ( io . select , io . in_A , io . in_B )
}
// println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new muxbasic () ) )
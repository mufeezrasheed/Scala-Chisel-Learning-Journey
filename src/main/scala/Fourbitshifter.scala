// import chisel3 . _
// class LM_IO_Interface extends Bundle {
// val in = Input ( UInt (4.W))
// val sel = Input ( UInt(2.W) )
// val out = Output ( UInt(4.W) )
// val shift=Input(Bool())
// // UInt (1. W ) )
// }
// class Fourbitshifter extends Module {
// val io = IO ( new LM_IO_Interface )
// val Mux4_to_1_a = Mux ( io . sel(1) , Mux ( io . sel(0) , io . in (3) , io . in (2) ) ,
// Mux ( io . sel(0) , io . in (1) , io . in (0) ) )
// val Mux4_to_1_b = Mux ( io . s1 , Mux ( io . s0 , Mux2_to_1a , io . in (3) ) ,
// Mux ( io . s0 , io . in (2) , io . in (1) ) )
// val Mux2_to_1a = Mux ( io . shift, io. in(0), false.B)
// val Mux4_to_1_c = Mux ( io . sel(1) , Mux ( io . sel(0) , Mux2_to_1c ,Mux2_to_1b ) ,
// Mux ( io . sel(0) , io . in (3) , io . in (2) ) )
// val Mux2_to_1b = Mux( io . shift, io. in(0), false.B)
// val Mux2_to_1c = Mux( io . shift, io. in(1), false.B)
// val Mux4_to_1_d = Mux ( io . sel(1) , Mux ( io . sel(0) , Mux2_to_1f , Mux2_to_1e ) ,
// Mux ( io . sel(0) , Mux2_to_1d , io . in (3) ) )
// val Mux2_to_1d = Mux( io . shift, io. in(0), false.B)
// val Mux2_to_1e = Mux( io . shift, io. in(1), false.B)
// val Mux2_to_1f = Mux( io . shift, io. in(2), false.B)

// Connecting output of 2 _to_1 Mux with the output port .
// io . out := Mux2_to_1
// }
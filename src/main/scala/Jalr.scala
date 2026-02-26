import chisel3 . _
import chisel3 . util . _
class JalrIO extends Bundle {
val inA = Input ( SInt (32.W) )
val inB = Input ( SInt (32.W) )
val sum_add = Output ( SInt (32.W) )
val Address = Output ( SInt (32.W) )

}
class Jalr extends Module{
   val io = IO ( new JalrIO )
   val mask = 0xfffffffe.S(32.W)
   io.sum_add:=io.inA + io.inB
   io.Address:=io.sum_add & mask
}

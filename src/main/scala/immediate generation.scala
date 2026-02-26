import chisel3 . _
import chisel3.util._

class imm_genIO extends Bundle {
val inst = Input ( UInt (32.W))
val out5 = Output ( SInt(32.W) )
val out1 = Output ( SInt(32.W) )
val out2 = Output ( SInt(32.W) )
val out3 = Output ( SInt(32.W) )
val out4 = Output ( SInt(32.W) )
val PC = Input (UInt(32.W))



}

class imm_gen extends Module{
    val io = IO ( new imm_genIO )
     val i_type = io.inst(31,20)
 val s_type=Cat(io.inst(31,25),io.inst(11,7))
 val u_type=io.inst(31,12)
 val sb_type=Cat(io.inst(31),io.inst(7),io.inst(30,25),io.inst(11,8),0.U) + io.PC
val uj_type=Cat(io.inst(31),io.inst(19,12),io.inst(20),io.inst(30,21),(0.U)) + io.PC
io.out1:=i_type.asSInt
io.out2:=s_type.asSInt
io.out3:=u_type.asSInt
io.out4:=sb_type.asSInt
io.out5:=uj_type.asSInt
}


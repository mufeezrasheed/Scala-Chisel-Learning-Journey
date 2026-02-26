import chisel3 . _
import chisel3 . util . _
class RegisterIO extends Bundle {
    // val Reg32=Reg(Vec(32, SInt (32.W)))
    val rs1add=Input(UInt(5.W))
    val rs2add=Input(UInt(5.W))
    val rdadd=Input(UInt(5.W))
    val rddata=Input(SInt(32.W))
    val Regwrite=Input(Bool())
    val rs1data=Output(SInt(32.W))
    val rs2data=Output(SInt(32.W))

}
class register extends Module{
    val io =IO(new RegisterIO)
    val Reg32= Reg(Vec(32 ,(SInt (32.W))))
    // val io.rs1add:=0.U
    // val io.rs2add:=0.U
    // val io.rdadd:=0.U
    // val io.rddata:=0.U
    // val io.Regwrite:=false.B

    io.rs1data:=Reg32(io.rs1add)
    io.rs2data:=Reg32(io.rs2add)
     Reg32(0):=0.S

    when(io.Regwrite===true.B){
        when(io.rdadd===0.U){Reg32(0):=0.S}
        .otherwise{Reg32(io.rdadd):=io.rddata}
    }
    // .otherwise{Reg32(io.rdadd):=0.U}
    

}

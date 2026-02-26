import chisel3 . _
import chisel3 . util . _
class ControlIO extends Bundle {
val opcode = Input ( UInt (7.W) )
val rtype= Output(Bool())
val load= Output(Bool())
val store= Output(Bool())
val branch= Output(Bool())
val i_type= Output(Bool())
val jalr= Output(Bool())
val jal= Output(Bool())
val lui= Output(Bool())
}

class controldecode extends Module{
   val io = IO ( new ControlIO )
   io.rtype:=false.B
   io.load:=false.B
   io.store:=false.B
   io.branch:=false.B
   io.i_type:=false.B
   io.jalr:=false.B
   io.jal:=false.B
   io.lui:=false.B
    when(io.opcode==="h33".U){
      io.rtype:=true.B}
    .elsewhen(io.opcode==="h03".U){
        io.load:=true.B
    }
    .elsewhen(io.opcode==="h23".U){
        io.store:=true.B}
    .elsewhen(io.opcode==="h63".U){    
        io.branch:=true.B}
    .elsewhen(io.opcode==="h13".U){
        io.i_type:=true.B}
    .elsewhen(io.opcode==="h67".U){     
        io.jalr:=true.B}
    .elsewhen(io.opcode==="h6f".U){ 
        io.jal:=true.B}
    .elsewhen(io.opcode==="h37".U){  
        io.lui:=true.B}




    
    
    

// io.lui := DontCare

}


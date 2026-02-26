import chisel3 . _
import chisel3 . util . _
class maincontrolIO extends Bundle {
val rtype= Input(Bool())
val load= Input(Bool())
val store= Input(Bool())
val branch= Input(Bool())
val i_type= Input(Bool())
val jalr= Input(Bool())
val jal= Input(Bool())
val lui= Input(Bool())
val Memwrite= Output(Bool())
val Branch= Output(Bool())
val Memread= Output(Bool())
val Regwrite= Output(Bool())
val MemtoReg= Output(Bool())
val Aluoperation= Output(UInt(3.W))
val OperandAsel= Output(UInt(2.W))
val OperandBsel= Output(Bool())
val Extendsel= Output(UInt(2.W))
val Nextpcsel= Output(UInt(2.W))

}
class maincontrol extends Module{
   val io = IO ( new maincontrolIO )
   io.Memwrite:=false.B
   io.Branch:=false.B
   io.Memread:=false.B
   io.Regwrite:=false.B
   io.MemtoReg:=false.B
   io.Aluoperation:="b000".U
   io.OperandAsel:=false.B
   io.OperandBsel:=false.B
   io.Extendsel:="b00".U
   io.Nextpcsel:="b00".U

   when(io.rtype===true.B){
    io.Regwrite:=true.B
    io.Aluoperation:="b000".U
   }
   .elsewhen(io.load===true.B){
    io.Memread:=true.B
    io.Regwrite:=true.B
    io.MemtoReg:=true.B
    io.Aluoperation:="b100".U
   }
   .elsewhen(io.store===true.B){
    io.Memwrite:=true.B
    io.OperandBsel:=true.B   
    io.Extendsel:="b10".U
    io.Aluoperation:="b101".U
   }
    .elsewhen(io.branch===true.B){
        io.Branch:=true.B
        io.Aluoperation:="b010".U
        io.Nextpcsel:="b01".U
    }
    .elsewhen(io.i_type===true.B){
        io.Regwrite:=true.B
        io.OperandBsel:=true.B
        io.Aluoperation:="b001".U
    }
    .elsewhen(io.jalr===true.B){
        io.Regwrite:=true.B
        io.OperandAsel:="b10".U
        io.Aluoperation:="b011".U
        io.Nextpcsel:="b11".U

    }
    .elsewhen(io.jal===true.B){
        io.Regwrite:=true.B
        io.Aluoperation:="b011".U
        io.Nextpcsel:="b10".U
        io.OperandAsel:="b10".U
    }
    .elsewhen(io.lui===true.B){
        io.Regwrite:=true.B
        io.OperandBsel:=true.B
        io.Aluoperation:="b110".U
        io.OperandAsel:="b11".U
        io.Extendsel:="b01".U
    }


    
   }

   






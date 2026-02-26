
import chisel3._
import chisel3.util._


class Top extends Module {
  val io = IO (new Bundle {
  })
	val Alu = Module(new Alu())
	val Control = Module(new Control())
	val ImmediateGeneration = Module(new imm_gen())
	val AluControl = Module(new alucontrol())
	val Register = Module(new register())
	val Memory = Module(new instmemory())
	val Pc = Module(new Pc())
	val Jalr = Module(new Jalr())
	val DataMemory = Module(new Memory())

//PC to memory and immediate generation
Memory.io.wrAddr:=Pc.io.pc(11,2)
ImmediateGeneration.io.inst:=Memory.io.rdData
ImmediateGeneration.io.PC:=Pc.io.pc

//Register connections
Control.io.opcode:=Memory.io.rdData(6,0)
Register.io.rs1add:=Memory.io.rdData(19,15)
Register.io.rs2add:=Memory.io.rdData(24,20)    
Register.io.rdadd:=Memory.io.rdData(11,7)
Register.io.Regwrite:=Control.io.Regwrite

//immediate mux
val immgen_wire = Wire(SInt(32.W))
when (Control.io.Extendsel==="b00".U){
	immgen_wire:=ImmediateGeneration.io.out1
}
.elsewhen(Control.io.Extendsel==="b01".U){
	immgen_wire:=ImmediateGeneration.io.out2
}
.elsewhen(Control.io.Extendsel==="b10".U){
	immgen_wire:=ImmediateGeneration.io.out3	

}
.otherwise{immgen_wire:=(0.S)}

//alu input 2
 val muxB = Wire(SInt(32.W))
 when(Control.io.OperandBsel===false.B){
	muxB:= Register.io.rs2data
 }
.elsewhen(Control.io.OperandBsel===true.B){
	muxB:= immgen_wire
}
.otherwise{muxB:=0.S}

//alu input 1
val muxA = Wire(SInt(32.W))
when(Control.io.OperandAsel==="b00".U | Control.io.OperandAsel==="b11".U){
	muxA:= Register.io.rs1data
}
.elsewhen(Control.io.OperandAsel==="b01".U){
	muxA:= Pc.io.pc.asSInt
}

.elsewhen(Control.io.OperandAsel==="b10".U){
	muxA:=Pc.io.pc4.asSInt
}
.otherwise{muxA:=0.S}

//alu control
AluControl.io.funct3:=Memory.io.rdData(14,12)
AluControl.io.funct7:=Memory.io.rdData(30)
AluControl.io.aluOp:=Control.io.Aluoperation
Alu.io.AluControl:= AluControl.io.out

//alu
Alu.io.in1:=muxA
Alu.io.in2:=muxB

//datamemory
DataMemory.io.Address:=Alu.io.out(9,2)
DataMemory.io.Datain:=Register.io.rs2data
DataMemory.io.Store:=Control.io.Memwrite
DataMemory.io.Load:=Control.io.Memread


//regwrite mux
when(Control.io.MemtoReg===true.B){
	Register.io.rddata:=DataMemory.io.Dataout
}
.otherwise{
	Register.io.rddata:=Alu.io.out

}
//and gate for branch
val branchgate = Wire(Bool())
branchgate := Control.io.Branch & Alu.io.Branch

//mux for branch
val branchmux = Wire(SInt(32.W))
when(branchgate===true.B){
	branchmux:=ImmediateGeneration.io.out4
}
.elsewhen(branchgate===false.B){
	branchmux:=Pc.io.pc4.asSInt
}
.otherwise{branchmux:=0.S}


Jalr.io.inA:=Register.io.rs1data
Jalr.io.inB:=immgen_wire

//jalr mux
val jalrmux = Wire(SInt(32.W))
when(Control.io.Nextpcsel===0.U){
	jalrmux:=Pc.io.pc4.asSInt
}
.elsewhen(Control.io.Nextpcsel===1.U){
	jalrmux:=branchmux
}
.elsewhen(Control.io.Nextpcsel===2.U){
	jalrmux:=ImmediateGeneration.io.out5
}
.elsewhen(Control.io.Nextpcsel===3.U){
	jalrmux:=Jalr.io.Address
}
.otherwise{jalrmux:=0.S}

Pc.io.input:=jalrmux.asUInt

}
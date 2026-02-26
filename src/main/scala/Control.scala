import chisel3 . _
import chisel3 . util . _


class Control_IO extends Bundle {
    val opcode = Input ( UInt (7.W) )

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

class Control extends Module{
    val io = IO ( new Control_IO )
    
    val typeDecode = Module(new controldecode())
    val instDecode = Module(new maincontrol())

    typeDecode.io.opcode := io.opcode

    instDecode.io.rtype := typeDecode.io.rtype
    instDecode.io.load := typeDecode.io.load
    instDecode.io.store := typeDecode.io.store
    instDecode.io.branch := typeDecode.io.branch
    instDecode.io.i_type := typeDecode.io.i_type
    instDecode.io.jalr := typeDecode.io.jalr
    instDecode.io.jal := typeDecode.io.jal
    instDecode.io.lui := typeDecode.io.lui

    
    io.Memwrite := instDecode.io.Memwrite
    io.Branch := instDecode.io.Branch
    io.Memread := instDecode.io.Memread
    io.Regwrite := instDecode.io.Regwrite
    io.MemtoReg := instDecode.io.MemtoReg
    io.Aluoperation:= instDecode.io.Aluoperation
    io.OperandAsel :=instDecode.io.OperandAsel
    io.OperandBsel :=instDecode.io.OperandBsel
    io.Extendsel := instDecode.io.Extendsel
    io.Nextpcsel := instDecode.io.Nextpcsel

}
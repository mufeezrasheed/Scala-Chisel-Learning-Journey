import chisel3 . _
import chisel3 . util . _
class MemoryIO extends Bundle {
    val Address=Input(UInt(32.W))
    val Datain=Input(SInt(32.W))
    val Dataout=Output(SInt(32.W))
    val Load=Input(Bool())
    val Store=Input(Bool())
}

class Memory extends Module{
    val io =IO(new MemoryIO)
    val Datamemory = SyncReadMem (32 , SInt (32. W ) )
    when ( io .Store ) {
Datamemory.write ( io.Address , io.Datain)
}
io .Dataout := Datamemory.read ( io .Address , io .Load )
}

    

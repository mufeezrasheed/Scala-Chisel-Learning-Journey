import chisel3._
import chisel3.util.experimental.loadMemoryFromFile

class instmemory extends Module {
  val io = IO (new Bundle {
	val wrAddr = Input(UInt(10.W))
	val rdData = Output(UInt(32.W))
  })
	val mem = SyncReadMem(1024,UInt(32.W))
	io.rdData := mem.read(io.wrAddr)
	loadMemoryFromFile(mem,"/home/mufeez/Scala-Chisel-Learning-Journey/instmem.txt")
}
//memory file
  
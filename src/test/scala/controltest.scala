import chisel3._ 
 import chiseltest._ 
  import org.scalatest.freespec.AnyFreeSpec

//   import chiseltest.experimental.TestOptionBuilder._ 
 import chiseltest.simulator.VerilatorBackendAnnotation

 class controltest extends AnyFreeSpec with ChiselScalatestTester {
     "Controltest" in {
         test(new Control()) {dut=>
          dut.io.opcode.poke("h37".U)
          dut.io.Memread.expect(false.B)
          dut.io.Regwrite.expect(true.B)
          dut.io.MemtoReg.expect(false.B)
          dut.io.Memwrite.expect(false.B)
          dut.io.Branch.expect(false.B)
          dut.io.Aluoperation.expect("b110".U)
          dut.io.OperandAsel.expect("b11".U)
          dut.io.OperandBsel.expect(true.B)
          dut.io.Nextpcsel.expect("b00".U)
          dut.io.Extendsel.expect("b01".U)


          
     }
 }
 }
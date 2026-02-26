import chisel3._ 
 import chiseltest._ 
  import org.scalatest.freespec.AnyFreeSpec

//   import chiseltest.experimental.TestOptionBuilder._ 
 import chiseltest.simulator.VerilatorBackendAnnotation

 class memorytest extends AnyFreeSpec with ChiselScalatestTester {
      "memtest" in {
          test(new Memory()) {dut=>
          dut.io.Address.poke(1.U)
          dut.io.Store.poke(true.B)
         dut.io.Datain.poke(5.S)
         dut.io.Load.poke(true.B)
         dut.clock.step(1)
         dut.io.Store.poke(false.B)
         dut.clock.step(10)
                }
     }
 }
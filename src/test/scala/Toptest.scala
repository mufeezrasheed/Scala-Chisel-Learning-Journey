import chisel3._ 
 import chiseltest._ 
  import org.scalatest.freespec.AnyFreeSpec

//   import chiseltest.experimental.TestOptionBuilder._ 
 import chiseltest.simulator.VerilatorBackendAnnotation

 class Toptest extends AnyFreeSpec with ChiselScalatestTester {
     "finaltest" in {
         test(new Top()) {dut=>
         dut.clock.step(2)
         }
     }
 }
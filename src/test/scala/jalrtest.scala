import chisel3._ 
  import chiseltest._ 
   import org.scalatest.freespec.AnyFreeSpec

 //   import chiseltest.experimental.TestOptionBuilder._ 
  import chiseltest.simulator.VerilatorBackendAnnotation

   class jalrtest extends AnyFreeSpec with ChiselScalatestTester {
     "jalr" in {
         test(new Jalr()) {dut=>
         dut.io.inA.poke(0.S)
         dut.io.inB.poke(9.S)
         dut.io.Address.expect(8.S)
               }}}
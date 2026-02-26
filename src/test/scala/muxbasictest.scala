// import chisel3._ 
// import chiseltest._ 
//  import org.scalatest.freespec.AnyFreeSpec

//  import chiseltest.experimental.TestOptionBuilder._ 
// import chiseltest.simulator.VerilatorBackendAnnotation

// class muxbasictest extends AnyFreeSpec with ChiselScalatestTester {
//     "muxgood" in {
//         test(new muxbasic()) {dut=>
//         dut.io.in_A.poke(true.B)
//         dut.io.in_B.poke(false.B)
//         dut.io.select.poke(false.B)
//          dut.io.out.expect(false.B)        }
//     }
// }
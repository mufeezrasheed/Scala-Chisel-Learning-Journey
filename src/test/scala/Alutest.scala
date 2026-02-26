// import chisel3._ 
//  import chiseltest._ 
//   import org.scalatest.freespec.AnyFreeSpec

// //   import chiseltest.experimental.TestOptionBuilder._ 
//  import chiseltest.simulator.VerilatorBackendAnnotation

//  class Alutest extends AnyFreeSpec with ChiselScalatestTester {
//      "alutest" in {
//          test(new ALU()) {dut=>
//          dut.io.in0.poke(2.U)
//          dut.io.in1.poke(4.U)
//          dut.io.sel.poke(16.U)
//         //  dut.io.out.expect("b100".U)
//          dut.io.branch.expect(true.B)
//                }
//      }
// }
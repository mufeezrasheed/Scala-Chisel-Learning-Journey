// import chisel3._ 
//  import chiseltest._ 
//   import org.scalatest.freespec.AnyFreeSpec

// //   import chiseltest.experimental.TestOptionBuilder._ 
//  import chiseltest.simulator.VerilatorBackendAnnotation

//  class instmemtest extends AnyFreeSpec with ChiselScalatestTester {
//       "instmemtest" in {
//           test(new instmemory()) {dut=>
//           dut.io.wrAddr.poke(0.U)
//           dut.io.rdData.expect("h00000093".U)
//          dut.clock.step(10)
//                 }
//      }
//  }
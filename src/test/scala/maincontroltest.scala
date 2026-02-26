// import chisel3._ 
//  import chiseltest._ 
//   import org.scalatest.freespec.AnyFreeSpec

// //   import chiseltest.experimental.TestOptionBuilder._ 
//  import chiseltest.simulator.VerilatorBackendAnnotation

//  class maincontroltest extends AnyFreeSpec with ChiselScalatestTester {
//      "regtest" in {
//          test(new maincontrol()) {dut=>
//           dut.io.rs1add.poke(5.U)
//           dut.io.rs2add.poke(4.U)
//           dut.io.rdadd.poke(4.U)
//           dut.io.Regwrite.poke(false.B)
//           dut.io.rddata.poke(5.S)
//           dut.clock.step(10)}
//      }
//  }
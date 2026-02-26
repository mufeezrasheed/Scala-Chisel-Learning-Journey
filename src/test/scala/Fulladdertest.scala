// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._
// import chisel3._ 
// import chiseltest._ 
// import org.scalatest.freespec.AnyFreeSpec

// // import chiseltest.experimental.TestOptionBuilder._ 
// import chiseltest.simulator.VerilatorBackendAnnotation

// class Fulladdertest extends AnyFreeSpec with ChiselScalatestTester {
//     "carry HOGA" in {
//         test(new Fulladder()) {{ dut=>
//         dut.io.a.poke(true.B)
//         dut.io.b.poke(true.B)
//         dut.io.cin.poke(false.B)
//         dut.io.s.expect(false.B)
//         dut.io.cout.expect(true.B)
//         }
//     }
// }}
import chromaprint.quick._

val file = new java.io.File("/audio/Pocket Calculator.flac")
val fingerprint = Fingerprinter(file).unsafeRunSync()

println(fingerprint.compressed)
// AQADtNQYhYkYnGhw7X...

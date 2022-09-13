package io.github.maxkar

package anagrams.boa

/**
 * The main application.
 */
object App:
  def main(args: Array[String]): Unit =
    if args.isEmpty then
      System.err.println(s"Usage: java -jar <app.jar> <word-to-lookup>")
      System.exit(1)

    val lookup = loadLookup()
    lookup
      .getAnagrams(args(0))
      .foreach(println)
  end main


  /** Loads the lookup. */
  private def loadLookup(): AnagramLookup =
    val stream = this.getClass().getResourceAsStream("/words.txt")
    try
      val source = scala.io.Source.fromInputStream(stream, "UTF-8")
      val words = source.getLines().map(_.trim).toSeq
      AnagramLookup.fromWords(words)
    finally
      if (stream != null)
        stream.close
    end try
  end loadLookup
end App

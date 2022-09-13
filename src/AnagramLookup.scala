package io.github.maxkar

package anagrams.boa

/**
 * Provides lookup for anagrams.
 *
 * @param lookupTable map from the "canonical" form to the list
 *   of anagrams.
 */
final class AnagramLookup private(
      lookupTable: Map[String, Seq[String]]):
  import AnagramLookup._

  /**
   * Returns dictionary anagrams for the given word.
   */
  def getAnagrams(word: String): Seq[String] =
    lookupTable.getOrElse(canonicalForm(word), Seq.empty)

end AnagramLookup


object AnagramLookup:
  /** Builds canonical form of the word. */
  private def canonicalForm(word: String): String =
    word.toLowerCase().sorted


  /**
   * Creates anagram lookup that uses the given list of words
   * as anagrams.
   */
  def fromWords(words: Seq[String]): AnagramLookup =
    new AnagramLookup(words.groupBy(canonicalForm))

end AnagramLookup

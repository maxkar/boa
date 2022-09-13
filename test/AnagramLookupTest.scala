package io.github.maxkar

package anagrams.boa

/**
 * Tests for the anagram lookup.
 */
final class AnagramLookupTest extends org.scalatest.funsuite.AnyFunSuite:
  test("Simple anagrams are looked up") {
    val lookup = AnagramLookup.fromWords(Seq(
      "aaba",
      "booba",
      "ababa",
    ))

    assert(lookup.getAnagrams("aaba") === Seq("aaba"))
    assert(lookup.getAnagrams("abaa") === Seq("aaba"))
    assert(lookup.getAnagrams("oobba") === Seq("booba"))
    assert(lookup.getAnagrams("boaob") === Seq("booba"))
  }


  test("Absent words return empty seq") {
    val lookup = AnagramLookup.fromWords(Seq(
      "aaba",
      "booba",
      "ababa",
    ))

    assert(lookup.getAnagrams("SSzeN") === Seq())
  }


  test("Multiple anagrams could be returned") {
    val lookup = AnagramLookup.fromWords(Seq(
      "aaba",
      "abaa",
      "baaa",
      "booba",
      "aboob",
    ))

    assert(lookup.getAnagrams("aaab").toSet === Set("aaba", "abaa", "baaa"))
    assert(lookup.getAnagrams("aaab").size === 3)

    assert(lookup.getAnagrams("boaob").toSet === Set("booba", "aboob"))
    assert(lookup.getAnagrams("boaob").size === 2)
  }

  test("Lookup is case-insesnitive") {
    val lookup = AnagramLookup.fromWords(Seq(
      "Anna",
    ))

    assert(lookup.getAnagrams("naan") === Seq("Anna"))
  }
end AnagramLookupTest

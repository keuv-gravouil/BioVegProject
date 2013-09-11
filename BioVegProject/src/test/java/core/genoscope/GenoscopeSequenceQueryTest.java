package core.genoscope;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import core.sequence.AnnotatedSequence;

public class GenoscopeSequenceQueryTest {

	private static GenoscopeVitisSequenceQuery genoscopeVitisSequenceQuery;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		genoscopeVitisSequenceQuery = new GenoscopeVitisSequenceQuery("GSVIVT01019504001");
	}

	@Test
	public void testGetSequence() throws Exception {
		String expectedSeq = "atacagccatctttctggtttttccctctctctctctctctctcatttaaccatggctgagactgttattgaaatccccatggctgttccgataaagaaggcaaggaccagcaggaaggcgctgaaggagaagagctcttcaacgaataaggcaaacatcttggccggacagatctcagagtcctctccggcgccagttccgacgccgtctgaggacgccggaaaggagaaccacgagagcctgtcacagcctctgtccgggaagaagaagagtaaaggggctcagaaagggaagaaatcgaaggagtcccagtcgtttgagagggacttgcaagaaatgcaggaaaagcttgagcaattgcggcttgagaaggagaagacggaggagttattgaaggctagagacgagatgttgaagatcaaggaggaagagctcgagacaaggggtcgagagcaggagaagcttcagatggagttgaagaaattgcagaagttgaaggagttcaaacccaccgtggttcgttttcttgatttctttctccattcccccccccccccccctttttttgtgtttggtgtccaagaatattgaagtgtggaaaaagtaattttgaattttatggtttaatggatatttctttattggaatctttcttgatattctttttaatttccttttctttccagcgtttttactagcaaacaaccagactattaattcctttgcatatctgggttttaagtattagatttcattttcttgaccttcttcagattctttcttaagtttgttagttttttttttcttccattttattagcaaccaaacagaccattgtgattcttgatttctgctttcaagggtttgatttgatttttatcggtctttctttggatattcccttttaatttcactttcctgatctttctttcagacatttccacttcactctctgagagataaagaacaagaaaagaaggagaagaacaaaaagggctgcccagaaacgaaaaggccatctccgtcatatgtactctggtgcaaggatcagtggaatgaggtaaatgagagaaaataggttccgaagaagaaattgaatttgactccaaaacctagaaattcatctgtatttttgaacgtaggccaagaaagcaaaccccgatgcagacttcaaggagatctcaaatattttgggggctaaatggaagacaatcagcgcagaagagaagaagccatatgaggagaagtatcaggctgagaaggaagcctatttgcagatagtggggaaggagaagcgcgaaaatgaagccatgaggctgttggaagaggagcagaagcagaagacagctatggagttgcttgagcaatatctccagttcaaacagggagcagaaaaggagaacaagaagaaaaagtaaagccccattaatctccccccttcctctgttccattctgaaaattttctctttttttttagaaaaggacccgctaatctccctcgcttcctctctgcttctctctaatttttttctcaactcttttacaggaaagagaaggacccattgaaaccgaagcatcctgtatcagcattttttttgttctcaaaggaaaggcgagcagctctgcttggagaggataagaatgttttagaggtagctgatgattagaatctgggtggttttttttttttttttttctctcttggaattcgtttctactgatttgagctaatttgaaggttgggtattttgatagattgccaagattgctggtgaagagtggaagaacatgacggagaagcagaaacgcccttacgaagaggttcatctcatgacctctctgtttctgtctttgtttctctctgcagcttggtctcttacaatttccatcgaaaacttgcagattgcaaagaaaaataaggcaaagtatcaggaagaaatggagttgtacaaacagcagaaggatgaagaagctgaagatctcaagaagggagaggaggagcagatgaaaatccagaaacatgaagcattacaactgctcaagaagaaagaaaaaaccgaaaatataatcaaggttcttcaacgttgtcaccataaatttgtgggtattgttggtttcaaaacttattcagcagctaatctgtggtttgaatatagaaaaccaaggagaatcgccagaagaagaagaagcagaaggaaaaggccaactctgatccaaacaagcctaagaagccggcatcctcattcctcctattcaggtatatatcaatcagggatatttttcgggattttctggctttttagattatgattcaataaggaaattgttcttgttctctgcagcaaagaagcaaggaatagtttcctgcaagagcgaccaggaataaacaattccaccctcaatgctctgatttcagtgaaatggaaggtattatcatttctcctttctcttttggagtgtgacattgagaatttctgtaagtttctatttgcaaatttacccatttgggccgttttgtacaggagttggatgaggaagagaggaaaatctggaatgacaaagctaaggaagctatggaagcataccagaaggaactagaggaatataacaagtctgctgcaaccatatctgacaagccacagcaatgaagaatgtgaagtgctgttgatgttcaagtggttatgttgaacataaagtagaacgtctggccttcaagttcactggcccttttttggttgatcagtattctgttatcttgcaatttcttaggatgtttttgttgccaactgatggaaaatctgcaaaaaattctcacatgttgcgagtcttgagattgactgattgttggaaaaagcaaattccaaaaattccaattctggattttccctttcattaatgaaatctaaatggcccttgcctacgtttccatt";
		AnnotatedSequence seq = genoscopeVitisSequenceQuery.getAnnotatedSequence();
		
		assertThat(seq.getSequence(), is(expectedSeq));
	}

	@Test
	public void testGetSequenceLength() throws Exception {
		int expectedLenght = 2932;
		AnnotatedSequence seq = genoscopeVitisSequenceQuery.getAnnotatedSequence();
		
		assertThat(seq.getSequenceLenght(), is(expectedLenght));
	}
}
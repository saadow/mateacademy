package lesson11;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import lessson11.StringChangerService;
import lessson11.StringLowerUpperService;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StringChangerServiceMockSpyUnitTest {

	@Spy
	@InjectMocks
	private StringChangerService changerService;
	@Mock
	private StringLowerUpperService lowerUpperService;

	@Before
	public void beforeAll() {
		when(lowerUpperService.toLower("lower")).thenReturn("lower");
		when(lowerUpperService.toUpper("UPPER")).thenReturn("UPPER");
		when(lowerUpperService.toUpper("End")).thenReturn("END");
		when(lowerUpperService.toLower("UPPERlowerEnd")).thenReturn("upperlowerend");
	}

	@Test
	public void testAddStartUpperInputLower() {
		String expected = "UPPERlower";
		String actual = changerService.addStartUpperInputLower("UPPER", "lower");
		verify(lowerUpperService, times(1)).toLower("lower");
		verify(lowerUpperService, times(1)).toUpper("UPPER");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddStartUpperInputLowerExpectedRofl() {
		String expected = "nulllower";
		String actual = changerService.addStartUpperInputLower(null, "lower");
		verify(lowerUpperService, times(1)).toLower("lower");
		assertEquals(expected, actual);
	}

	@Test
	public void testAddStartAndEnd() {
		String expected = "UPPERlowerEnd";
		doReturn("UPPERlower").when(changerService).addStart("UPPER", "lower");
		String actual = changerService.addStartAndEnd("UPPER", "End", "lower");
		verify(changerService, times(1)).addStart("UPPER", "lower");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddStartAndEndNullChecker() {
		doReturn("").when(changerService).addStart(null, "lower");
		String actual = changerService.addStartAndEnd(null, "End", "lower");
		// making null not equal to "null"
		verify(changerService, times(0)).addStart("null", "lower");
		assertEquals("End", actual);
	}

	@Test
	public void testAddStartAndEndUpper() {
		String expected = "UPPERlowerEND";
		doReturn("UPPERlower").when(changerService).addStart("UPPER", "lower");
		String actual = changerService.addStartAndEndUpper("UPPER", "End", "lower");
		verify(changerService, times(1)).addStart("UPPER", "lower");
		verify(lowerUpperService, times(1)).toUpper("End");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddStartAndEndTotalLower() {
		String expected = "upperlowerend";
		doReturn("UPPERlower").when(changerService).addStart("UPPER", "lower");
		String actual = changerService.addStartAndEndTotalLower("UPPER", "End", "lower");
		verify(changerService, times(1)).addStart("UPPER", "lower");
		assertEquals(expected, actual);
	}
}

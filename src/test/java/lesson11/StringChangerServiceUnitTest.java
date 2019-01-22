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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StringChangerServiceUnitTest {
	@Spy
	@InjectMocks
	private StringChangerService stringChangerService;
	@Mock
	private StringLowerUpperService lowerUpperService;
	
	
	@Test
	public void testAddStartUpperInputLower() {
		String expected = "UPPERlower";
		String actual = stringChangerService.addStartUpperInputLower("UPPER", "lower");
		assertEquals(expected, actual);
	}
	
	@Before
	public void beforeAll() {
		when(lowerUpperService.toLower("lower")).thenReturn("lower");
		when(lowerUpperService.toUpper("UPPER")).thenReturn("UPPER");
		//when(lowerUpperService.toUpper("end")).thenReturn("END");
		//when(lowerUpperService.toLower("null")).thenThrow(new NullPointerException());
		//doReturn("lower").when(lowerUpperService).toLower("lower");
		//doReturn("UPPER").when(lowerUpperService).toUpper("UPPER");
	}
	
	@Test
	public void testAddStartAndEnd() {
		String expected = "UPPERlowerEnd";
		doReturn("UPPERlower").when(stringChangerService).addStart("UPPER", "lower");
		String actual = stringChangerService.addStartAndEnd("UPPER", "End", "lower");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddStartAndEndUpper() {
		String expected = "UPPERlowerEND";
		doReturn("UPPERlower").when(stringChangerService).addStart("UPPER", "lower");
		when(lowerUpperService.toUpper("END")).thenReturn("END");
		String actual = stringChangerService.addStartAndEndUpper("UPPER", "END", "lower");
		assertEquals(expected, actual);
	}
	@Test
	public void testAddStartAndEndTotalLower() {
		doReturn("UPPERlower").when(stringChangerService.addStart("UPPER", "lower"));
		when(lowerUpperService.toUpper("END")).thenReturn("END");
		when(lowerUpperService.toLower("UPPERlowerEND")).thenReturn("upperlowerend");
		stringChangerService.addStartAndEndTotalLower("UPPER", "END", "lower");
		verify(lowerUpperService).toLower("UPPERlowerEND");
	}
}

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

public class MonkeyTest{
	private static List<Monkey> _monkeyList = new LinkedList<Monkey>();
	@Before
	public void setUp(){
		Banana b = new Banana();
		for(int i=0; i<=160; i++){
			_monkeyList.add(new Monkey());
			if(i==100) _monkeyList.get(i).throwBananaTo(b); //throw banana 100 to the monkey
		}
	}
	//make sure the refactored generateId method still creates the same ID's given a monkey number
	@Test
	public void generateIdFirstMonkeys(){
		Monkey z=_monkeyList.get(0); //this is actually monkey 0
		Monkey f=_monkeyList.get(1); //act
		assertEquals(z.getMonkeyNum(), 0); //this is to make sure we are comparing ID values with correct monkeyNum values. 
		assertEquals(f.getMonkeyNum(), 1);
		try{
			assertEquals(z.getId(), 223492);
			assertEquals(f.getId(), 223493);
		} catch (NoIdException nie) {
			fail();
		}
		
	}

	//make sure the refactored generateId method still creates the same ID's given a monkey number
	@Test
	public void generateHighNumId(){
		Monkey l=_monkeyList.get(160);
		assertEquals(l.getMonkeyNum(), 160); //make sure we have the right monkey to compare ID on
		try{
			assertEquals(l.getId(), 223652);
		} catch (NoIdException nie) {
			fail();
		}
	}
	//Make sure the refactored monkeyWithBanana method still returns the index of the monkey with the banana
	@Test
	public void testHasBanana(){
		int bananaInd=MonkeySim.monkeyWithBanana(_monkeyList);
		assertEquals(bananaInd, 100);
	}

	//Make sure the refactored monkeyWithBanana method still returs -1 if no monkey has a banana
	@Test
	public void testNoBanana(){
		_monkeyList.get(100).throwBananaFrom();//should make this monkey throw away the banana
		int bananaInd=MonkeySim.monkeyWithBanana(_monkeyList);
		assertEquals(bananaInd, -1);
	}



}
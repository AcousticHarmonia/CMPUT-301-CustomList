package listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Test class for MainActivity. All the UI tests are written here.
 */
public class MainActivityTest {

    private CustomList list;

    @BeforeEach
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void hasCityTest(){

    }

    @Test
    public void deleteCityTest(){
        City city = new City("Halifax", "NS");
        list.addCity(city);
        assertEquals(list.getCount(), 1);
        list.delete(city);
        assertEquals(list.getCount(), 0);
    }

    @Test
    public void countCityTest(){

    }

}//end MainActivityTest

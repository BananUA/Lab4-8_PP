package Toy;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static Toy.Toy.arrayToy;
import static org.junit.Assert.*;

public class ToyTest {
    @BeforeClass
    public static void Setup() {
        Toy toy = new Toy("LegoCity", "Big", "Lego", "China", 500);
        arrayToy.add(toy);
    }

    @Test
    public void addToy() {
        Toy expected = new Toy("LegoCity", "Big", "Lego", "China", 500);
        Toy actual = new Toy();
        Toy temp = new Toy();
        temp.addToy("LegoCity", "Big", "Lego", "China", 500);
        actual = arrayToy.get(arrayToy.size() - 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateToyName() {
        String expected = "Lego11";
        String actual;
        Toy temp = new Toy();
        temp.updateToy(1, "name", "Lego11");
        actual = arrayToy.get(0).getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateToySize() {
        String expected = "Medium";
        String actual;
        Toy temp = new Toy();
        temp.updateToy(1, "size", "Medium");
        actual = arrayToy.get(0).getSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateToyBrand() {
        String expected = "Tango";
        String actual;
        Toy temp = new Toy();
        temp.updateToy(1, "brand", "Tango");
        actual = arrayToy.get(0).getBrand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateToyCountry() {
        String expected = "Ukraine";
        String actual;
        Toy temp = new Toy();
        temp.updateToy(1, "country", "Ukraine");
        actual = arrayToy.get(0).getCountry();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateToyPrice() {
        Float expected = Float.valueOf(700);
        Float actual;
        Toy temp = new Toy();
        temp.updateToy(1, "price", "700");
        actual = arrayToy.get(0).getPrice();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void deleteToy() {
        int expected = arrayToy.size();
        int actual;
        Toy temp = new Toy();
        Toy temp2 = new Toy("LegoCity", "Big", "Lego", "China", 500);
        arrayToy.add(temp2);

        temp.deleteToy(arrayToy.size());
        actual = arrayToy.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Save_Load_Toy() {
        int expected = arrayToy.size();
        int actual;
        Toy temp = new Toy();
        temp.SaveToy();
        temp.LoadToy();
        actual = arrayToy.size();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void sortByPrice() {
        Toy expected = new Toy();
        Toy actual = new Toy();
        expected = arrayToy.get(0);
        Toy temp = new Toy("LegoCity", "Big", "Lego", "China", 333);
        Toy temp2 = new Toy();
        arrayToy.add(temp);
        temp2.SortByPrice();
        actual = arrayToy.get(0);
        Assert.assertEquals(expected, actual);

    }
}
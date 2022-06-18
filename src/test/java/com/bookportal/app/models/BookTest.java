package com.bookportal.app.models;

import com.bookportal.app.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void testEqualsObject(){
//        final Book itemA=new Book();
//        final Book itemB=new Book(1,"Book 1","Author 1");
//        final Book itemC=new Book(1,"Book 2","Author 2");
//        final Object nonObject=new Object();
//        Assertions.assertTrue(itemA.equals(itemA));
//        Assertions.assertTrue(itemB.equals(itemB));
//        Assertions.assertFalse(itemC.equals(itemB)); //id cannot be same as it is unique
//        Assertions.assertFalse(itemA.equals(itemB));
//        Assertions.assertFalse(itemA.equals(nonObject));
    }

    @Test
    public void testGettersSettersId()
    {
//        final Book itemA=new Book();
//        itemA.setSlNo(67L);
//        Assertions.assertEquals(67L,itemA.getSlNo());
    }

    @Test
    public void testGettersSettersName()
    {
        final Book itemA=new Book();
        itemA.setName("Hello");
        Assertions.assertEquals("Hello",itemA.getName());
    }

    @Test
    public void testGettersSettersAuthor()
    {
//        final Book itemA=new Book();
//        itemA.setSlNo(23L);
//        itemA.setAuthor("New");
//        Assertions.assertEquals("New",itemA.getAuthor());
    }

}

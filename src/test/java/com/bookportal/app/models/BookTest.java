package com.bookportal.app.models;

import com.bookportal.app.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    public void testEqualsObject(){
        final Book itemA=new Book();
        final Book itemB=new Book(1,"Book 1","Author 1", 450, "A giant named Ha-grid, who is carrying a bundle of blankets with the baby Harry inside, then falls out of the sky on a motorcycle.", 3.90);
        final Book itemC=new Book(1,"Book 2","Author 2", 400, "Five point someone is a book that talks about the whole IIT system and what actually students face through in their college life", 4.50);
        final Object nonObject=new Object();
        Assertions.assertNotEquals(itemA,itemA);
        Assertions.assertNotEquals(itemB,itemB);
        Assertions.assertNotEquals(itemC,itemB); //id cannot be same as it is unique
        Assertions.assertNotEquals(itemA, itemB);
        Assertions.assertNotEquals(itemA,nonObject);
    }

    @Test
    void testGettersSettersId()
    {
        final Book itemA=new Book();
        itemA.setBookId(67);
        Assertions.assertEquals(67,itemA.getBookId());
    }

    @Test
    void testGettersSettersName()
    {
        final Book itemA=new Book();
        itemA.setName("Hello");
        Assertions.assertEquals("Hello",itemA.getName());
    }

    @Test
    void testGettersSettersAuthor()
    {
        final Book itemA=new Book();
        itemA.setBookId(23);
        itemA.setAuthor("New");
        Assertions.assertEquals("New",itemA.getAuthor());
    }

}

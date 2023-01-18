package de.ithoc.webblog.persistence;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.ithoc.webblog.model.Post;

public class DataStoreTest {
    
    @Test
    public void next_index() {
        DataStore dataStore = new DataStore();

        dataStore.nextId();
        Integer nextIndex = dataStore.nextId();

        Assertions.assertEquals(2, nextIndex);
    }

    @Test
    public void create_post() {
        Post post = new Post();
        DataStore dataStore = new DataStore();

        Post createdPost = dataStore.create(post);

        Assert.assertSame(post.getId(), createdPost.getId());
    }

    @Test
    public void read_post() {
        Post post = new Post();
        DataStore dataStore = new DataStore();
        Post createdPost = dataStore.create(post);
        
        Post read = dataStore.read(createdPost.getId());

        Assertions.assertEquals(createdPost.getId(), read.getId());
    }

    @Test
    public void update_post() {
        Post post = new Post();
        post.setTitle("My Title");
        DataStore dataStore = new DataStore();
        Post createdPost = dataStore.create(post);
        Post read = dataStore.read(createdPost.getId());

        read.setTitle("Your Title");
        Post update = dataStore.update(read);

        Assertions.assertEquals("Your Title", update.getTitle());
    }

    @Test
    public void delete_post() {
        // Testdaten vorbereiten
        Post post = new Post();
        post.setTitle("Titel 1");
        post.setContent("Content 1");

        DataStore dataStore = new DataStore();
        dataStore.create(post);

        // Logik ausführen
        dataStore.delete(1);

        // Ergebnisse verifizieren
        Post post2 = dataStore.read(1);
        Assertions.assertTrue(post2 == null);
    }

    @Test
    public void check_unique_ids() {
        Post post1 = new Post();
        Post post2 = new Post();

        DataStore dataStore = new DataStore();
        Post savedPost1 = dataStore.create(post1);
        Post savedPost2 = dataStore.create(post2);

        Assert.assertTrue(savedPost1.getId() == savedPost2.getId() -1);

    }

}

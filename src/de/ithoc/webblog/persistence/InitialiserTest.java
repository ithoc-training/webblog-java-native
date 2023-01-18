package de.ithoc.webblog.persistence;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.ithoc.webblog.model.Post;

public class InitialiserTest {
    
    @Test
    public void read_content() throws IOException, URISyntaxException {
        Initialiser initialiser = new Initialiser();

        List<String> csvLines = initialiser.readContent("posts.csv");

        Assertions.assertEquals(50, csvLines.size());
    }

    @Test
    public void create_posts() throws URISyntaxException, IOException {
        Initialiser initialiser = new Initialiser();
        List<String> csvLines = initialiser.readContent("posts.csv");
        
        List<Post> createPosts = initialiser.createPosts(csvLines);

        Assertions.assertEquals(50, createPosts.size());
    }

}

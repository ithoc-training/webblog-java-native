package de.ithoc.webblog.domain;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import de.ithoc.webblog.model.Post;
import de.ithoc.webblog.persistence.Initialiser;

public class Webblog {
    
    private List<Post> posts;


    /**
     * Default constructor creates some initial posts to start with.
     * 
     * @throws URISyntaxException
     * @throws IOException
     */
    public Webblog() throws URISyntaxException, IOException {
        Initialiser initialiser = new Initialiser();
        List<String> readContent = initialiser.readContent("posts.csv");
        CsvToPostMapper csvToPostMapper = new CsvToPostMapper();
        List<Post> posts = csvToPostMapper.convert(readContent);
        
        this.posts = posts;
    }
    

    public List<Post> getPosts() {
        return posts;
    }
    
}

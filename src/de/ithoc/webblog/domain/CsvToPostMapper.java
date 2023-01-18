package de.ithoc.webblog.domain;

import java.util.ArrayList;
import java.util.List;

import de.ithoc.webblog.model.Post;

public class CsvToPostMapper {
    
    public CsvToPostMapper() {
    }

    public Post convert(String csvLine) {
        String[] fields = csvLine.split(";");

        Post post = new Post();
        post.setId(Integer.parseInt(fields[0]));
        post.setTitle(fields[1]);        
        post.setContent(fields[2]);
        
        return post;
    }

    public List<Post> convert(List<String> csvLines) {
        List<Post> posts = new ArrayList<>(csvLines.size());
        for(String line : csvLines) {
            Post post = convert(line);
            posts.add(post);
        }

        return posts;
    }

}

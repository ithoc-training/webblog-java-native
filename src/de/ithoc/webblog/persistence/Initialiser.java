package de.ithoc.webblog.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import de.ithoc.webblog.domain.CsvToPostMapper;
import de.ithoc.webblog.model.Post;

public class Initialiser {
    
    private CsvToPostMapper csvToPostMapper = new CsvToPostMapper();


    public Initialiser() {
    }


    public List<String> readContent(String fileName) throws URISyntaxException, IOException {
        URL resource = this.getClass().getResource("posts.csv");
        Path path = Paths.get(resource.toURI());
        List<String> allLines = Files.readAllLines(path, Charset.defaultCharset());

        return allLines;
    }
    
    public List<Post> createPosts(List<String> csvLines) throws FileNotFoundException {
        List<Post> posts = csvToPostMapper.convert(csvLines);

        return posts;
    }

}

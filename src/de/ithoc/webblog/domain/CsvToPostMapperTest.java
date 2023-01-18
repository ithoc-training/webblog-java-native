package de.ithoc.webblog.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.ithoc.webblog.model.Post;

public class CsvToPostMapperTest {
    
    @Test
    public void csv_line_to_post() {
        String csvLine = "13;13. Post;13. Post is Post no. 13";
        CsvToPostMapper csvToPostMapper = new CsvToPostMapper();
        
        Post convert = csvToPostMapper.convert(csvLine);    

        Assertions.assertEquals(13, convert.getId());
        Assertions.assertEquals("13. Post", convert.getTitle());
        Assertions.assertEquals("13. Post is Post no. 13", convert.getContent());
    }

    @Test
    public void multiple_csv_lines_to_post_list() {
        CsvToPostMapper csvToPostMapper = new CsvToPostMapper();
        String csvLine13 = "13;13. Post;13. Post is Post no. 13";
        String csvLine14 = "14;14. Post;14. Post is Post no. 14";
        
        List<Post> posts = csvToPostMapper.convert(Arrays.asList(csvLine13, csvLine14));;    

        Assertions.assertEquals(13, posts.get(0).getId());
        Assertions.assertEquals("13. Post", posts.get(0).getTitle());
        Assertions.assertEquals("13. Post is Post no. 13", posts.get(0).getContent());

        Assertions.assertEquals(14, posts.get(1).getId());
        Assertions.assertEquals("14. Post", posts.get(1).getTitle());
        Assertions.assertEquals("14. Post is Post no. 14", posts.get(1).getContent());
    }

}

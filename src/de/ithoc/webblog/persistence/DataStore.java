package de.ithoc.webblog.persistence;

import java.util.HashMap;

import de.ithoc.webblog.model.Post;

/**
 * Storage to keep the posts with their IDs as key.
 */
public class DataStore {
    
    private HashMap<Integer, Post> map = new HashMap<>();

    /* Store last maximum index to ensure IDs are unique. */
    private Integer lastId = 0;


    public Integer nextId() {
        lastId = lastId + 1;
        return lastId;
    }

    public Post create(Post post) {
        post.setId(nextId());
        map.put(post.getId(), post);
        
        return post;
    }

    public Post read(Integer id) {

        return map.get(id);
    }

    public Post update(Post post) {
        map.put(post.getId(), post);
        
        return post;
    }

    public void delete(Integer id) {
        map.remove(id);
    }

}

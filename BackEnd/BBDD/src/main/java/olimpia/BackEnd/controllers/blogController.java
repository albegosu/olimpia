package olimpia.BackEnd.controllers;

import olimpia.BackEnd.models.blogModel;
import olimpia.BackEnd.services.blogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*")
public class blogController {

    @Autowired
    blogService myService;

    @GetMapping()
    public ArrayList<blogModel> getPosts(@RequestParam(required = false) String type){
        return myService.getPosts(type);
    }


    @PostMapping
    public blogModel setPosts(@RequestBody blogModel newPost){
        return myService.setPosts(newPost);
    }

    @DeleteMapping(path="/delete/{id}")
    public String deletePost(@PathVariable int id){
        return myService.deletePost(id);
    }

    @PutMapping(path="/update/{id}")
    public blogModel updatePost(@RequestBody int id, @RequestBody blogModel newPost){
        return myService.setPosts(myService.updatePost(id, newPost));
    }
}

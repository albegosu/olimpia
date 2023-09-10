package olimpia.BackEnd.services;

import olimpia.BackEnd.models.blogModel;
import olimpia.BackEnd.repositories.blogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class blogService {

    @Autowired
    blogRepository myRepo;


    public ArrayList<blogModel> getPosts(String type) {
        if (type == null || type.isEmpty()) {
            return new ArrayList<>((Collection) myRepo.findAll());
        } else {
            return new ArrayList<>(myRepo.findByBlogTitle(type));
        }
    }


    public blogModel getOneProduct(int id){
        try{
            return myRepo.findById(id).orElse(null);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String deletePost(int id) {
        try{
            myRepo.deleteById(id);
            return "Record "+id+" was successfully deleted.";
        }
        catch(Exception e){
            return "Unable to delete record: \n"+e.getMessage();
        }
    }

    public blogModel setPosts(blogModel newProduct) {
        try{
            return myRepo.save(newProduct);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public blogModel updatePost(int id, blogModel newPost) {
        try{
            blogModel toUpdatePost= myRepo.findById(id).get();
            toUpdatePost.setBlogTitle(newPost.getBlogTitle());
            toUpdatePost.setBlogMessage(newPost.getBlogMessage());

            return toUpdatePost;

        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}


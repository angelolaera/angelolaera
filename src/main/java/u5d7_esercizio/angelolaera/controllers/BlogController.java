package u5d7_esercizio.angelolaera.controllers;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import u5d7_esercizio.angelolaera.entities.Blog;
import u5d7_esercizio.angelolaera.services.BlogServices;

import java.util.List;

@RestController
@RequestMapping("/blog")

public class BlogController {

    @Autowired
    private BlogServices blogServices;

    // 1. GET http://localhost:3001/blog
    @GetMapping
    private List<Blog> getAllBlogs(){
        return blogServices.findAll();
    }

    // 2. GET http://localhost:3001/blog{blogId}
    @GetMapping("/{blogId}")
    private Blog getBlogById(@PathVariable int blogId){
        return blogServices.findById(blogId);
    }

    // 3. POST http://localhost:3001/(+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Blog createBlog(@RequestBody Blog body){
        return blogServices.saveBlog(body);
    }

    // 4. PUT http://localhost:3001/{blogId}(+body)
    @PutMapping("/{blogId}")
    private Blog findBlogByIdAndUpdate(@PathVariable int blogId,@RequestBody Blog body){
        return blogServices.findByBlogAndUpdate(blogId,body);
    }


    // 5. DELETE http://localhost:3001/{blogId}
    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteBlog(@PathVariable int blogId){
        blogServices.findByIdAndDelete(blogId);
    }
}



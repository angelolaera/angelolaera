package u5d7_esercizio.angelolaera.services;

import org.springframework.stereotype.Service;
import u5d7_esercizio.angelolaera.entities.Blog;
import u5d7_esercizio.angelolaera.exceptions.NotFoundExceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service

public class BlogServices {

    private List<Blog> blogList = new ArrayList<>();

    public List<Blog> findAll(){
        return this.blogList;
    }

    public Blog saveBlog(Blog body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1,1000));
        this.blogList.add(body);
        return body;
    }

    public Blog findById(int blogId){
        Blog found = null;
        for(Blog blog:this.blogList){
            if (blog.getId() == blogId) found=blog;
        }
        if (found==null)throw new NotFoundExceptions(blogId);
        return found;
    }

    public Blog findByBlogAndUpdate(int blogId, Blog updateblog){
        Blog found = null;
        for (Blog blog:this.blogList){
            if(blog.getId()==blogId){
                found=blog;
                found.setTitolo(updateblog.getTitolo());
                found.setCategoria(updateblog.getCategoria());
                found.setContenuto(updateblog.getContenuto());
                found.setCover(updateblog.getCover());
                found.setTempo_lettura_minuti(updateblog.getTempo_lettura_minuti());
            }
        }
        if (found==null) throw new NotFoundExceptions(blogId);
        return found;
    }

    public void findByIdAndDelete(int blogId){
        Blog found = null;
        for (Blog blog:this.blogList){
            if(blog.getId()==blogId)found=blog;
        }
        if(found == null)throw new NotFoundExceptions(blogId);
        this.blogList.remove(found);
    }

}

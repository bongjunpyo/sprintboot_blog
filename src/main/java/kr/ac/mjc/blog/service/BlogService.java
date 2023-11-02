package kr.ac.mjc.blog.service;


import kr.ac.mjc.blog.domain.Article;
import kr.ac.mjc.blog.dto.AddArticleRequest;
import kr.ac.mjc.blog.dto.UpdateArticleRequest;
import kr.ac.mjc.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    @Autowired //달아주는 이유는 생성을 해서 써야되는데 바로 save라는 메소드를 호출시키기 위해서
  private BlogRepository blogRepository;

  public Article save(AddArticleRequest request){

      return blogRepository.save(request.toEntity());
  }

  public List<Article> findAll(){
      List<Article> articles=blogRepository.findAll();
      return articles;
  }

  public Article findOne(long id){
      Article article=blogRepository.findById(id).orElseThrow();
      return article;
  }

  public void delete(long id){
      blogRepository.deleteById(id);
  }

  @Transactional
  public Article update(long id, UpdateArticleRequest request){
      Article article=blogRepository.findById(id).orElseThrow();
      article.update(request.getTitle(),request.getContent());
      return article;
  }
}

package com.broadcom.observabilitydemo.post;

import io.micrometer.observation.annotation.Observed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Manoj Ramakrishnan (rmanoj@vmware.com).
 * @since 1/4/24 3:35 PM
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {
  private final JsonPlaceholderService jsonPlaceholderService;

  public PostController(JsonPlaceholderService jsonPlaceholderService){
      this.jsonPlaceholderService = jsonPlaceholderService;
  }
    @GetMapping("")
    @Observed(name = "posts.findAll", contextualName = "post-controller.find-all")
    List<Post> findAll(){
        return jsonPlaceholderService.findAll();
    }
}

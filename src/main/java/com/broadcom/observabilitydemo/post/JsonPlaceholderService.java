package com.broadcom.observabilitydemo.post;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

/**
 * @author Manoj Ramakrishnan (rmanoj@vmware.com).
 * @since 1/4/24 3:37 PM
 */
public interface JsonPlaceholderService {

    @GetExchange("/posts")
    List<Post> findAll();
    @GetExchange("/posts/{id}")
    List<Post> findById(@PathVariable Integer id);
}

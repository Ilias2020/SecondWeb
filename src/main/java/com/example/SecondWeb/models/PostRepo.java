package com.example.SecondWeb.models;

import com.example.SecondWeb.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long>{
}

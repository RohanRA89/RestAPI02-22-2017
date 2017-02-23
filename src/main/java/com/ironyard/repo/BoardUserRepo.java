package com.ironyard.repo;

import com.ironyard.data.BoardUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by rohanayub on 2/22/17.
 */
public interface  BoardUserRepo extends PagingAndSortingRepository<BoardUser, Long>{
}

package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by tristangreeno on 5/5/16.
 */
public interface MessageRepo extends CrudRepository<Message, Integer> {
}

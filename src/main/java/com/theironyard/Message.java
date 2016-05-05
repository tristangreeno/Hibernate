package com.theironyard;

import javax.persistence.*;

/**
 * Created by tristangreeno on 5/5/16.
 */
@Entity
@Table(name = "microblog")
public class Message {
    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    String text;

    public Message(){}

    public Message(String text) {
        this.text = text;
    }
}

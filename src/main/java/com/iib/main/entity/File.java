package com.iib.main.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@javax.persistence.Entity
@Table(name = "hey")
public class File {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
 
    private String name;
    private String type;
    @Lob
    private byte[] data;
    public File() {
    }
    public File(String name, String type, byte[] data) {
     this.name = name;
     this.type = type;
     this.data = data;
   }
    // Getters and Setters
}

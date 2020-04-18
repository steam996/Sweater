package com.example.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //говорит что нужно сохранять в базу данных
public class Message {
    // говорит, что Id - идентификатор
    @Id
    //создаем связь между БД и фреймворком и задаем автоматическую генерацию
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // текстовое поле в котором будет хранится текст сообщения
    private String text;
    //текстовое поле в котором будут хранится теги
    private String tag;

    public Message() {
    }

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}


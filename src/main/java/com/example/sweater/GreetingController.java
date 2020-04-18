package com.example.sweater;
import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "index";
    }

    //описываем Mapping обрабатывающий входящую инфориацию
    @PostMapping
    //
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        // создаем новый экз. класса Message и передаем в него значение полей ввода text и tag
        Message message = new Message(text, tag);

        //сохраняем сообщения в БД
        messageRepo.save(message);

        //Возвращаем список сообщений из БД
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        //возвращаем главную страницу
        return "index";
    }

}
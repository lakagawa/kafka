package br.com.fiap.dataintegration.kafkaproducer.controller;

import br.com.fiap.dataintegration.kafkaproducer.producer.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class KafkaController {

    private final TopicProducer topicProducer;

    @GetMapping(value = "/kafka")
    public void send(){
        topicProducer.send("Enviando mensagem para o kafka");
    }
}

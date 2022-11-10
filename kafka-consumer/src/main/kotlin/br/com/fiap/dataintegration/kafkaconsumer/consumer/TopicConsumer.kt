package br.com.fiap.dataintegration.kafkaconsumer.consumer

import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Slf4j
@Service
@RequiredArgsConstructor
class TopicConsumer {
    @Value("\${topic.name.consumer}")
    private val topicName:String = ""

    @KafkaListener(topics = ["\${topic.name.consumer}"], groupId = "group_id")
    fun consume(payload : ConsumerRecord<String, String>) {
        println("Tópico:  $topicName")
        println("Key: ${payload.key()}")
        println("Headers: ${payload.headers()}")
        println("Partition: ${payload.partition()}")
        println("Message: ${payload.value()}")
    }
}
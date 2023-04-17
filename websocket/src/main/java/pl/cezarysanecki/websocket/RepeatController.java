package pl.cezarysanecki.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
class RepeatController {

  private static final AtomicInteger COUNTER = new AtomicInteger(1);
  private static RepeatWord SAVED_WORD_TO_REPEAT = new RepeatWord("default");

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping("/save-word")
  @PostMapping
  ResponseEntity<Void> saveWordToRepeat(RepeatWord repeatWord) {
    assignNewWord(repeatWord);
    resetCounter();
    return ResponseEntity.ok().build();
  }

  @Scheduled(fixedRate = 2_000)
  void repeat() {
    RepeatResponse response = new RepeatResponse(
        SAVED_WORD_TO_REPEAT.value(),
        COUNTER.getAndIncrement());
    simpMessagingTemplate.convertAndSend("/topic/repeat", response);
  }

  private static void assignNewWord(RepeatWord repeatWord) {
    SAVED_WORD_TO_REPEAT = repeatWord;
  }

  private static void resetCounter() {
    COUNTER.set(1);
  }
}

record RepeatWord(String value) {
}

record RepeatResponse(String content, int numberOfRepetitions) {
}
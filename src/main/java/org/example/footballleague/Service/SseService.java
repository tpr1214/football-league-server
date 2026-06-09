package org.example.footballleague.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SseService {
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SseEmitter addEmitter() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        this.emitters.add(emitter);
        emitter.onCompletion(() -> this.emitters.remove(emitter));
        emitter.onTimeout(() -> this.emitters.remove(emitter));
        return emitter;
    }

    public void broadcastMatchUpdate(Object eventData) {
        // שולח לכל הדפדפנים המחוברים עדכון חי על גול או שינוי זמן
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(SseEmitter.event().name("match-update").data(eventData));
            } catch (Exception e) {
                emitters.remove(emitter);
            }
        }
    }
}

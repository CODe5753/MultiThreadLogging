package com.example.multithreadlogging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class BookingService {

    public BaseResponse<?> booking(BookingDto bookingDto) {
        Random random = new Random();
        try {
            // 100 ~ 500까지 랜덤
            int randomSleep = random.nextInt(401) + 100;

            // 일정 확률로 실패하는 상황을 가정
            if (randomSleep == 101) {
                throw new RuntimeException();
            }

            log.info("expect sleep: {}", randomSleep);

            Thread.sleep(randomSleep);
            return new BaseResponse<>(HttpStatus.OK.value(), true, "booking success");
        } catch (Exception e) {
            throw new RuntimeException("booking failed");
        }
    }
}

package com.example.multithreadlogging;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/book")
    public BaseResponse<?> bookTicket(BookingDto bookingDto) {
        return bookingService.booking(bookingDto);
    }

}

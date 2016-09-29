package com.domain.service.reservation;

/**
 * Created by nishina on 2016/09/29.
 */
public class AlreadyReservedException extends RuntimeException {
    public AlreadyReservedException(String message) {
        super(message);
    }
}

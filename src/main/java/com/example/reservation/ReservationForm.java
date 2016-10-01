package com.example.reservation;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * Created by nishina on 2016/09/29.
 */
@Data
@EndTimeMustBeAfterStartTime(message = "終了時刻は開始時刻より後にしてください")
public class ReservationForm implements Serializable {
    @NotNull(message = "必須です")
    @ThirtyMinutesUnit(message = "30分単位で入力してください")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @NotNull(message = "必須です")
    @ThirtyMinutesUnit(message = "30分単位で入力してください")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;
}

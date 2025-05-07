package ch15.sec06.exam01;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter

public class Coin {
    private int value;

    @Override
    public String toString() {
        return "꺼내온 동전 : " + value + "원";
    }
}

package ch15.sec06.exam02;

import lombok.*;

@AllArgsConstructor

public class Message {
    public String command;
    public String to;

    @Override
    public String toString() {
        if (this.command.equals("sendMail"))
            return to + "님에게 메일을 보냅니다.";
        else if(this.command.equals("sendSMS"))
            return to + "님에게 SMS를 보냅니다.";
        else
            return to + "님에게 카카오톡을 보냅니다.";
    }
}

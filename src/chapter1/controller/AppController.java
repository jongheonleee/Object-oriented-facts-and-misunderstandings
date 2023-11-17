package chapter1.controller;

import chapter1.domain.RemoteControl;
import chapter1.domain.Tv;
import java.util.Scanner;

/**
 * 역할 : 애플리케이션의 흐름을 제어, 사용자의 입력값을 누가 처리해줄 것이며, 특정 작업을 어떤 객체들이 처리해줄지 판단을하는 것
 *
 */
public class AppController {
    private final Scanner scanner;
    private final RemoteControl remoteControl;
    private final Tv tv;

    public AppController(Scanner scanner, RemoteControl remoteControl, Tv tv) {
        this.scanner = scanner;
        this.remoteControl = remoteControl;
        this.tv = tv;
    }


    public void play() {
        askTurnOnTv();
        precess();
    }

    private void precess() {
        do {
            changeChannel();
            showCurrentChannel();
        } while(restart());
    }

    private Boolean restart() {
        System.out.println("계속 티비 채널을 바꿀껀가요? (1:네, 2:아니요)");
        String input = getInput();
        Integer answer = Integer.parseInt(input);
        if (answer == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void askTurnOnTv() {
        System.out.println("티비를 켜주세요 (1:킴, 2:안킴)");
        String input = getInput();
        Integer answer = Integer.parseInt(input);
        if (answer == 1) {
            Boolean sign = remoteControl.pressSwitchButtonForOn();
            tv.turnOnOROff(sign);
        } else {
            Boolean sign = remoteControl.pressSwitchButtonForOff();
            tv.turnOnOROff(sign);
        }
    }

    private Integer askChannelUpOrDown() {
        System.out.println("채널을 올리시나요? 내리시나요? (1:올림, 2:내림)");
        String answer = getInput();
        return Integer.parseInt(answer);
    }

    private Integer requestChangeChannel(Integer answer) {
        if (answer == 1) {
            return requestChangedAmountForUp();
        } else {
            return requestChangedAmountForDown();
        }
    }

    private Integer requestChangedAmountForUp() {
        System.out.println("얼만큼 채널을 변경할 건가요?");
        Integer count = Integer.parseInt(getInput());
        Integer amount = remoteControl.pressUpButton(count);
        return amount;
    }

    private Integer requestChangedAmountForDown() {
        System.out.println("얼만큼 채널을 변경할 건가요?");
        Integer count = Integer.parseInt(getInput());
        Integer amount = remoteControl.pressDownButton(count);
        return amount;
    }

    private void changeChannel() {
        Integer answer = askChannelUpOrDown();
        Integer amount = requestChangeChannel(answer);
        tv.changeChannel(amount);
    }

    private void showCurrentChannel() {
        Integer channel = tv.getChannel();
        if (channel == -1) {
            System.out.println("채널을 변경할 수 없습니다.");
        } else {
            System.out.printf("현재 채널은 %d 입니다", channel);
            System.out.println();
        }
    }

    private String getInput() {
        return scanner.next();
    }
}

package chapter1.domain;

/**
 * TV 에게 채널을 얼만큼 변경할지, 전원은 킬지 말지 메시지를 보내는 역할
 * Imp2 : 채널 변경 단위가 2
 */
public class RemoteControlImp2 implements RemoteControl {

    private static final Integer MIN_COUNT = 0;
    public static final Integer MAX_COUNT = 100;
    private static final Integer CANT_CHANGE = 0;
    private static final Integer UP = 2;
    private static final Integer DOWN = -2;
    private static final Boolean ON = true;
    private static final Boolean OFF = false;

    public Integer pressUpButton(Integer count) {
        if (isCountInRange(count)) {
            return UP * count;
        }
        return CANT_CHANGE;
    }

    public Integer pressDownButton(Integer count) {
        if (isCountInRange(count)) {
            return DOWN * count;
        }
        return CANT_CHANGE;
    }

    private Boolean isCountInRange(Integer count) {
        return MIN_COUNT < count && count < MAX_COUNT;
    }

    public Boolean pressSwitchButtonForOn() {
        return ON;
    }

    public Boolean pressSwitchButtonForOff() {
        return OFF;
    }
}

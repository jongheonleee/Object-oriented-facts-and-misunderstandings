package chapter1.domain;

/**
 * 리모컨 객체로 부터 전원과 채널을 변경해달라는 메시지를 전달 받음
 * 자신의 필드의 값을 보고, 변경 여부를 결정하는 것은 TV 객체임
 */
public class Tv {
    private static final Boolean ON = true;
    private static final Boolean OFF = false;
    private static final Integer MIN_CHANNEL = 0;
    private static final Integer MAX_CHANNEL = 100;
    private static final Integer NO_CHANNEL = -1;

    private Boolean power;
    private Integer channel;

    public Tv() {
        power = false;
        channel = 0;
    }

    public void turnOnOROff(Boolean sign) {
        if (sign == true) {
            power = ON;
        }
        else if (sign == false){
            power = OFF;
        }
    }

    public void changeChannel(Integer amount) {
        if (isTvOn() && canChangeChannel(channel + amount)) {
            channel += amount;
        }
    }

    private Boolean canChangeChannel(Integer channel) {
        return MIN_CHANNEL <= channel && channel <= MAX_CHANNEL;
    }

    private Boolean isTvOn() {
        return power;
    }

    public Integer getChannel() {
        if (isTvOn()) {
            return channel;
        }
        return NO_CHANNEL;
    }

}
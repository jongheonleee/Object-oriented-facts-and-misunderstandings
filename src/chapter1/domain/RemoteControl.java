package chapter1.domain;

/**
 *
 * 역할 : 사용자가 입력한 정보를 TV 객체가 이해할 수 있는 신호로 변경해서 보내주는 것
 *
 * 객체의 역할이 있다는 것은, 대체 가능하다는 의미
 * - 리모콘 객체의 역할 : TV 전원, 채널 변경 내용을 전달
 * - 객체는 다른 객체가 "무엇"을 하는지 알지만, "어떻게" 하는지 알지 못한다
 * - TV 객체는 리모콘 객체가 전원, 채널에 대한 변경 내용을 전달하지만, 그 어떤식으로 변경되는지 알지못함
 * - Imp1, Imp2가 있다 서로 채널을 변경해달라는 메시지를 전달하는 것은 알지만
 * - "Imp1은 1 * count 만큼으로 변경, Imp2는 2 * count 만큼 변경" 과 같이 세부적인 내용은 알지 못함
 */
public interface RemoteControl {
    Integer pressUpButton(Integer count);
    Integer pressDownButton(Integer count);
    Boolean pressSwitchButtonForOn();
    Boolean pressSwitchButtonForOff();
}

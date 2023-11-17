package chapter1.domain;

public class RemoteControl {

    private static final Integer UP = 1;
    private static final Integer DOWN = -1;
    private static final Boolean ON = true;
    private static final Boolean OFF = false;

    public Integer pressUpButton(Integer count) {
        return UP * count;
    }

    public Integer pressDownButton(Integer count) {
        return DOWN * count;
    }

    public Boolean pr
}

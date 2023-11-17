import chapter1.controller.AppController;
import chapter1.domain.RemoteControlImp1;
import chapter1.domain.Tv;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoteControlImp1 remoteControl = new RemoteControlImp1();
        Tv tv = new Tv();

        AppController appController = new AppController(scanner, remoteControl, tv);
        appController.play();
    }
}
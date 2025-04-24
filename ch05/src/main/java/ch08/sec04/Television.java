package ch08.sec04;

public class Television implements RemoteControl{
    int volume;
    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void setVolume(int volume) {
        if(volume > RemoteControl.MAX_VOLUME)
            this.volume = RemoteControl.MAX_VOLUME;
        else if(volume < RemoteControl.MIN_VOLUME)
            this.volume = RemoteControl.MIN_VOLUME;
        else
            this.volume = volume;
        System.out.println("현재 TV 볼륨: "+this.volume);
    }
}

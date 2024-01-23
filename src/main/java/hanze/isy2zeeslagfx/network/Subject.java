package hanze.isy2zeeslagfx.network;

public interface Subject {

    public void registerObserver(InputListener inputListener);
    public void removeObserver(InputListener inputListener);
    public void notifyObservers();

}

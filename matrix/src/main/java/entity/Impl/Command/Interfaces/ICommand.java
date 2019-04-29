package entity.Impl.Command.Interfaces;

public interface ICommand {
    void execute();
    ICommand copy();
}

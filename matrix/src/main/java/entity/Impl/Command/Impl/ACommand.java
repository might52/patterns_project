package entity.Impl.Command.Impl;

import entity.Impl.Command.CommandManager;
import entity.Impl.Command.Interfaces.ICommand;
import entity.Interfaces.IMatrix;

public class ACommand implements ICommand {
    protected CommandManager commandManager;
    protected IMatrix matrix;

    @Override
    public void execute() {
        this.register();
    }

    public ACommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    protected ACommand(IMatrix matrix, CommandManager commandManager) {
        this.matrix = matrix;
        this.commandManager = commandManager;
    }

    protected void register() {
        System.out.println(String.format("register the command: %s", this.getClass().getName()));
        commandManager.registry(this);
    }

    @Override
    public ICommand copy() {
        return new ACommand(matrix, commandManager);
    }

    public void undo(){

    }

}

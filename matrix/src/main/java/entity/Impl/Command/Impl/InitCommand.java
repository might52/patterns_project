package entity.Impl.Command.Impl;

import entity.Impl.Command.CommandManager;
import entity.Impl.Command.Interfaces.ICommand;
import entity.Interfaces.IMatrix;

public class InitCommand extends ACommand {
    public InitCommand(CommandManager commandManager) {
        super(commandManager);
    }

    public InitCommand(IMatrix matrix, CommandManager commandManager) {
        super(matrix, commandManager);
    }

    @Override
    public void execute() {
        super.register();
    }

    @Override
    public ICommand copy() {
        return super.copy();
    }


}

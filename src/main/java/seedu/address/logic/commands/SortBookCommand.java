package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;

/**
 * Sort all books in provided order.
 */
public class SortBookCommand extends Command {

    public static final String COMMAND_WORD = "sortBook";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": sort all books in certain order"
        + "the specified keywords (case-insensitive).\n"
        + "Parameters: [st/TYPE]...[o/ORDER]...\n"
        + "TYPE can only be author, name or rating\n"
        + "ORDER can only be asc or des\n"
        + "Example: " + COMMAND_WORD + " st/rating o/asc";

    public static final String MESSAGE_SUCCESS = "Sorted successfully";

    private final String type;

    private final String order;

    public SortBookCommand(String type, String order) {
        this.type = type;
        this.order = order;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);

        model.sortBook(type, order);
        model.commitBookShelf();
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof SortBookCommand // instanceof handles nulls
            && this.order.equals(((SortBookCommand) other).order)
            && this.type.equals(((SortBookCommand) other).type));
    }
}
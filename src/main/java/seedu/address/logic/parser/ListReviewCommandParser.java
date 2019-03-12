package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ListReviewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.book.BookName;
import seedu.address.model.book.BookNameContainsExactKeywordsPredicate;

/**
 * Parses input arguments and creates a new ListReviewCommand object
 */
public class ListReviewCommandParser {
    /**
     * Parses the given {@code String} of arguments in the context of the ListReviewCommand
     * and returns an ListReviewCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListReviewCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListReviewCommand.MESSAGE_USAGE));
        }

        return new ListReviewCommand(new BookNameContainsExactKeywordsPredicate(new BookName(trimmedArgs)));
    }
}
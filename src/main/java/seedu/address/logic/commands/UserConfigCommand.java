package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ALLERGIES;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.user.UserProfile;

/**
 * Sets User Profile of HackEat user.
 */
public class UserConfigCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "config";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a user's personal details to HackEat. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_ADDRESS + "ADDRESS "
            + PREFIX_ALLERGIES + "ALLERGIES";

    public static final String MESSAGE_SUCCESS = "User profile updated";

    private final UserProfile toAdd;

    /**
     * Creates a UserConfigCommand to add the specified {@code UserProfile}
     */
    public UserConfigCommand(UserProfile profile) {
        requireNonNull(profile);
        toAdd = profile;
    }

    @Override
    public CommandResult executeUndoableCommand() throws CommandException {
        requireNonNull(model);
        model.addUserProfile(toAdd);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UserConfigCommand // instanceof handles nulls
                && toAdd.equals(((UserConfigCommand) other).toAdd));
    }
}

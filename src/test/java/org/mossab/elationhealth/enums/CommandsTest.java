package org.mossab.elationhealth.enums;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mossab on 9/6/17.
 *
 * @author: mossab
 */
public class CommandsTest {
    @Test
    public void testFindByStringWorks() {
        String result = "result";
        Assert.assertEquals(Commands.parseCommand(result), Commands.RESULT);

        String update = "update";
        Assert.assertEquals(Commands.parseCommand(update), Commands.UPDATE);

        String help = "help";
        Assert.assertEquals(Commands.parseCommand(help), Commands.UNKNOWN);

        String random = "aiwehg";
        Assert.assertEquals(Commands.parseCommand(random), Commands.UNKNOWN);
    }
}
package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This tests the functions, using junit 4.13, of the class MemoryStore and MemoryRecall
 * {@link MemoryStore}
 * {@link MemoryRecall}
 *
 * @author      Arthur Junod
 * @author      Edwin Haeffner
 * Date :       04/12/2023
 */
public class MemoryStoreAndRecallTest {
    State state = new State();

    /**
     * Test that MemoryStore and MemoryRecall work properly
     */
    @Test
    public void testMemoryStoreAndRecall(){
        state.current = "43";
        new MemoryStore(state).execute();
        assertEquals("43", state.current);
        assertEquals(43, MemoryStore.getMem(), 0.001);
        state.current = "0";
        new MemoryRecall(state).execute();
        assertEquals("43.0", state.current);
    }

    /**
     * Test that neither MemoryStore nor MemoryRecall does nothing
     * when the error flag is true
     */
    @Test
    public void testError(){
        state.current = "53";
        state.error = true;
        new MemoryStore(state).execute();
        assertEquals(0, MemoryStore.getMem(), 0.001);
        new MemoryRecall(state).execute();
        assertEquals("53", state.current);
    }



}

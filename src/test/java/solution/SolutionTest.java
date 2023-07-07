package solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import solution.Solution;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Testing solution")
    void test() {
        String sampleText = "The Tao gave birth to machine language.  Machine language gave birth\n" +
                "to the assembler.\n" +
                "The assembler gave birth to the compiler.  Now there are ten thousand\n" +
                "languages.\n" +
                "Each language has its purpose, however humble.  Each language\n" +
                "expresses the Yin and Yang of software.  Each language has its place within\n" +
                "the Tao.\n" +
                "But do not program in COBOL if you can avoid it.\n" +
                "        -- Geoffrey James, \"The Tao of Programming\"";


        Character result = solution.solve(sampleText);

        Assertions.assertEquals('m', result);
    }

    @Test
    @DisplayName("Final testing solution")
    void test3() {
        String sampleText = "C makes it easy for you to shoot yourself in the foot. " +
                "C++ makes that harder, but when you do, it blows away your whole leg. (с) Bjarne Stroustrup";

        Character result = solution.solve(sampleText);

        Assertions.assertEquals('e', result);
    }

}
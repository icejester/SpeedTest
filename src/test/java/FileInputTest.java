import org.jrm.io.FileInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileInputTest {

    FileInput fi;

    @BeforeEach
    void setUp()
    {
        fi = new FileInput("./src/test/java/FileInputTest.java");
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("You should be able to read a file")
    @Test
    void readFile() { assertEquals("import org.jrm.io", fi.readFile().substring(0,17), "Substring 28 of this file should contain import statement"); }

    @DisplayName("You should be able to read the first line of a file")
    @Test
    void readLine() { assertEquals("import org.jrm.io.FileInput;", fi.readLine(), "First line of file should contain import statement"); }
}
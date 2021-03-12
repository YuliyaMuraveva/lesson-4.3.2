package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    void setUp() {
        manager.register(".JPG", "Paint");
        manager.register(".pdf", "Adobe Acrobat Reader");
        manager.register(".html", "Google Chrome");
        manager.register(".Jpg", "Adobe Photoshop");
    }

    @Test
    void shouldGetApplicationName() {
        String actual = manager.getApplicationName(".html");
        String expected = "google chrome";
        assertEquals(expected, actual);
    }

    @Test
    void shouldDelete() {
        manager.delete(".jpg");
        List<String> actual = manager.getAllExtensions();
        List<String> expected = List.of(".html", ".pdf");
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAllName() {
        List<String> actual = manager.getAllName();
        List<String> expected = List.of("adobe acrobat reader", "adobe photoshop", "google chrome");
        assertEquals(expected, actual);
    }
}

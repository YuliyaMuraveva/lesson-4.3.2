package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileOpenManager {
    private Map<String, String> fileOpenManager = new HashMap<>();

    public void register(String fileExtension, String applicationName) {
        fileOpenManager.put(fileExtension.toLowerCase(), applicationName.toLowerCase());
    }

    public String getApplicationName(String fileExtension) {
        return fileOpenManager.get(fileExtension.toLowerCase());
    }

    public void delete(String fileExtension) {
        fileOpenManager.remove(fileExtension.toLowerCase());
    }

    public List<String> getAllExtensions() {
        Set<String> setResult = new HashSet<>(fileOpenManager.keySet());
        List<String> listResult = new ArrayList<>(setResult);
        Collections.sort(listResult);
        return listResult;
    }

    public List<String> getAllName() {
        Set<String> setResult = new HashSet<>(fileOpenManager.values());
        List<String> listResult = new ArrayList<>(setResult);
        Collections.sort(listResult);
        return listResult;
    }
}

package javaNIO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;
import java.util.Map;

public class TextFileOperations {

    final String PATH_TO_FILE = "file.txt";

    final Path path = Path.of(PATH_TO_FILE);

    public List<String> readDataFromFile() throws IOException {
        List<String> lines = Files.readAllLines(path);
        return lines;
    }

    public void writeDataToFile(Path pathToFile, String data) throws IOException {
        Files.writeString(path, data);
    }
    public void writeDataToFile(Path pathToFile, List<String> data) throws IOException {
        for (String line : data) {
            Files.writeString(pathToFile, line);
        }
    }

    /**
     * Creates basic working directory within fileSystem. If directory already exists and is empty deletes it,
     * otherwise mark it as working directory.
     * @param dirLocation
     * @return created path to working directory
     * @throws IOException can throw an exception
     */
    private Path createBasicRootDirectory(Path dirLocation) throws IOException {
        var pathToDir = Path.of("dir");
        pathToDir = pathToDir.resolve(dirLocation);
        if (!Files.exists(pathToDir)) {
            Files.createDirectory(pathToDir);
        } else {
            Files.delete(pathToDir);
        }
        var customAttributes = Files.getFileAttributeView(pathToDir, UserDefinedFileAttributeView.class);
        String typeDirectory = "customType";
        String value = "working";
        customAttributes.write(typeDirectory, StandardCharsets.UTF_8.encode(value));
        return pathToDir;
    }

    public Path createWorkingDirectory(Path dirLocation) throws IOException {
        Path pathToDir = createBasicRootDirectory(dirLocation);
        System.out.println("Working directory was successfully created");
        return pathToDir;
    }

    public boolean isWorkingDirectory(Path dirLocation) throws IOException {
        var attributes = Files.readAttributes(dirLocation, "*");
        return attributes.containsKey("working");
    }

    public Path createUserFile(Path pathToFile, String extension) throws IOException {
        Path resolvedFilePath = pathToFile.resolve(extension);
        return createFile(resolvedFilePath);
    }

    public void createUserFile(List<Path> pathToFiles) throws IOException {
        for (Path pathToFile : pathToFiles) {
            createFile(pathToFile);
        }
    }

    public Path createUserFile(Path pathToFile, Map<String, String> attributes) throws IOException {
        createFile(pathToFile);
        var customAttributesBuilder = Files.getFileAttributeView(pathToFile, UserDefinedFileAttributeView.class);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            customAttributesBuilder.write(entry.getKey(),
                    StandardCharsets.UTF_8.encode(entry.getKey()));
        }
        return pathToFile;
    }

    private Path createFile(Path toFile) throws IOException {
        if (!isWorkingDirectory(toFile.getParent())) {
            throw new RuntimeException("U trying to create a file outside the working directory");
        }
        return Files.createFile(toFile);
    }

    //TODO: create file with specific permissions
}

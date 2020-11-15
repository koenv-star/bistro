package be.multimedi.jammik.tools;

import be.multimedi.jammik.entities.Zaak;
import be.multimedi.jammik.repositories.ZaakRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Gemaakt door Jan
 */
@Component
public class ImageTool {

    @Value("${location}")
    private String location;

    private ZaakRepository zaakRepository;

    @Autowired
    public ImageTool(ZaakRepository zaakRepository) {
        this.zaakRepository = zaakRepository;
    }

    public Map<String, byte[]> getAllImagesFromFolder() throws IOException {

        File dir = new File(location);
        String imageName;
        byte[] imageBytes;
        HashMap<String, byte[]> images = new HashMap<>();

        if (dir.isDirectory()) {

            for (File file : Objects.requireNonNull(dir.listFiles())) {

                imageName = file.getName();
                imageBytes = FileUtils.readFileToByteArray(file);
                images.put(imageName, imageBytes);
            }
        }

        return images;
    }

    public String putImageInFolder(MultipartFile file, Zaak zaak) throws IOException {

        // put the image in the images folder
        int nameLength = Objects.requireNonNull(file.getOriginalFilename()).length();
        int beginPosition = file.getOriginalFilename().contains(".jpeg") ? nameLength - 5 : nameLength - 4;
        String extension = file.getOriginalFilename().substring(beginPosition);

        String imageUrl = zaak.getEmail().toLowerCase() + "_" +
                zaak.getNaam().toLowerCase() + extension;

        file.transferTo(new File(location + "\\" + imageUrl));

        return imageUrl;
    }

    public void deleteImage(int zaakId) throws Exception {

        Zaak zaak = zaakRepository.findById(zaakId).get();
        String imageName = zaak.getImageURL();
        File dir = new File(location);

        if (dir.isDirectory()) {

            for (File file : Objects.requireNonNull(dir.listFiles())) {

                if (file.getName().equals(imageName))
                    Files.deleteIfExists(Paths.get(location + "\\" + imageName));
            }
        }
    }

    public void deleteImage(String imageUrl) throws Exception {

        File dir = new File(location);

        if (dir.isDirectory()) {

            for (File file : Objects.requireNonNull(dir.listFiles())) {

                if (file.getName().equals(imageUrl))
                    Files.deleteIfExists(Paths.get(location + "\\" + imageUrl));
            }
        }
    }
}

package com.example.demo.service.impl;

import com.example.demo.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private ServletContext app;

    @Override
    public File save(MultipartFile file, String folder) {
        File dir = new File(app.getRealPath("/assets/admin/"+folder));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String s =System.currentTimeMillis()+file.getOriginalFilename();
        String name =Integer.toHexString(s.hashCode())+s.substring(s.lastIndexOf("."));
        try {
            File saveFile = new File(dir, file.getOriginalFilename());
            file.transferTo(saveFile);
            return saveFile;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

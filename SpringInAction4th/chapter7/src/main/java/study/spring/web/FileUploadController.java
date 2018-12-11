package study.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String uploadForm() {
        return "uploadForm";
    }

    //MultipartFile
    //Part : 업로드 설정이 필요없음
    @RequestMapping(method = RequestMethod.POST)
    public String processUpload(@RequestPart("file") MultipartFile file) {

        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());
        //file.transferTo("경로");

//	  System.out.println(file.getSubmittedFileName());
//	  System.out.println(file.getSize());

        return "redirect:/";
    }

}

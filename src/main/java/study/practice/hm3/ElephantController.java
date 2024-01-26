package study.practice.hm3;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ElephantController {
    @PostMapping("/save-elephant")
    public String saveElephant(@RequestBody JSONObject requestBody) {
        Elephant elephant = Elephant.fromJson(requestBody);
        ElephantService.saveToTxtFile(elephant);
        return "Elephant saved successfully!";
    }
    @GetMapping("/get-elephant")
    public ArrayList getElephant() {
        return ElephantService.getElephantsJson( "elephants.txt");
    }

    @GetMapping("/changeHashCode")
    public String changeHashCode(@RequestParam boolean useBooleanMembers) {
        if (useBooleanMembers) {
            ElephantService.changeHashCodeWithBooleanMembers();
        } else {
            ElephantService.changeHashCodeWithoutBooleanMembers();
        }
        return "HashCode method changed successfully";
    }
}


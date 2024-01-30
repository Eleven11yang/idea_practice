package study.practice.hm3;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/changeHashCode")
    public String changeHashCode(@RequestParam boolean useHashCode) {
        if (useHashCode) {
            ElephantService.changeHashCodeWithBooleanMembers();
        } else {
            ElephantService.changeHashCodeWithoutBooleanMembers();
        }
        return "HashCode method changed successfully";
    }
}


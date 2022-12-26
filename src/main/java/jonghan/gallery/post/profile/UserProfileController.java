package jonghan.gallery.post.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-profile")
@CrossOrigin("*")
public class UserProfileController {

    private final UserprofileService userprofileService;


    @Autowired
    public UserProfileController(UserprofileService userprofileService) {
        this.userprofileService = userprofileService;
    }

    @GetMapping
    public List<UserProfile> getUserProfiles(){
        return userprofileService.getUserProfiles();
    }

    @PostMapping(
            path = "{userProfileId}/Image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId,
                                       @RequestParam("file")MultipartFile file){
        userprofileService.uploadUserProfileImage(userProfileId,file);
    }

    @GetMapping("{userProfileId}/Image/download")
    public byte[] downloadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId){
        return userprofileService.downloadUserProfileImage(userProfileId);
    }
}

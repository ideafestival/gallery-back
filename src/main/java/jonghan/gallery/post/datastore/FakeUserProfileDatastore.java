package jonghan.gallery.post.datastore;


import jonghan.gallery.post.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeUserProfileDatastore {
    private final static List<UserProfile> USER_PROFILES = new ArrayList<>();


    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}

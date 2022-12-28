package jonghan.gallery.infra.post.profile;


import jonghan.gallery.infra.post.datastore.FakeUserProfileDatastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserprofileDataAccessService {


    private final FakeUserProfileDatastore fakeUserProfileDatastore;

    @Autowired
    public UserprofileDataAccessService(FakeUserProfileDatastore fakeUserProfileDatastore) {
        this.fakeUserProfileDatastore = fakeUserProfileDatastore;
    }

    List<UserProfile> getUserProfiles(){
        return fakeUserProfileDatastore.getUserProfiles();
    }
}
